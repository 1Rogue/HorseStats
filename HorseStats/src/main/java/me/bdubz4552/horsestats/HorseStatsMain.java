package me.bdubz4552.horsestats;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class HorseStatsMain extends JavaPlugin {
	protected Logger log;
	//Mandatory void for all Bukkit plugins; executes on server starts/reloads
	public void onEnable() {
		this.log = this.getLogger();
		getServer().getPluginManager().registerEvents(new HorseStatsEventListener(), this);
		this.saveDefaultConfig();
		registerCommands();
		setConfigBooleans();
	}
	//Registers commands. Called in onEnable()
	private void registerCommands() {
		getCommand("horsestats").setExecutor(new HorseStatsCommands());
		getCommand("htp").setExecutor(new HorseStatsCommands());
		getCommand("ownerset").setExecutor(new HorseStatsCommands());
		getCommand("untame").setExecutor(new HorseStatsCommands());
		getCommand("delchest").setExecutor(new HorseStatsCommands());
		getCommand("delname").setExecutor(new HorseStatsCommands());
		getCommand("slayhorse").setExecutor(new HorseStatsCommands());
		getCommand("hspawn").setExecutor(new HorseStatsCommands());
		getCommand("setstyle").setExecutor(new HorseStatsCommands());
		getCommand("tame").setExecutor(new HorseStatsCommands());
	}
	//Sets static booleans to the config values. These are easier to use than referencing to the config over and over.
	private void setConfigBooleans() {
		if (this.getConfig().getBoolean("horseGrief") == true) {
			horseGrief = true;
		} else {
			horseGrief = false;
		}
		if (this.getConfig().getBoolean("horseLaunch") == true) {
			horseLaunch = true;
		} else {
			horseLaunch = false;
		}
		if (this.getConfig().getBoolean("nonOwnerHorseInteraction") == true) {
			nonOwnerHorseInteraction = true;
		} else {
			nonOwnerHorseInteraction = false;
		}
		if (this.getConfig().getBoolean("allowMultiWorldTeleport") == true) {
			interWorldTeleport = true;
		} else {
			interWorldTeleport = false;
		}
	}
	//The actual booleans, defaulted to false. These change when setConfigBooleans() is called in onEnable().
	public static boolean interWorldTeleport = false;
	public static boolean horseGrief = false;
	public static boolean horseLaunch = false;
	public static boolean nonOwnerHorseInteraction = false;
}
