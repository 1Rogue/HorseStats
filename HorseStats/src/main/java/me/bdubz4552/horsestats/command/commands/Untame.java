package me.bdubz4552.horsestats.command.commands;

import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.bdubz4552.horsestats.Pmsg;

public class Untame {
	public static void untame(Player p, Horse h) {
		if (h != null) {
			if (h.getOwner() == p) {
				h.eject();
				h.setOwner(null);
				h.setTamed(false);
				if (h.getInventory().getSaddle() != null) {
					ItemStack stack = h.getInventory().getSaddle();
					h.getInventory().setSaddle(null);
					h.getWorld().dropItemNaturally(h.getLocation(), stack);
				}
				Pmsg.message(p, "This horse is no longer tamed.");
			} else {
				Pmsg.owner(p);
			}
		} else {
			Pmsg.riding(p);
		}
	}
}
