package mx.x10.gamedomain.blockhunt.event.player;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import mx.x10.gamedomain.blockhunt.BlockHunt;

public class PlayerClick implements Listener {

	private BlockHunt plugin;

	public PlayerClick(BlockHunt pl) {
		plugin = pl;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerUse(PlayerInteractEvent event) {
		Player p = event.getPlayer();

		if (!(event.getItem().getType() == Material.GRASS))
			return;

		Server server = p.getServer();

		if (!(event.getAction() == Action.RIGHT_CLICK_AIR))
			return;

		if (p.getWorld().getName().equalsIgnoreCase(plugin.getConfig().getString("Hub World"))) {
			server.dispatchCommand(p, "menu");
		}

	}
}
