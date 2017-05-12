package mx.x10.gamedomain.blockhunt.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.md_5.bungee.api.ChatColor;

public class PlayerChat implements Listener {
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String message = event.getMessage().toLowerCase();
		
		if(message.contains("fuck")) {
			event.setCancelled(true);
			player.sendMessage(ChatColor.RED + "That is a bad word!");
		}
	}
}
