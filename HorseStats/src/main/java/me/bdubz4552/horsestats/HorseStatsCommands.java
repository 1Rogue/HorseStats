package me.bdubz4552.horsestats;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import me.bdubz4552.horsestats.commands.*;


public class HorseStatsCommands implements CommandExecutor {
	//Fired whenever a HorseStats command is used.
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			Horse h = null;
			if (p.isInsideVehicle()) {
				if (p.getVehicle() instanceof Horse) {
					h = (Horse) p.getVehicle();
				}
			}
			findCommand(p, h, commandLabel, args);
			return true;
		} else {
			sender.sendMessage(ChatColor.BLUE + "[HorseStats] " + ChatColor.RED + "Commands cannot be used in console!");
			return true;
		}
	}
	//Boolean to check for permissions for commands.
	public boolean permCheck(Player p, String command) {
		if (p.hasPermission("HorseStats." + command)) {
			return true;
		} else {
			return false;
		}
	}
	//Determines what code to execute based on the command given.
	public void findCommand(Player p, Horse h, String commandLabel, String[] args) {
		if (commandLabel.equalsIgnoreCase("horsestats")) {
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("cmd")) {
					Help.horseStatsCmd(p);
				} else {
					Help.horseStatsHelp(p);
				}
			} else {
				Help.horseStatsHelp(p);
			}
		}
		else if (permCheck(p, commandLabel) == true) {
			if (commandLabel.equalsIgnoreCase("delchest")) {
				Delchest.delchest(p, h);
			}
			if (commandLabel.equalsIgnoreCase("delname")) {
				Delname.delname(p, h);
			}
			if (commandLabel.equalsIgnoreCase("hspawn")) {
				Hspawn.hspawn(p, h, args);
			}
			if (commandLabel.equalsIgnoreCase("htp")) {
				Htp.htp(p);
			}
			if (commandLabel.equalsIgnoreCase("ownerset")) {
				Ownerset.ownerset(p, h, args);
			}
			if (commandLabel.equalsIgnoreCase("setstyle")) {
				SetStyle.setstyle(p, h, args);
			}
			if (commandLabel.equalsIgnoreCase("slayhorse")) {
				Slayhorse.slayhorse(p, h, args);
			}
			if (commandLabel.equalsIgnoreCase("tame")) {
				Tame.tame(p, h);
			}
			if (commandLabel.equalsIgnoreCase("untame")) {
				Untame.untame(p, h);
			}		
		} else {
			Pmsg.perms(p);
		}
	}
}
