package me.bdubz4552.horsestats.command.commands;

import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;

import me.bdubz4552.horsestats.Pmsg;

public class Delname {
	public static void delname(Player p, Horse h) {
		if (h != null) {
			if (h.getOwner() == p) {
				h.setCustomName(null);
				Pmsg.message(p, "Custom name erased.");
			} else {
				Pmsg.owner(p);
			}
		} else {
			Pmsg.riding(p);
		}
	}
}
