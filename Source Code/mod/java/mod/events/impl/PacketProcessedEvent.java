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

package kr.syeyoung.dungeonsguide.mod.events.impl;

import lombok.AllArgsConstructor;
import net.minecraft.network.Packet;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraftforge.fml.common.eventhandler.Event;

@AllArgsConstructor
public abstract class PacketProcessedEvent extends Event {
    public Packet<INetHandlerPlayClient> packet;
    public static class Pre extends PacketProcessedEvent {
        public Pre(Packet<INetHandlerPlayClient> packet) {
            super(packet);
        }
    };
    public static class Post extends PacketProcessedEvent {
        public Post(Packet<INetHandlerPlayClient> packet) {
            super(packet);
        }
    };
}
