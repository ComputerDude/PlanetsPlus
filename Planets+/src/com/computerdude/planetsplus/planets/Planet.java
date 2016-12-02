package com.computerdude.planetsplus.planets;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.computerdude.planetsplus.main.Main;

public class Planet implements Listener {

	private static String name;
	private static String number;
	private static boolean canLive;
	private static boolean hasOxygen;
	private static boolean allowTown;
	private static boolean allowSethome;
	private static boolean hasAnimals;
	private static boolean canBreak;

	public String getName() {
		return name;
	}

	private static void setName(String name) {
		Planet.name = name;
	}

	public String getNumber() {
		return number;
	}

	private static void setNumber(String number) {
		Planet.number = number;
	}

	public boolean isCanLive() {
		return canLive;
	}

	private static void setCanLive(boolean canLive) {
		Planet.canLive = canLive;
	}

	public boolean isHasOxygen() {
		return hasOxygen;
	}

	private static void setHasOxygen(boolean hasOxygen) {
		Planet.hasOxygen = hasOxygen;
	}

	public boolean isAllowTown() {
		return allowTown;
	}

	private static void setAllowTown(boolean allowTown) {
		Planet.allowTown = allowTown;
	}

	public boolean isAllowSethome() {
		return allowSethome;
	}

	private static void setAllowSethome(boolean allowSethome) {
		Planet.allowSethome = allowSethome;
	}

	public boolean isHasAnimals() {
		return hasAnimals;
	}

	private static void setHasAnimals(boolean hasAnimals) {
		Planet.hasAnimals = hasAnimals;
	}

	public boolean isCanBreak() {
		return canBreak;
	}

	private static void setCanBreak(boolean canBreak) {
		Planet.canBreak = canBreak;
	}

	public Planet(String name, String number, boolean canLive, boolean hasOxygen, boolean allowTown,
			boolean allowSethome, boolean hasAnimals, boolean canBreak) {

		setAllowSethome(allowSethome);
		setAllowTown(allowTown);
		setCanBreak(canBreak);
		setCanLive(canLive);
		setHasAnimals(hasAnimals);
		setHasOxygen(hasOxygen);
		setName(name);
		setNumber(number);
		
	}

	@EventHandler
	public void onPlayerSwitchWorld(PlayerChangedWorldEvent e) {
		Player player = e.getPlayer();
			player.sendMessage(Main.color("&7&l[&c&lPlus+&7&l] &3Tardis landed on planet " + getName()));
		if(hasOxygen == false) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 900000, 1));
		} else {
			player.removePotionEffect(PotionEffectType.POISON);
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		if(canBreak == false) {
			e.setCancelled(true);
		}
	}

	
}
