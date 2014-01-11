package bdubz4552.bukkit.plugins.horsestats.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;

import bdubz4552.bukkit.plugins.horsestats.Pmsg;

public class Ownerset {
	public static void ownerset(Player p, Horse h, String[] args) {
		if (h != null) {
			if (h.getOwner() == p) {
				if (args.length == 1) {
					if (Bukkit.getServer().getPlayerExact(args[0]) != null) {
						h.eject();
						Pmsg.message(p, "Owner changed successfully.");
						h.setOwner(p.getServer().getPlayerExact(args[0]));
					} else {
						Pmsg.player(p);
					}
				} else {
					Pmsg.params(p);
				}
			} else {
				Pmsg.owner(p);
			}
		} else {
			Pmsg.riding(p);
		}
	}
}
