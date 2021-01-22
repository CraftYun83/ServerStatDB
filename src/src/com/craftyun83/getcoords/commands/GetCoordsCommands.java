package com.craftyun83.getcoords.commands;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.craftyun83.getcoords.Main;

public class GetCoordsCommands implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;
	public GetCoordsCommands (Main plugin) {
		this.plugin = plugin;
		
		plugin.getCommand("getcoords").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if (cmd.getName().equals("getcoords")) {
			
			try {
				
				try {
					
					Player p = Bukkit.getPlayer(args[0]);
					
					DecimalFormat df = new DecimalFormat("#.##");
					df.setRoundingMode(RoundingMode.CEILING);
					
					
					sender.sendMessage(ChatColor.YELLOW+p.getName()+"'s Coords");
					sender.sendMessage(ChatColor.YELLOW+"X: "+df.format(p.getLocation().getX())+" | Y: "+df.format(p.getLocation().getY())+" | Z: "+df.format(p.getLocation().getZ()));
					
				} catch (NullPointerException exc) {
					
					sender.sendMessage(ChatColor.RED+args[0]+" is not online!");
					
				}
				
			} catch (ArrayIndexOutOfBoundsException exc) {
				
				sender.sendMessage(ChatColor.RED+"Please specify a player name!");
				
			}
			
		}
		
		return false;
	}

}
