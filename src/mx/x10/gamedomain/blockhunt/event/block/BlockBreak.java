package mx.x10.gamedomain.blockhunt.event.block;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		Player player = event.getPlayer();
		
		Block block = event.getBlock();
		Material material = block.getType();
		
		if(material == Material.BEDROCK) {
			player.sendMessage(ChatColor.RED + "You can't break bedrock!");
			event.setCancelled(true);
		}
	}
	
}
