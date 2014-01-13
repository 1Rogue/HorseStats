package me.bdubz4552.horsestats.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Help {
	static ChatColor ccg = ChatColor.GREEN;
	static ChatColor ccy = ChatColor.YELLOW;
	static String[] help = {ccg + "========================", ccy + "HorseStats by 'bdubz4552'", ccg + "========================", ccy + "Stat Display", ccg + "Grab a lead and punch a horse to return a list of statistics:", ccg + "-MaxHealth -Health -Jump Height -Speed (Blocks per Second)", ccg + "-Can Breed -Is Adult -Owner", ccy + "Noteworthy Things:", ccg + "1) Horses will NOT take damage from the punch", ccg + "2) Speed and jump values are not infinitely precise.", ccy + "Horse Teleporting", ccg + "Grab an ender pearl and punch a horse to select it. The damage will be canceled, and the horse will be selected for teleporting. To teleport the horse, use '/horsetp' at the desired destination and the horse will teleport to you.", ccy + "To see a list of all commands and their use, use '/horsestats cmd'."};
	static String[] cmd = {ccg + "========================", ccy + "HorseStats Command Help", ccg + "========================", ccy + "/delchest", ccg + "Deletes the chest off of a horse.", ccy + "/delname", ccg + "Deletes a horse's custom name.", ccy + "/horsestats", ccg + "Displays plugin usage information.", ccy + "/hspawn <donkey|mule>", ccg + "Spawns a horse, donkey, or mule. Use no argument for a horse.", ccy + "/htp", ccg + "Teleport a horse to your location. It must be selected with an enderpearl first.", ccy + "/ownerset <player>", ccg + "Gives ownership of a horse to the specified player.", ccy + "/setstyle <color|style> <value>", ccg + "Sets a horse's style or color (the first argument picks which to modify) to the specified value (the second argument is the desired style or color. Use '/setstyle ?' to see a list of the available colors and styles.", ccy + "/slayhorse <launch>", ccg + "Slays a horse. If the argument 'launch' is added, the horse is launched in the air for a bit of fun.", ccy + "/tame", ccg + "Tames an untamed horse.", ccy + "/untame", ccg + "Removes ownership of a horse."};
	public static void horseStatsHelp(Player p) {
		p.sendMessage(help);
	}
	public static void horseStatsCmd(Player p) {
		p.sendMessage(cmd);
	}
}
