package me.SuperRonanCraft.AdvancedClasses.classes.perks.grave;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

import me.SuperRonanCraft.AdvancedClasses.Main;
import me.SuperRonanCraft.AdvancedClasses.classes.perks.PerkSettings;
import me.SuperRonanCraft.AdvancedClasses.classes.perks.grave.event.Death;

public class Grave implements PerkSettings {

	YamlConfiguration file = new YamlConfiguration();

	Main pl;
	public Grave(Main pl) {
		this.pl = pl;
		registerEvents();
		registerYaml();
		load();
	}

	private void registerEvents() {
		pl.pm.registerEvents(new Death(), pl);
	}

	private void registerYaml() {
		File f = new File(pl.getDataFolder() + File.separator + "Perks", "graves.yml");
		if (!f.exists())
			pl.saveResource("Perks" + File.separator + "graves.yml", false);
		pl.load(f, file);
	}

	private void load() {

	}

	@Override
	public int getPoints() {
		return file.getInt("Settings.Level");
	}
}
