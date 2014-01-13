/*
 * Copyright (C) 2013 bdubz4552
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package me.bdubz4552.horsestats.command;

import org.bukkit.command.CommandSender;

/**
 * Command interface for HorseStats commands
 *
 * @since 2.3.0
 * @author 1Rogue
 * @version 2.3.0
 */
public interface HSCommand {
    
    public boolean execute(CommandSender sender, String[] args);

}
