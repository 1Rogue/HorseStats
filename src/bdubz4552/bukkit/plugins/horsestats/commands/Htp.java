package bdubz4552.bukkit.plugins.horsestats.commands;

import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;

import bdubz4552.bukkit.plugins.horsestats.HorseStatsEventListener;
import bdubz4552.bukkit.plugins.horsestats.HorseStatsMain;
import bdubz4552.bukkit.plugins.horsestats.Pmsg;

public class Htp {
	public static void htp(Player p) {
		if (HorseStatsEventListener.horses.get(p.getName()) == null) {
			Pmsg.error(p, "No horse has been selected!");
		} else {
			Horse h = HorseStatsEventListener.horses.get(p.getName());
			if (HorseStatsMain.interWorldTeleport == false) {
				if (p.getWorld() != h.getWorld()) {
					Pmsg.error(p, "Teleporting between worlds is disabled.");
				} else {
					Pmsg.message(p, "Teleporting...");
					h.teleport(p);
					HorseStatsEventListener.horses.remove(p.getName());
				}
			} else {
				Pmsg.message(p, "Teleporting...");
				h.teleport(p);
			}
		}
	}
}
