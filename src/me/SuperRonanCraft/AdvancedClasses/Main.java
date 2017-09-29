package me.SuperRonanCraft.AdvancedClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.SuperRonanCraft.AdvancedClasses.classes.perks.cropsfarming.CropsFarming;
import me.SuperRonanCraft.AdvancedClasses.classes.perks.grave.Grave;
import me.SuperRonanCraft.AdvancedClasses.classes.perks.treefarming.TreeFarming;
import me.SuperRonanCraft.AdvancedClasses.events.Commands;

public class Main extends JavaPlugin {

	public PluginManager pm = getServer().getPluginManager();
	public YamlConfiguration classes = new YamlConfiguration();
	Commands cmd = new Commands(this);

	public void onEnable() {
		registerConfig();
		registerPerks();
	}

	private void registerPerks() {
		new Grave(this);
		new CropsFarming(this);
		new TreeFarming(this);
	}

	public boolean onCommand(CommandSender sendi, Command cmd, String label, String[] args) {
		return false;
	}

	private void registerConfig() {
		FileConfiguration config = getConfig();
		config.options().copyDefaults(true);
		saveDefaultConfig();
	}

	public void load(File f, YamlConfiguration yml) {
		try {
			yml.load(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
}
