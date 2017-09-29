package me.SuperRonanCraft.AdvancedClasses.classes.perks.cropsfarming;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

import me.SuperRonanCraft.AdvancedClasses.Main;
import me.SuperRonanCraft.AdvancedClasses.classes.perks.PerkSettings;
import me.SuperRonanCraft.AdvancedClasses.classes.perks.cropsfarming.event.Crops;

public class CropsFarming implements PerkSettings {

	Main pl;
	YamlConfiguration file = new YamlConfiguration();
	List<Integer> ranges = new ArrayList<Integer>();
	public HashMap<Integer, Integer> rangeLimits = new HashMap<Integer, Integer>();

	public CropsFarming(Main pl) {
		this.pl = pl;
		registerEvents();
		registerYaml();
		load();
	}

	private void registerEvents() {
		pl.pm.registerEvents(new Crops(), pl);
	}

	private void registerYaml() {
		File f = new File(pl.getDataFolder() + File.separator + "Perks", "farmingCrops.yml");
		if (!f.exists())
			pl.saveResource("Perks" + File.separator + "farmingCrops.yml", false);
		pl.load(f, file);
	}

	private void load() {

	}

	@Override
	public int getPoints() {
		return file.getInt("Settings.Level");
	}
}
