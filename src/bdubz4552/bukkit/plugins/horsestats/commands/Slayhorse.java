package bdubz4552.bukkit.plugins.horsestats.commands;

import org.bukkit.Location;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import bdubz4552.bukkit.plugins.horsestats.HorseStatsMain;
import bdubz4552.bukkit.plugins.horsestats.Pmsg;

public class Slayhorse {
	public static void slayhorse(Player p, Horse h, String[] args) {
		if (h != null) {
			h.eject();
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("launch") && HorseStatsMain.horseLaunch == true) {
					Vector vec = new Vector(0, 6, 0);
					h.setVelocity(vec);
					p.chat("♫ He's a magical pony, flying through the sky--shoot it down. *boom*");
					Location loc = new Location(h.getWorld(), h.getLocation().getX(), 256, h.getLocation().getZ());
					h.getWorld().strikeLightning(loc);
				}		
			}
			h.setHealth(0);
			Pmsg.message(p, "Horse slain.");
		} else {
			Pmsg.riding(p);
		}
	}
}
