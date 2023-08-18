/*
 * Dungeons Guide - The most intelligent Hypixel Skyblock Dungeons Mod
 * Copyright (C) 2023  cyoung06 (syeyoung)
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

package kr.syeyoung.dungeonsguide.mod.overlay;

import kr.syeyoung.dungeonsguide.mod.guiv2.DomElement;
import kr.syeyoung.dungeonsguide.mod.guiv2.primitive.ConstraintBox;
import kr.syeyoung.dungeonsguide.mod.guiv2.primitive.Rect;
import kr.syeyoung.dungeonsguide.mod.guiv2.primitive.Size;
import lombok.RequiredArgsConstructor;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

@RequiredArgsConstructor
public class AbsPosPositioner implements Positioner {
    public final double x, y;

    @Override
    public Rect position(DomElement domElement, double screenWidth, double screenHeight) {
        double xScale = Minecraft.getMinecraft().displayWidth/screenWidth;
        double yScale = Minecraft.getMinecraft().displayHeight /screenHeight;
        Size size = domElement.getLayouter().layout(domElement,
                new ConstraintBox(0, screenWidth-x /xScale, 0, screenHeight - y/yScale));
        return new Rect(x / xScale, y/ yScale, size.getWidth(), size.getHeight());
    }
}
