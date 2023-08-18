/*
 * Dungeons Guide - The most intelligent Hypixel Skyblock Dungeons Mod
 * Copyright (C) 2023 rizzlerofjizz
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package kr.syeyoung.dungeonsguide.launcher.guiv2.elements;

import kr.syeyoung.dungeonsguide.launcher.guiv2.BindableAttribute;
import kr.syeyoung.dungeonsguide.launcher.guiv2.DomElement;
import kr.syeyoung.dungeonsguide.launcher.guiv2.Widget;
import kr.syeyoung.dungeonsguide.launcher.guiv2.xml.AnnotatedExportOnlyWidget;
import kr.syeyoung.dungeonsguide.launcher.guiv2.xml.annotations.Export;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectiveContainer extends AnnotatedExportOnlyWidget {
    @Export(attributeName = "visible")
    public final BindableAttribute<String> visibleChild = new BindableAttribute<>(String.class);

    private final Map<String, BindableAttribute<Widget>> widgetMap = new HashMap<>();

    public SelectiveContainer() {
        visibleChild.addOnUpdate((old, neu) -> {
            if (getDomElement().getChildren().size() > 0)
                getDomElement().removeElement(getDomElement().getChildren().get(0));
            if (getDomElement().getParent() != null) {
                Widget widget = widgetMap.get("_"+visibleChild.getValue()).getValue();
                getDomElement().addElement(widget.createDomElement(getDomElement()));
            }
        });
    }

    @Override
    public List<Widget> build(DomElement buildContext) {
        return Collections.singletonList(widgetMap.get("_"+visibleChild.getValue()).getValue());
    }

    @Override
    public <T> BindableAttribute<T> getExportedAttribute(String attributeName) {
        BindableAttribute<T> bindableAttribute =  super.getExportedAttribute(attributeName);
        if (bindableAttribute == null && attributeName.startsWith("_")) {
            BindableAttribute attribute = new BindableAttribute(Widget.class);
            widgetMap.put(attributeName, attribute);
            return attribute;
        }
        return bindableAttribute;
    }

    @Override
    public void onUnmount() {
        for (BindableAttribute<Widget> value : widgetMap.values()) {
            value.unexportAll();
        }
        super.onUnmount();
    }
}
