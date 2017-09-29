package me.SuperRonanCraft.AdvancedClasses.reference;

import java.util.HashMap;

import org.bukkit.entity.Player;

import me.SuperRonanCraft.AdvancedClasses.Main;

public class Players {

	Main pl;
	HashMap<Player, String> pclass = new HashMap<Player, String>();

	public Players(Main pl) {
		this.pl = pl;
	}

	public void load() {

	}
}
