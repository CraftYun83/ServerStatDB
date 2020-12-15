package com.craftyun83.serverstatdb.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.craftyun83.serverstatdb.Main;

public class LeaveListener implements Listener{
	
	private Main plugin;
	
	public LeaveListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				plugin.getConfig().set("Online_Players", plugin.getServer().getOnlinePlayers().size());
				plugin.saveConfig();
			}
			
		}, 100L);
		
	}

}
