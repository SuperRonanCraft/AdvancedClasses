package me.SuperRonanCraft.AdvancedClasses.events;

import org.bukkit.command.CommandSender;

import me.SuperRonanCraft.AdvancedClasses.Main;

public class Commands {
	Main pl;

	public Commands(Main pl) {
		this.pl = pl;
	}

	public void onCommand(CommandSender sendi, String label, String[] args) {
		if (args.length != 0) {

		} else
			help(sendi, label);
	}

	private void help(CommandSender sendi, String label) {

	}
}
