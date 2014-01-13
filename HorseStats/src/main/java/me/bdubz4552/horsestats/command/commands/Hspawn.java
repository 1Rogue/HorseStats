package me.bdubz4552.horsestats.command.commands;

import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.entity.Horse.Color;
import org.bukkit.entity.Horse.Style;
import org.bukkit.entity.Horse.Variant;

import me.bdubz4552.horsestats.Pmsg;

public class Hspawn {
	ChatColor ccr = ChatColor.RED;
	ChatColor ccg = ChatColor.GREEN;
	public static void hspawn(Player p, Horse h, String[] args) {
		List<Entity> check = p.getNearbyEntities(1, 1, 1);
		if (h == null) {
			if (check.size() == 0) {					
				Variant v = null;
				if (args.length == 1) {
					if (args[0].equals("donkey")) {
						v = Variant.DONKEY;
						Pmsg.message(p, "Donkey spawned successfully.");
					} else if (args[0].equals("mule")) {
						v = Variant.MULE;
						Pmsg.message(p, "Mule spawned successfully.");
					} else {
						Pmsg.error(p, "Invalid argument given! Use 'donkey' or 'mule', or use no parameter for a horse.");
					}
				} else {
					v = Variant.HORSE;
				}
				p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
				List<Entity> l = p.getNearbyEntities(1, 1, 1);
				h = (Horse) l.get(0);
				h.setAdult();
				h.setVariant(v);
				Random rand = new Random();
				if (v == Variant.HORSE) {
					Color[] c = {Color.BLACK, Color.BROWN, Color.CHESTNUT, Color.CREAMY, Color.DARK_BROWN, Color.GRAY, Color.WHITE};
					Style[] s = {Style.BLACK_DOTS, Style.NONE, Style.WHITE, Style.WHITE_DOTS, Style.WHITEFIELD};
					int x = rand.nextInt(7);
					int y = rand.nextInt(5);
					h.setColor(c[x]);
					h.setStyle(s[y]);
					Pmsg.message(p, "Horse spawned successfully.");
				}
			} else if (check.size() >= 1) {
				Pmsg.error(p, "Another entity is too close by, and the horse could not be spawned. Be sure there is at least two blocks between you and nearby mobs, paintings, itemframes, and leads.");
			} else {
				Pmsg.error(p, "If you're reading this, there is apparently a negative number of entities in a 1 block radius of you...");
			}
		} else {
			Pmsg.error(p, "You cannot be riding a horse while you use this command!");
		}
	}
}
