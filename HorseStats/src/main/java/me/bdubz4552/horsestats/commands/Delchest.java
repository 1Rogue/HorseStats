package me.bdubz4552.horsestats.commands;

import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;

import me.bdubz4552.horsestats.Pmsg;

public class Delchest {
	public static void delchest(Player p, Horse h) {
		if (h != null) {
			if (h.getOwner() == p) {
				h.setCarryingChest(false);
				Pmsg.message(p, "Chest deleted.");
			} else {
				Pmsg.owner(p);
			}
		} else {
			Pmsg.owner(p);
		}
	}
}
