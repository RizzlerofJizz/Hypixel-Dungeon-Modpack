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

package kr.syeyoung.dungeonsguide.launcher.guiv2.xml;

import kr.syeyoung.dungeonsguide.launcher.guiv2.BindableAttribute;
import kr.syeyoung.dungeonsguide.launcher.guiv2.Widget;

import java.util.Objects;
import java.util.function.Supplier;

public class ExportedWidgetConverter<W extends Widget & ExportedWidget, R extends Widget & ImportingWidget> extends PropByPropParsedWidgetConverter<W, R> {
    private Supplier<W> constructor;

    public ExportedWidgetConverter(Supplier<W> constructor) {
        this.constructor = Objects.requireNonNull(constructor);
    }


    public W instantiateWidget() {
        return constructor.get();
    }

    public final BindableAttribute getExportedAttribute(W widget, String attributeName) {
        return widget.getExportedAttribute(attributeName);
    }
}
