package bdubz4552.bukkit.plugins.horsestats;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Pmsg {
	static ChatColor ccb = ChatColor.BLUE;
	static ChatColor ccg = ChatColor.GREEN;
	static ChatColor ccr = ChatColor.RED;
	private static void base(Player p, String msg) {
		p.sendMessage(ccb + "[HorseStats]" + msg);
	}
	public static void stat(Player p, String msg) {
		p.sendMessage(ccg + msg);
	}
	public static void message(Player p, String msg) {
		base(p, ccg + msg);
	}
	public static void error(Player p, String msg) {
		base(p, ccr + msg);
	}
	public static void riding(Player p) {
		base(p, ccr + "You must be riding the horse you want to use this on!");
	}
	public static void perms(Player p) {
		base(p, ccr + "You do not have permissions for this command.");
	}
	public static void attack(Player p) {
		base(p, ccr + "You cannot hurt another player's horse.");
	}
	public static void owner(Player p) {
		base(p, ccr + "You must be the owner of the horse to do this.");
	}
	public static void params(Player p) {
		base(p, ccr + "Bad arguments; use '/horsestats cmd' to see a list of commands and their use.");
	}
	public static void styleParams(Player p) {
		base(p, ccr + "Bad arguments; use '/setstyle ?' to see arguments and usage.");
	}
	public static void player(Player p) {
		base(p, ccr + "The specified player was not found.");
	}
}
