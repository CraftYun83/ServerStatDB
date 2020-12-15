package com.craftyun83.serverstatdb.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.craftyun83.serverstatdb.Main;

public class PluginCommands implements CommandExecutor{
	
	private Main plugin;
	public PluginCommands(Main plugin) {
		 this.plugin = plugin;
		 plugin.getCommand("serverstatdb").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if (args[0].equalsIgnoreCase("data")) {
			if (sender.hasPermission("ssdb.data")) {
				try {
					sender.sendMessage(ChatColor.YELLOW+"Unique_Players: "+String.valueOf(plugin.getConfig().get("Unique_Players")));
					sender.sendMessage(ChatColor.YELLOW+"Players_Joined: "+String.valueOf(plugin.getConfig().get("Players_Joined")));
					sender.sendMessage(ChatColor.YELLOW+"Online_Players: "+String.valueOf(plugin.getConfig().get("Online_Players")));
				} catch (NullPointerException e) {
					sender.sendMessage("Try reinstalling the plugin, one of the object in 'config.yml' is missing.");
				}
			} else {
				sender.sendMessage(ChatColor.RED+"You do not have sufficient permission!");
			}
		}
		if (args[0].equalsIgnoreCase("update")) {
			if (sender.hasPermission("ssdb.update")) {
				plugin.getConfig().set("Online_Players", plugin.getServer().getOnlinePlayers().size());
				plugin.getConfig().set("Server_MOTD", plugin.getServer().getMotd());
				sender.sendMessage(ChatColor.GREEN+"All server statistics has been updated!");
			} else {
				sender.sendMessage(ChatColor.RED+"You do not have sufficient permission!");
			}
		}
		return false;
	}

}
