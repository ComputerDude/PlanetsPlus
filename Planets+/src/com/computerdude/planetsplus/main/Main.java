package com.computerdude.planetsplus.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.computerdude.planetsplus.planets.Planet;
import com.computerdude.planetsplus.planets.Sun;
import com.computerdude.planetsplus.planets.Zespoanov;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		pm.registerEvents(new Sun(), this);
		pm.registerEvents(new Zespoanov(), this);
	}

	@Override
	public void onDisable() {

	}

	public static String color(String uncoloredtext) {
		String color = ChatColor.translateAlternateColorCodes('&', uncoloredtext);
		return color;
	}

}
