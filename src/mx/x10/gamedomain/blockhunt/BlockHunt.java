package mx.x10.gamedomain.blockhunt;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import mx.x10.gamedomain.blockhunt.commands.BHC;
import mx.x10.gamedomain.blockhunt.event.block.BlockBreak;
import mx.x10.gamedomain.blockhunt.event.inventory.InventoryClick;
import mx.x10.gamedomain.blockhunt.event.player.PlayerChat;
import mx.x10.gamedomain.blockhunt.event.player.PlayerClick;
import mx.x10.gamedomain.blockhunt.event.player.PlayerJoin;

public class BlockHunt extends JavaPlugin {

	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = Logger.getLogger("Minecraft");

		registerCommands();
		registerEvents();
		registerConfig();

		logger.info(pdfFile.getName() + " Ver: [" + pdfFile.getVersion() + "] has been enabled!");
	}

	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = Logger.getLogger("Minecraft");

		logger.info(pdfFile.getName() + " Ver: [" + pdfFile.getVersion() + "] has been disabled!");
	}

	public void registerCommands() {
		getCommand("blockhunt").setExecutor(new BHC(this));
		getCommand("bc").setExecutor(new BHC(this));
		getCommand("bhc").setExecutor(new BHC(this));
		getCommand("bh").setExecutor(new BHC(this));
	}

	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();

		pm.registerEvents(new BlockBreak(), this);
		pm.registerEvents(new PlayerChat(), this);
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new InventoryClick(this), this);
		pm.registerEvents(new PlayerClick(this), this);
	}

	private void registerConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
}
