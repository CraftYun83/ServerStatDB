package com.craftyun83.serverstatdb.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.craftyun83.serverstatdb.Main;

public class JoinListener implements Listener{
	
	private Main plugin;
	
	public JoinListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		
		if (!(e.getPlayer().hasPlayedBefore())) {
			plugin.getConfig().set("Unique_Players", ((int) plugin.getConfig().get("Unique_Players"))+1);
			plugin.getConfig().set("Players_Joined", ((int) plugin.getConfig().get("Players_Joined"))+1);
		} else {
			plugin.getConfig().set("Players_Joined", ((int) plugin.getConfig().get("Players_Joined"))+1);
		}
		
		plugin.getConfig().set("Online_Players", plugin.getServer().getOnlinePlayers().size());
		plugin.saveConfig();
		
	}

}
