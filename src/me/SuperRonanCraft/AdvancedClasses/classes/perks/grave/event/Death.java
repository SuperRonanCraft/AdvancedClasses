package me.SuperRonanCraft.AdvancedClasses.classes.perks.grave.event;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class Death implements Listener {

	Location loc;

	@EventHandler
	private void onDeath(PlayerDeathEvent e) {
		Location pos = e.getEntity().getLocation();
		pos.getBlock().setType(Material.CHEST);
		Chest chest = (Chest) pos.getBlock().getState();
		chest.setCustomName(e.getEntity().getName());
		for (int i = 0; i < e.getDrops().size(); i++)
			if (e.getDrops().get(i) != null)
				if (chest.getInventory().firstEmpty() != -1)
					chest.getInventory().addItem(e.getDrops().get(i));
				else
					e.getEntity().getWorld().dropItemNaturally(chest.getBlock().getRelative(BlockFace.UP).getLocation(),
							e.getDrops().get(i));
		e.getDrops().clear();
		loc = e.getEntity().getLocation();
	}

	@EventHandler
	private void onDeath(PlayerRespawnEvent e) {
		e.setRespawnLocation(loc);
	}
}