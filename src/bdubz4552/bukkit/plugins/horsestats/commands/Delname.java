package bdubz4552.bukkit.plugins.horsestats.commands;

import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;

import bdubz4552.bukkit.plugins.horsestats.Pmsg;

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
