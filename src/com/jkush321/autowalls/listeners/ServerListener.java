package com.jkush321.autowalls.listeners;

import com.jkush321.autowalls.AutoWalls;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListener implements Listener {

    private AutoWalls plugin;

    public ServerListener(AutoWalls plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPing(ServerListPingEvent e)
    {
        String message = "AutoWalls Server";
        if (!AutoWalls.gameInProgress && !AutoWalls.gameOver)
        {
            message=(ChatColor.GREEN + "Game is ready");
        }
        else if (AutoWalls.gameInProgress)
        {
            message=(ChatColor.GREEN + "Game started");
        }
        else if (AutoWalls.gameOver)
        {
            message=ChatColor.GREEN + "Game ended";
        }
        e.setMotd(message);
    }

}
