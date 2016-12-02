package com.computerdude.planetsplus.planets;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.computerdude.planetsplus.main.Main;

public class Planet implements Listener {

	private String name;
	private int number;
	private boolean survivable;
	private boolean hasOxygen;
	private boolean allowTown;
	private boolean allowSethome;
	private boolean hasAnimals;
	private boolean canBreak;

	public String getName() {
		return name;
	}

	private static void setName(String _name) {
		name = _name;
	}

	public String getNumber() {
		return number;
	}

	private static void setNumber(String _number) {
		number = _number;
	}

	public boolean isSurvivable() {
		return survivable;
	}

	private static void setSurvivable(boolean _survivable) {
		survivable = _survivable;
	}

	public boolean doesHaveOxygen() {
		return hasOxygen;
	}

	private static void setHasOxygen(boolean _hasOxygen) {
		hasOxygen = _hasOxygen;
	}

	public boolean doesAllowTown() {
		return allowTown;
	}

	private static void setAllowTown(boolean _allowTown) {
		allowTown = _allowTown;
	}

	public boolean doesAllowSethome() {
		return allowSethome;
	}

	private static void setAllowSethome(boolean _allowSethome) {
		allowSethome = _allowSethome;
	}

	public boolean doesHaveAnimals() {
		return hasAnimals;
	}

	private static void setHasAnimals(boolean _hasAnimals) {
		hasAnimals = _hasAnimals;
	}

	public boolean playerCanBreak() {
		return canBreak;
	}

	private static void setCanBreak(boolean _canBreak) {
		canBreak = _canBreak;
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
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if(canBreak == false) e.setCancelled(true);
	}

	
}
