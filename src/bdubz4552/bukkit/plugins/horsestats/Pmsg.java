package bdubz4552.bukkit.plugins.horsestats;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

//A class dedicated to saving me finger strokes... And regulating message output.
public class Pmsg {
	//Saving keystrokes here...
	static ChatColor ccb = ChatColor.BLUE;
	static ChatColor ccg = ChatColor.GREEN;
	static ChatColor ccr = ChatColor.RED;
	
	//Blue plugin name, uncolored message. Base block of more specific messages.
	private static void base(Player p, String msg) {
		p.sendMessage(ccb + "[HorseStats]" + msg);
	}
	
	//No plugin name, green message. Used for stat display.
	public static void stat(Player p, String msg) {
		p.sendMessage(ccg + msg);
	}
	
	//A message, colored green. Uses base.
	public static void message(Player p, String msg) {
		base(p, ccg + msg);
	}
	
	//An error message, colored red.
	public static void error(Player p, String msg) {
		base(p, ccr + msg);
	}
	
	//Specific error, given when not riding a horse for a command.
	public static void riding(Player p) {
		base(p, ccr + "You must be riding the horse you want to use this on!");
	}
	
	//Error message for permission check failure
	public static void perms(Player p) {
		base(p, ccr + "You do not have permissions for this command.");
	}
	
	//If horseGrief is false (not allowed), players see this when they try.
	public static void attack(Player p) {
		base(p, ccr + "You cannot hurt another player's horse.");
	}
	
	//Error when a player needs to be the horse's owner
	public static void owner(Player p) {
		base(p, ccr + "You must be the owner of the horse to do this.");
	}
	
	//Error players see when they misuse a command.
	public static void params(Player p) {
		base(p, ccr + "Bad arguments; use '/horsestats cmd' to see a list of commands and their use.");
	}
	
	//Specific argument error message to /setstyle. It deserves its own help menu.
	public static void styleParams(Player p) {
		base(p, ccr + "Bad arguments; use '/setstyle ?' to see arguments and usage.");
	}
	
	//Error when a player is not online or the name given is a typo.
	public static void player(Player p) {
		base(p, ccr + "The specified player was not found.");
	}
}
