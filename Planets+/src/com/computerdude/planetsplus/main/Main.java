package com.computerdude.planetsplus.main;

import org.bukkit.plugin.java.JavaPlugin;

import com.computerdude.planetsplus.planets.Planet;
import com.computerdude.planetsplus.planets.Sun;
import com.computerdude.planetsplus.planets.Zespoanov;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		Zespoanov.setZespoanov(new Planet("zespoanov", "6-E", true, true, false, false, true, false));
		Sun.setSun(new Planet("sun", "5-R", false, false, false, false, false, false));
	}

	@Override
	public void onDisable() {

	}

	public static String color(String uncoloredtext) {
		String color = ChatColor.translateAlternateColorCodes('&', uncoloredtext);
		return color;
	}

}
