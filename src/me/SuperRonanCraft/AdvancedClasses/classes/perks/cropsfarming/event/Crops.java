package me.SuperRonanCraft.AdvancedClasses.classes.perks.cropsfarming.event;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dye;

public class Crops implements Listener {

	List<Material> mats = Arrays.asList(Material.CROPS, Material.POTATO, Material.CARROT, Material.NETHER_WARTS,
			Material.BEETROOT_BLOCK);

	@EventHandler
	private void onWheat(PlayerInteractEvent e) {
		if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK))
			if (mats.contains(e.getClickedBlock().getType()))
				if (e.getItem() != null && !e.getItem().equals(Material.AIR)) {
					if (e.getItem().getData() instanceof Dye)
						if (((Dye) e.getItem().getData()).getColor().equals(DyeColor.WHITE)) {
							int range = 1;
							for (int i = 1; i <= range; i++) {
								Player p = e.getPlayer();
								Location loc = e.getClickedBlock().getLocation();
								loc.add(i, 0, 0);
								aliasRange(e, loc, p);
								loc.add(-i, 0, -i);
								aliasRange(e, loc, p);
								loc.add(-i, 0, i);
								aliasRange(e, loc, p);
								loc.add(i, 0, i);
								aliasRange(e, loc, p);
							}
							breakIt(e.getClickedBlock(), e.getPlayer());
						} else
							breakIt(e.getClickedBlock(), e.getPlayer());
				} else
					breakIt(e.getClickedBlock(), e.getPlayer());
	}

	private void aliasRange(PlayerInteractEvent e, Location loc, Player p) {
		if (e.getPlayer().getInventory().contains(e.getItem())) {
			if (loc.getBlock().getType().equals(e.getClickedBlock().getType()))
				if (growIt(loc.getBlock(), p))
					if (!e.getPlayer().getGameMode().equals(GameMode.CREATIVE))
						e.getPlayer().getInventory().getItemInMainHand()
								.setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
		}
	}

	private boolean growIt(Block mat, Player p) {
		if (mat.getType().equals(Material.CROPS))
			return growWheat(mat, p);
		if (mat.getType().equals(Material.POTATO))
			return growPotato(mat, p);
		if (mat.getType().equals(Material.CARROT))
			return growCarrot(mat, p);
		if (mat.getType().equals(Material.BEETROOT_BLOCK))
			return growBeet(mat, p);
		return false;
	}

	@SuppressWarnings("deprecation")
	private boolean growWheat(Block mat, Player p) {
		if (mat.getData() != 7) {
			if (mat.getData() != 6) {
				int rng = (new Random()).nextInt(2);
				if (rng == 0)
					mat.setData((byte) (mat.getData() + 1));
				else
					mat.setData((byte) (mat.getData() + 2));
			} else
				mat.setData((byte) 7);
			mat.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, mat.getLocation().add(0.5, 0.5, 0.5), 20, 0.25, 0.25,
					0.25);
			return true;
		} else
			breakIt(mat, p);
		return false;
	}

	@SuppressWarnings("deprecation")
	private boolean growPotato(Block mat, Player p) {
		if (mat.getData() != 7) {
			if (mat.getData() != 6) {
				int rng = (new Random()).nextInt(2);
				if (rng == 0)
					mat.setData((byte) (mat.getData() + 1));
				else
					mat.setData((byte) (mat.getData() + 2));
			} else
				mat.setData((byte) 7);
			mat.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, mat.getLocation().add(0.5, 0.145, 0.5), 20, 0.25,
					0.145, 0.25);
			return true;
		} else
			breakIt(mat, p);
		return false;
	}

	@SuppressWarnings("deprecation")
	private boolean growCarrot(Block mat, Player p) {
		if (mat.getData() != 7) {
			if (mat.getData() != 6) {
				int rng = (new Random()).nextInt(2);
				if (rng == 0)
					mat.setData((byte) (mat.getData() + 1));
				else
					mat.setData((byte) (mat.getData() + 2));
			} else
				mat.setData((byte) 7);
			mat.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, mat.getLocation().add(0.5, 0.5, 0.5), 20, 0.25, 0.25,
					0.25);
			return true;
		} else
			breakIt(mat, p);
		return false;
	}

	@SuppressWarnings("deprecation")
	private boolean growBeet(Block mat, Player p) {
		if (mat.getData() != 3) {
			if (mat.getData() != 2) {
				int rng = (new Random()).nextInt(1);
				if (rng == 0)
					mat.setData((byte) (mat.getData() + 1));
				else if (mat.getData() == 1)
					mat.setData((byte) (mat.getData() + 2));
				else
					mat.setData((byte) (mat.getData() + 1));
			} else
				mat.setData((byte) 3);
			mat.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, mat.getLocation().add(0.5, 0.5, 0.5), 20, 0.25, 0.25,
					0.25);
			return true;
		} else
			breakIt(mat, p);
		return false;
	}

	private void breakIt(Block mat, Player p) {
		if (mat.getType().equals(Material.CROPS))
			breakWheat(mat, p);
		if (mat.getType().equals(Material.POTATO))
			breakPotato(mat, p);
		if (mat.getType().equals(Material.CARROT))
			breakCarrot(mat, p);
		if (mat.getType().equals(Material.BEETROOT_BLOCK))
			breakBeet(mat, p);
		if (mat.getType().equals(Material.NETHER_WARTS))
			breakWart(mat, p);
	}

	@SuppressWarnings("deprecation")
	private void breakWheat(Block mat, Player p) {
		if (mat.getData() == 7) {
			int rng = (new Random()).nextInt(2);
			for (int i = 0; i < rng; i++)
				mat.getWorld().dropItemNaturally(mat.getLocation(), new ItemStack(Material.SEEDS));
			mat.getWorld().dropItemNaturally(mat.getLocation(), new ItemStack(Material.WHEAT));
			if (p.getInventory().contains(Material.SEEDS)) {
				mat.setData((byte) 0);
				for (ItemStack i : p.getInventory().getContents())
					if (i.getType().equals(Material.SEEDS)) {
						i.setAmount(i.getAmount() - 1);
						break;
					}
			} else
				mat.setType(Material.AIR);
			mat.getWorld().dropItemNaturally(mat.getLocation(), new ItemStack(Material.SEEDS));
		}
	}

	@SuppressWarnings("deprecation")
	private void breakPotato(Block mat, Player p) {
		if (mat.getData() == 7) {
			int rng = (new Random()).nextInt(2);
			for (int i = 0; i <= rng; i++)
				mat.getWorld().dropItemNaturally(mat.getLocation(), new ItemStack(Material.POTATO_ITEM));
			rng = (new Random()).nextInt(100);
			if (rng >= 80)
				mat.getWorld().dropItemNaturally(mat.getLocation(), new ItemStack(Material.POISONOUS_POTATO));
			if (p.getInventory().contains(Material.POTATO_ITEM)) {
				mat.setData((byte) 0);
				for (ItemStack i : p.getInventory().getContents())
					if (i.getType().equals(Material.POTATO_ITEM)) {
						i.setAmount(i.getAmount() - 1);
						break;
					}
			} else
				mat.setType(Material.AIR);
			mat.getWorld().dropItemNaturally(mat.getLocation(), new ItemStack(Material.POTATO_ITEM));
		}
	}

	@SuppressWarnings("deprecation")
	private void breakCarrot(Block mat, Player p) {
		if (mat.getData() == 7) {
			int rng = (new Random()).nextInt(2);
			for (int i = 0; i <= rng; i++)
				mat.getWorld().dropItemNaturally(mat.getLocation(), new ItemStack(Material.CARROT_ITEM));
			if (p.getInventory().contains(Material.CARROT_ITEM)) {
				mat.setData((byte) 0);
				for (ItemStack i : p.getInventory().getContents())
					if (i.getType().equals(Material.CARROT_ITEM)) {
						i.setAmount(i.getAmount() - 1);
						break;
					}
			} else
				mat.setType(Material.AIR);
			mat.getWorld().dropItemNaturally(mat.getLocation(), new ItemStack(Material.CARROT_ITEM));
		}
	}

	@SuppressWarnings("deprecation")
	private void breakBeet(Block mat, Player p) {
		if (mat.getData() == 3) {
			int rng = (new Random()).nextInt(1);
			for (int i = 0; i <= rng; i++)
				mat.getWorld().dropItemNaturally(mat.getLocation(), new ItemStack(Material.BEETROOT_SEEDS));
			if (p.getInventory().contains(Material.BEETROOT_SEEDS)) {
				mat.setData((byte) 0);
				for (ItemStack i : p.getInventory().getContents())
					if (i.getType().equals(Material.BEETROOT_SEEDS)) {
						i.setAmount(i.getAmount() - 1);
						break;
					}
			} else
				mat.setType(Material.AIR);
			mat.getWorld().dropItemNaturally(mat.getLocation(), new ItemStack(Material.BEETROOT_SEEDS));
		}
	}

	@SuppressWarnings("deprecation")
	private void breakWart(Block mat, Player p) {
		if (mat.getData() == 3) {
			int rng = (new Random()).nextInt(2);
			for (int i = 0; i <= rng; i++)
				mat.getWorld().dropItemNaturally(mat.getLocation(), new ItemStack(Material.NETHER_STALK));
			if (p.getInventory().contains(Material.NETHER_STALK)) {
				mat.setData((byte) 0);
				for (ItemStack i : p.getInventory().getContents())
					if (i.getType().equals(Material.NETHER_STALK)) {
						i.setAmount(i.getAmount() - 1);
						break;
					}
			} else
				mat.setType(Material.AIR);
			mat.getWorld().dropItemNaturally(mat.getLocation(), new ItemStack(Material.NETHER_STALK));
		}
	}
}
