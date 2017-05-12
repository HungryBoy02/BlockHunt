package mx.x10.gamedomain.blockhunt.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

import mx.x10.gamedomain.blockhunt.BlockHunt;

public class BHC implements CommandExecutor {
	private BlockHunt plugin;

	public BHC(BlockHunt pl) {
		plugin = pl;
	}
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You currently must be a player to use this command!");
			return false;
		}
		Player player = (Player) sender;
		if (player.hasPermission("blockhunt.bhc")) {
			if (args.length==0) {
				player.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "---------------------------------");
				player.sendMessage(ChatColor.RED + " Block Hunt, by HungryBoy02");
				PluginDescriptionFile pdfFile = plugin.getDescription();
				player.sendMessage(ChatColor.GREEN + "     Version: " + pdfFile.getVersion());
				player.sendMessage(ChatColor.AQUA + " /bh help " + ChatColor.RED + "for help.");
				player.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "---------------------------------");
			}else if(args[0].equalsIgnoreCase("help")){
				if(args.length==1){
					bhhelp("1", player);
				}else if(args.length==2){
					bhhelp(args[1], player);
				}
			}else if(args[0].equalsIgnoreCase("sethub")){
				if (player.hasPermission("blockhunt.sethub")){
				plugin.reloadConfig();
				plugin.getConfig().set("BlockHunt Hub.world", player.getWorld().getName());
				plugin.getConfig().set("BlockHunt Hub.X", player.getLocation().getX());
				plugin.getConfig().set("BlockHunt Hub.Y", player.getLocation().getY());
				plugin.getConfig().set("BlockHunt Hub.Z", player.getLocation().getZ());
				player.sendMessage("Successfully set the Block Hunt hub to:");
				plugin.saveConfig();
				plugin.reloadConfig();
				player.sendMessage("X:" + plugin.getConfig().getInt("BlockHunt Hub.X") + ", " + "Y:" + plugin.getConfig().getInt("BlockHunt Hub.Y") + ", " + "Z:" + plugin.getConfig().getInt("BlockHunt Hub.Z") + ", " + "In world: " + plugin.getConfig().getString("BlockHunt Hub.world"));
				} else player.sendMessage(ChatColor.RED + "You can't do that!");
			}else if(args[0].equalsIgnoreCase("reload")){
				if (player.hasPermission("blockhunt.sethub")) {
				plugin.reloadConfig();
				plugin.saveConfig();
				player.sendMessage(ChatColor.GOLD + "Block Hunt has reloaded!");
				} else player.sendMessage(ChatColor.RED + "You can't do that!");
			}else if(args[0].equalsIgnoreCase("join")) {
				if (player.hasPermission("blockhunt.join")) {
					Location endres = new Location(Bukkit.getWorld(plugin.getConfig().getString("BlockHunt Hub.world")), plugin.getConfig().getInt("BlockHunt Hub.X"), plugin.getConfig().getInt("BlockHunt Hub.Y"), plugin.getConfig().getInt("BlockHunt Hub.Z"));
					player.teleport(endres);
				} else player.sendMessage(ChatColor.RED + "You can't do that!");
			}else if(args[0].equalsIgnoreCase("leave")) {
				if (player.hasPermission("blockhunt.leave")) {
					player.teleport(Bukkit.getWorld(plugin.getConfig().getString("lWorld")).getSpawnLocation());
				} else player.sendMessage(ChatColor.RED + "You can't do that!");
			}else if(args[0].equalsIgnoreCase("setlworld")) {
				if (player.hasPermission("blockhunt.setlworld")) {
					plugin.reloadConfig();
					plugin.getConfig().set("lWorld", player.getWorld().getName());;
					player.sendMessage("Successfully set lWorld to:");
					plugin.saveConfig();
					plugin.reloadConfig();
					player.sendMessage(plugin.getConfig().getString("lWorld"));
				} else player.sendMessage(ChatColor.RED + "You can't do that!");
			}
			return true;
		} else {
			player.sendMessage(ChatColor.RED + "You do not have permission to use that command!");
			return false;
		}
	}
	private void bhhelp(String Spage, Player player) {
		int maxpages = 1;
		int page = Integer.parseInt(Spage);
		if (page>maxpages){
			player.sendMessage("There is no page " + page);
		}else if (page==1) {
			player.sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "Showing page 1/1");
			player.sendMessage("/bh help [page] - Shows this list");
			if (player.hasPermission("blockhunt.sethub")) {player.sendMessage("/bh sethub - Sets the hub for block hunt to where you are standing");}
			if (player.hasPermission("blockhunt.reload")) {player.sendMessage("/bh reload - Reloads Block Hunt config file");}
			if (player.hasPermission("blockhunt.join")) {player.sendMessage("/bh join - Joins the block hunt lobby");}
			if (player.hasPermission("blockhunt.leave")) {player.sendMessage("/bh leave - Leaves the block hunt lobby");}
			if (player.hasPermission("blockhunt.setlworld")) {player.sendMessage("/bh setlworld - Sets the world to send the player when they run /bh leave (make this your hubworld)");}
		}
	}

}