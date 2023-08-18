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

package kr.syeyoung.dungeonsguide.launcher.gui.screen.version;

import kr.syeyoung.dungeonsguide.launcher.loader.IDGLoader;
import kr.syeyoung.dungeonsguide.launcher.loader.JarLoader;
import kr.syeyoung.dungeonsguide.launcher.loader.LocalLoader;
import net.minecraftforge.common.config.Configuration;

public class WidgetInfoJar extends WidgetInfo {
    public WidgetInfoJar() {
        super();
        setVersion("Local (Jar)");
        setUpdateLog("");
    }

    @Override
    public void setConfiguration(Configuration configuration) {
        configuration.get("loader", "modsource", "").set("jar");
    }

    @Override
    public IDGLoader getLoader() {
        return new JarLoader();
    }
}
