package com.jkush321.autowalls.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jkush321.autowalls.AutoWalls;
import com.jkush321.autowalls.TeleportManager;

public class DeathmatchCommand implements CommandExecutor {

    private AutoWalls plugin;

	public DeathmatchCommand(AutoWalls plugin) {
		this.plugin = plugin;
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender.hasPermission("walls.op") || sender.isOp()) {
		if (sender instanceof Player) {
			Player p = (Player)sender;
			Location l = p.getLocation();
			if (args.length == 0 && plugin.gameInProgress) {
				TeleportManager.deathMatch();
		} else if (args.length == 1 && args[0] == "setspawn1") {
	        	plugin.getConfig().set("SpawnX1", Double.valueOf(l.getBlockX() + 0.5));
	        	plugin.getConfig().set("SpawnY1", Double.valueOf(l.getBlockY() + 0.5));
	        	plugin.getConfig().set("SpawnZ1", Double.valueOf(l.getBlockZ() + 0.5));
	        	plugin.saveConfig();
	        	p.sendMessage(ChatColor.GREEN + "Deathmatch spawn for map 1 set!");
		} else if (args.length == 1 && args[0] == "setspawn2") {
        	plugin.getConfig().set("SpawnX2", Double.valueOf(l.getBlockX() + 0.5));
        	plugin.getConfig().set("SpawnY2", Double.valueOf(l.getBlockY() + 0.5));
        	plugin.getConfig().set("SpawnZ2", Double.valueOf(l.getBlockZ() + 0.5));
        	p.sendMessage(ChatColor.GREEN + "DeathMatch spawn for map 2 set!");
        	plugin.saveConfig();
		} else {
			p.sendMessage(ChatColor.RED + "Invalid stuff, ask LaxWashere");
		} 
	} sender.sendMessage("Nope!");
		} return false;
	}
}