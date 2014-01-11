package bdubz4552.bukkit.plugins.horsestats.commands;

import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;

import bdubz4552.bukkit.plugins.horsestats.Pmsg;

public class Tame {
	public static void tame(Player p, Horse h) {
		if (h != null) {
			if (h.getOwner() == null) {
				h.setOwner(p);
				Pmsg.message(p, "You now own this horse.");
			} else if (h.getOwner() == p) {
				Pmsg.error(p, "You already own this horse.");
			} else {
				Pmsg.error(p, "You cannot tame a horse owned by someone else.");
			}
		} else {
			Pmsg.riding(p);
		}
	}
}
