package me.bdubz4552.horsestats.command.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.entity.Player;
import org.bukkit.entity.Horse.Color;
import org.bukkit.entity.Horse.Style;

import me.bdubz4552.horsestats.Pmsg;

public class SetStyle {
	static ChatColor ccg = ChatColor.GREEN;
	static ChatColor ccy = ChatColor.YELLOW;
	public static void setstyle(Player p, Horse h, String[] args) {
		if (h != null) {
			if (h.getOwner() == p) {
				if (h.getVariant() == Variant.HORSE) {
					if (args.length == 2) {
						if (args[0].equalsIgnoreCase("color")) {
							if (args[1].equalsIgnoreCase("black")) {
								h.setColor(Color.BLACK);
							}
							else if (args[1].equalsIgnoreCase("brown")) {
								h.setColor(Color.BROWN);
							}
							else if (args[1].equalsIgnoreCase("chestnut")) {
								h.setColor(Color.CHESTNUT);
							}
							else if (args[1].equalsIgnoreCase("creamy")) {
								h.setColor(Color.CREAMY);
							}
							
							else if (args[1].equalsIgnoreCase("darkbrown")) {
								h.setColor(Color.DARK_BROWN);
							}
							else if (args[1].equalsIgnoreCase("gray")) {
								h.setColor(Color.GRAY);
							}
							else if (args[1].equalsIgnoreCase("black")) {
								h.setColor(Color.WHITE);
							} else {
								Pmsg.styleParams(p);
							}
						}
						if (args[0].equalsIgnoreCase("style")) {
							if (args[1].equalsIgnoreCase("blackdots")) {
								h.setStyle(Style.BLACK_DOTS);
							}
							else if (args[1].equalsIgnoreCase("none")) {
								h.setStyle(Style.NONE);
							}
							else if (args[1].equalsIgnoreCase("white")) {
								h.setStyle(Style.WHITE);
							}
							else if (args[1].equalsIgnoreCase("whitedots")) {
								h.setStyle(Style.WHITE_DOTS);
							}
							else if (args[1].equalsIgnoreCase("whitefield")) {
								h.setStyle(Style.WHITEFIELD);
							} else {
								Pmsg.styleParams(p);
							}
						}					
					} else if (args.length == 1){
						if (args[0].equals("?")) {
							setstatHelp(p);
						} else {
							Pmsg.styleParams(p);
						}
					} else {
						Pmsg.styleParams(p);
					}
				} else {
					Pmsg.error(p, "Only horses can be modified.");
				}
			} else {
				Pmsg.owner(p);
			}
		} else {
			Pmsg.riding(p);
		}
	}
	public static void setstatHelp(Player p) {
		String[] styleHelp = {ccg + "========================", ccy + "Help for /setstyle", ccg + "========================", ccy + "Usage: /setstyle <color|style> <value>", ccy + "Values for styles:", ccg + "-none -blackdots -whitedots -white -whitefield", ccy + "Values for color:", ccg + "-black -brown -chestnut -creamy -darkbrown -gray -black"};
		p.sendMessage(styleHelp);
	}
}
