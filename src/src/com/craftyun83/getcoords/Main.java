package com.craftyun83.getcoords;

import org.bukkit.plugin.java.JavaPlugin;

import com.craftyun83.getcoords.commands.GetCoordsCommands;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
		new GetCoordsCommands(this);
		
	}

}
