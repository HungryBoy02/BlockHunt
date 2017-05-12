package mx.x10.gamedomain.blockhunt.event.player;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import mx.x10.gamedomain.blockhunt.BlockHunt;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_11_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_11_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_11_R1.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_11_R1.PlayerConnection;

public class PlayerJoin implements Listener {

	private BlockHunt plugin;

	public PlayerJoin(BlockHunt pl) {
		plugin = pl;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {

		String welcomeMessage = ChatColor.translateAlternateColorCodes('&',
				plugin.getConfig().getString("Welcome Message"));
		Player player = event.getPlayer();
		// player.sendMessage(welcomeMessage);
		String welcomeMessageFinal = "{\"text\":\"" + welcomeMessage + "\"}";
		PacketPlayOutTitle welcomeTitle = new PacketPlayOutTitle(EnumTitleAction.TITLE,
				ChatSerializer.a(welcomeMessageFinal), 20, 40, 20);
		PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
		connection.sendPacket(welcomeTitle);
		List<String> joinCommands = plugin.getConfig().getStringList("Join Commands");

		Server server = player.getServer();
		for (String cmd : joinCommands) {
			server.dispatchCommand(player, cmd);
		}
		player.getInventory().clear();
		player.getInventory().addItem(nameItemNRS(Material.GRASS, "Server Menu"));
	}

	private ItemStack nameItem(ItemStack item, String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.RESET + name);

		item.setItemMeta(meta);
		return item;
	}

	private ItemStack nameItemNRS(Material item, String name) {
		return nameItem(new ItemStack(item), name);
	}
}
