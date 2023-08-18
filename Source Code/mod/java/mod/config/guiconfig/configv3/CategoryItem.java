

package kr.syeyoung.dungeonsguide.mod.config.guiconfig.configv3;

import kr.syeyoung.dungeonsguide.mod.features.AbstractFeature;
import kr.syeyoung.dungeonsguide.mod.guiv2.BindableAttribute;
import kr.syeyoung.dungeonsguide.mod.guiv2.Widget;
import kr.syeyoung.dungeonsguide.mod.guiv2.elements.Navigator;
import kr.syeyoung.dungeonsguide.mod.guiv2.xml.AnnotatedImportOnlyWidget;
import kr.syeyoung.dungeonsguide.mod.guiv2.xml.annotations.Bind;
import kr.syeyoung.dungeonsguide.mod.guiv2.xml.annotations.On;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.util.function.Supplier;

public class CategoryItem extends AnnotatedImportOnlyWidget {

    @Bind(variableName = "name")
    public final BindableAttribute<String> name = new BindableAttribute<>(String.class);
    @Bind(variableName = "description")
    public final BindableAttribute<String> description = new BindableAttribute<>(String.class);
    @Bind(variableName = "icon")
    public final BindableAttribute<String> icon = new BindableAttribute<>(String.class, "dungeonsguide:textures/dglogox128.png");
    private Supplier<Widget> pageCreator;

    public CategoryItem(Supplier<Widget> pageCreator, String category, String description) {
        super(new ResourceLocation("dungeonsguide:gui/config/categoryitem.gui"));
        this.pageCreator = pageCreator;

        this.name.setValue(category);
        this.description.setValue(description);
        try {
            String target = "dungeonsguide:textures/config/categoryIcon/"+category.toLowerCase()
                    .replace("&","").replace(" ","_")+".png";
            if (Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(target)) != null)
                icon.setValue(target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @On(functionName = "click")
    public void openPage() {
        Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.create(new ResourceLocation("gui.button.press"), 1.0F));
        Navigator.getNavigator(getDomElement()).openPage(pageCreator.get());
    }
}
