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

import java.util.HashMap;
import java.util.Map;
import me.bdubz4552.horsestats.HorseStatsMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 *
 * @since
 * @author 1Rogue
 * @version
 */
public class CommandHandler implements CommandExecutor {
    
    private final HorseStatsMain plugin;
    private final Map<String, HSCommand> commands = new HashMap<String, HSCommand>();
    
    public CommandHandler(HorseStatsMain plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        return false;
    }

}
