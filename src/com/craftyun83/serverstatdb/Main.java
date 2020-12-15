package com.craftyun83.serverstatdb;

import org.bukkit.plugin.java.JavaPlugin;

import com.craftyun83.serverstatdb.command.PluginCommands;
import com.craftyun83.serverstatdb.listeners.JoinListener;
import com.craftyun83.serverstatdb.listeners.LeaveListener;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		// Command Classes
		new PluginCommands(this);
		
		// Listener Classes
		new JoinListener(this);
		new LeaveListener(this);
		
		getConfig().set("Online_Players", getServer().getOnlinePlayers().size());
		getConfig().set("Server_MOTD", getServer().getMotd());
		saveConfig();
		
	}

}
