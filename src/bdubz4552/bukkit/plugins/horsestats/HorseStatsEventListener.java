package bdubz4552.bukkit.plugins.horsestats;

import java.util.HashMap;

import net.minecraft.server.v1_7_R1.NBTBase;
import net.minecraft.server.v1_7_R1.NBTTagCompound;
import net.minecraft.server.v1_7_R1.NBTTagList;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftHorse;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class HorseStatsEventListener implements Listener {
	//A list of horses that are waiting in the teleport queue. Matches horse objects to players.
	public static HashMap<String, Horse> horses = new HashMap<String, Horse>();
	
	@EventHandler
	/**
	 * This event is called whenever an entity is hurt by another entity.
	 * The first if statement quickly drops this if it is not a player and horse.
	 */
	public void onHorseHit (EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Horse && event.getDamager() instanceof Player) {
			Player p = (Player) event.getDamager();
			ItemStack item = p.getItemInHand();
			Horse horse = (Horse) event.getEntity();
			
			//If a horse is hit with a lead...
			if (item.getType().equals(Material.LEASH)) {
				event.setCancelled(true);
				/**
				 * These two if statements correct a vanilla Minecraft (or CraftBukkit;
				 * can't be sure which) bug that made bred horses tamed, but with no
				 * owner. If a horse is tamed but has no owner, or has an owner but is
				 * untamed, this will forcefully untame/remove ownership.
				 */
				if (horse.isTamed() && horse.getOwner() == null) {
					horse.setTamed(false);
					Pmsg.message(p, "The horse was found to have no owner, but flagged as tamed. This horse is now untamed.");
				}
				if (!horse.isTamed() && horse.getOwner() != null) {
					horse.setOwner(null);
					Pmsg.message(p, "The horse was found to have an owner, but was not tamed. The owner has been cleared.");
				}				
					
				double healthMax = horse.getMaxHealth();
				double heartMax = healthMax / 2;
				double health = horse.getHealth();
				double heart = health / 2;
				double jump = horse.getJumpStrength();
				double jumpFinal = ((jump) * 5.1);
				boolean adult = horse.isAdult();
				boolean breed = horse.canBreed();
				float age = horse.getAge();
				
				String name = horse.getCustomName();
				if (name == null) {
					name = "Horse";
				} else {
					name = name + "'s";
				}
				
				boolean tpStatus;
				if (horses.containsValue(horse)) {
					tpStatus = true;
				} else {
					tpStatus = false;
				}
				
				Pmsg.stat(p, "========================");
				Pmsg.stat(p, name + " Stats");
				Pmsg.stat(p, "========================");
				Pmsg.stat(p, "Max Health: " + (float) healthMax + " (" + (int) heartMax + " hearts)");
				Pmsg.stat(p, "Health: " + (float) health + " (" + (int) heart + " hearts)");
				Pmsg.stat(p, "Jump Height (Blocks): " + (float) jumpFinal);
				
				//Speed can be complicated; it uses CraftBukkit code and can break easily.
				if (getSpeed(horse) == -1) {
					Pmsg.error(p, "Speed could not be retrieved; requires CB 1.7.2-R0.2");
				} else {
					Pmsg.stat(p, "Speed (Blocks per Second): " + (float) getSpeed(horse) * 10 * 3);
				}
				
				Pmsg.stat(p, "Can Breed: " + breed);
				Pmsg.stat(p, "Is Selected For Teleport: " + tpStatus);
				
				String adultMsg;
				if (adult == false) {
					adultMsg = "Is Adult: " + adult + " (Minutes Until Adult: " + age / -20 / 60 + ")";
				} else {
					adultMsg = "Is Adult: " + adult;
				}
				Pmsg.stat(p, adultMsg);
				
				AnimalTamer tamer = horse.getOwner();
				if (tamer != null) {
					Pmsg.stat(p, "Owner: " + tamer.getName());
				} else {
					Pmsg.stat(p, "Owner: None");
				}
			
			//If a horse is hit with an enderpearl...
			} else if (item.getType().equals(Material.ENDER_PEARL)) {
				event.setCancelled(true);
				if (horse.getOwner() == p) {
					if (horses.containsKey(p.getName())) {
						horses.remove(p.getName());
						Pmsg.message(p, "Horse deselected for teleport.");
					} else {
						horses.put(p.getName(), horse);
						Pmsg.message(p, "Horse selected for teleport.");
					}
				} else if (horse.getOwner() == null) { 
					Pmsg.error(p, "You cannot select an untamed horse for teleporting!");
				} else {
					Pmsg.error(p, "You cannot select someone else's horse for teleporting!");
				}
			}
			//Every other scenario ends up here. If horseGrief is allowed, this is just dropped.
			else if (HorseStatsMain.horseGrief == false) {
				if (p != horse.getOwner()) {
					if (horse.getOwner() != null) {
						event.setCancelled(true);
						Pmsg.error(p, "You cannot attack horses that are not yours!");
					}
				}
			}
		}
		/**
		 * Still contained in the EntityDamagedByEntityEvent,
		 * but this applies to arrow impacts instead of hand strikes.
		 */
		if (HorseStatsMain.horseGrief == false) {
			if (event.getEntity() instanceof Horse && event.getDamager() instanceof Arrow) {
				Arrow arrow = (Arrow) event.getDamager();
				Horse horse = (Horse) event.getEntity();
				if (arrow.getShooter() instanceof Player) {
					if (horse.getOwner() != null && event.getDamager() == arrow.getShooter()) {
						event.setCancelled(true);
						Player p = (Player) arrow.getShooter();
						Pmsg.error(p, "You cannot shoot horses that are not yours!");
					}
				}
			}
		}
	}
	//Event listener for nonOwnerHorseInteraction config setting.
	public void onHorseInventoryOpen(PlayerInteractEntityEvent event) {
		if (HorseStatsMain.nonOwnerHorseInteraction == false) {
			Player p = event.getPlayer();
			if (event.getRightClicked() instanceof Horse) {
				Horse h = (Horse) event.getRightClicked();
				if (h.getOwner() != p && h.getOwner() != null) {
					event.setCancelled(true);
				}
			}
		}		
	}
	/**
	 * The fragile code used to retrieve horse speed. Nasty NBT stuff.
	 * The try and catch is an effort to stop an error that causes the
	 * whole stat display to not work. Haven't been able to test it much,
	 * and surprisingly enough v2.2 works on the early CB 1.7.2-R0.1 dev
	 * builds. No need for the try/catch, despite earlier versions of
	 * HorseStats completely breaking.
	 */
	public double getSpeed(Horse horse) {
		try {
			CraftHorse cHorse = (CraftHorse) horse;
			NBTTagCompound compound = new NBTTagCompound();
			cHorse.getHandle().b(compound);
			double speed = -1;
			NBTTagList list = (NBTTagList) compound.get("Attributes");
			for(int i = 0; i < list.size() ; i++) {
				NBTBase base = list.get(i);
				if (base.getTypeId() == 10) {
					NBTTagCompound attrCompound = (NBTTagCompound)base;
					if (base.toString().contains("generic.movementSpeed")) {
						speed = attrCompound.getDouble("Base");
					}
				}
			}
			return speed;
		} catch (Exception e){
			e.printStackTrace();
			return -1;
		}		
	}
}

