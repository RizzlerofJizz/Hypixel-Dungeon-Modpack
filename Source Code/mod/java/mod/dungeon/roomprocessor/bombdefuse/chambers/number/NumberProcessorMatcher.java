/*
 * Dungeons Guide - The most intelligent Hypixel Skyblock Dungeons Mod
 * Copyright (C) 2021  cyoung06
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

package kr.syeyoung.dungeonsguide.mod.dungeon.roomprocessor.bombdefuse.chambers.number;

import kr.syeyoung.dungeonsguide.mod.dungeon.roomprocessor.bombdefuse.RoomProcessorBombDefuseSolver;
import kr.syeyoung.dungeonsguide.mod.dungeon.roomprocessor.bombdefuse.chambers.BDChamber;
import kr.syeyoung.dungeonsguide.mod.dungeon.roomprocessor.bombdefuse.chambers.BombDefuseChamberGenerator;
import kr.syeyoung.dungeonsguide.mod.dungeon.roomprocessor.bombdefuse.chambers.ChamberProcessor;
import net.minecraft.init.Blocks;

public class NumberProcessorMatcher implements BombDefuseChamberGenerator {
    @Override
    public boolean match(BDChamber left, BDChamber right) {
        return left.getBlock(1,1,4).getBlock() == Blocks.stone &&
                left.getBlock(2,1,4).getBlock() == Blocks.stone &&
                left.getBlock(6,1,4).getBlock() == Blocks.stone &&
                left.getBlock(7,1,4).getBlock() == Blocks.stone &&
                right.getBlock(1,1,4).getBlock() == Blocks.stone &&
                right.getBlock(2,1,4).getBlock() == Blocks.stone &&
                right.getBlock(6,1,4).getBlock() == Blocks.stone &&
                right.getBlock(7,1,4).getBlock() == Blocks.stone;
    }

    @Override
    public String getName() {
        return "numberMatch";
    }
    @Override
    public ChamberProcessor createLeft(BDChamber left, RoomProcessorBombDefuseSolver solver) {
        return new NumberLeftProcessor(solver, left);
    }

    @Override
    public ChamberProcessor createRight(BDChamber right, RoomProcessorBombDefuseSolver solver) {
        return new NumberRightProcessor(solver, right);
    }
}
