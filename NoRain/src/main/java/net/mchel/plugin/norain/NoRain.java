package net.mchel.plugin.norain;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoRain extends JavaPlugin implements Listener{

	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		for (World world : Bukkit.getWorlds()) {
			if (world.getEnvironment().equals(Environment.NORMAL)) {
				world.setWeatherDuration(1);
			}
		}
	}
	@Override
	public void onDisable() {}

	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e) {
		if ((e.toWeatherState())) {
			e.setCancelled(true);
		}
	}

}
