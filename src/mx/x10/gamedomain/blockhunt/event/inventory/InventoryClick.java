package mx.x10.gamedomain.blockhunt.event.inventory;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import mx.x10.gamedomain.blockhunt.BlockHunt;

public class InventoryClick implements Listener {
	
	private BlockHunt plugin;

	public InventoryClick(BlockHunt pl) {
		plugin = pl;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (!(event.getWhoClicked() instanceof Player))
			return;
		Inventory inv = event.getInventory();
		if (inv.getTitle().equals("Equip GUI")) {
			Player player = (Player) event.getWhoClicked();
			ItemStack item = event.getCurrentItem();
			if (item.getType() == Material.DIAMOND_SWORD) {
				PlayerInventory plrinv = player.getInventory();

				player.sendMessage(ChatColor.GOLD + "Equiped with combat set!");

				inv.clear();

				ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
				ItemStack shield = new ItemStack(Material.SHIELD);
				ItemStack totem = new ItemStack(Material.TOTEM);
				ItemStack glass = new ItemStack(Material.GLASS);
				ItemStack leatherChestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
				ItemStack chainPants = new ItemStack(Material.CHAINMAIL_LEGGINGS);
				ItemStack leatherBoots = new ItemStack(Material.LEATHER_BOOTS);

				diamondSword.addUnsafeEnchantment(Enchantment.KNOCKBACK, 5);

				plrinv.addItem(diamondSword, shield, totem);
				plrinv.setHelmet(glass);
				plrinv.setChestplate(leatherChestplate);
				plrinv.setLeggings(chainPants);
				plrinv.setBoots(leatherBoots);

				player.getWorld().playEffect(player.getLocation(), Effect.BLAZE_SHOOT, 1);

				event.setCancelled(true);
				player.closeInventory();
			} else {
				
			}

		}
		if (inv.getTitle().equals("Server Menu")) {
			Player player = (Player) event.getWhoClicked();
			ItemStack item = event.getCurrentItem();
			List<String> menuitems = plugin.getConfig().getStringList("Menu Items");
			
			if (item.getType() == Material.COMPASS) {
				for(String items : menuitems) {
					String itemout[]=items.split("-");
					if(itemout[0].equalsIgnoreCase("compass")){
						Server server = player.getServer();
						event.setCancelled(true);
						player.closeInventory();
						if(player.isOp()){
						server.dispatchCommand(player, itemout[3]);
						}else{
							player.setOp(true);
							server.dispatchCommand(player, itemout[3]);
							player.setOp(false);
						}
					}
				}
			}
			if (item.getType() == Material.DIAMOND_SWORD) {
				for(String items : menuitems) {
					String itemout[]=items.split("-");
					if(itemout[0].equalsIgnoreCase("diamondsword")){
						Server server = player.getServer();
						event.setCancelled(true);
						player.closeInventory();
						if(player.isOp()){
						server.dispatchCommand(player, itemout[3]);
						}else{
							player.setOp(true);
							server.dispatchCommand(player, itemout[3]);
							player.setOp(false);
						}
					}
				}
			}
			if (item.getType() == Material.GOLD_SWORD) {
				for(String items : menuitems) {
					String itemout[]=items.split("-");
					if(itemout[0].equalsIgnoreCase("goldsword")){
						Server server = player.getServer();
						event.setCancelled(true);
						player.closeInventory();
						if(player.isOp()){
						server.dispatchCommand(player, itemout[3]);
						}else{
							player.setOp(true);
							server.dispatchCommand(player, itemout[3]);
							player.setOp(false);
						}
					}
				}
			}
			if (item.getType() == Material.IRON_SWORD) {
				for(String items : menuitems) {
					String itemout[]=items.split("-");
					if(itemout[0].equalsIgnoreCase("ironsword")){
						Server server = player.getServer();
						event.setCancelled(true);
						player.closeInventory();
						if(player.isOp()){
						server.dispatchCommand(player, itemout[3]);
						}else{
							player.setOp(true);
							server.dispatchCommand(player, itemout[3]);
							player.setOp(false);
						}
					}
				}
			}
			if (item.getType() == Material.DIAMOND_SPADE) {
				for(String items : menuitems) {
					String itemout[]=items.split("-");
					if(itemout[0].equalsIgnoreCase("diamondshovel")){
						Server server = player.getServer();
						event.setCancelled(true);
						player.closeInventory();
						if(player.isOp()){
						server.dispatchCommand(player, itemout[3]);
						}else{
							player.setOp(true);
							server.dispatchCommand(player, itemout[3]);
							player.setOp(false);
						}
					}
				}
			}
			if (item.getType() == Material.GOLD_SPADE) {
				for(String items : menuitems) {
					String itemout[]=items.split("-");
					if(itemout[0].equalsIgnoreCase("goldshovel")){
						Server server = player.getServer();
						event.setCancelled(true);
						player.closeInventory();
						if(player.isOp()){
						server.dispatchCommand(player, itemout[3]);
						}else{
							player.setOp(true);
							server.dispatchCommand(player, itemout[3]);
							player.setOp(false);
						}
					}
				}
			}
			if (item.getType() == Material.IRON_SPADE) {
				for(String items : menuitems) {
					String itemout[]=items.split("-");
					if(itemout[0].equalsIgnoreCase("ironshovel")){
						Server server = player.getServer();
						event.setCancelled(true);
						player.closeInventory();
						if(player.isOp()){
						server.dispatchCommand(player, itemout[3]);
						}else{
							player.setOp(true);
							server.dispatchCommand(player, itemout[3]);
							player.setOp(false);
						}
					}
				}
			}
			if (item.getType() == Material.GRASS) {
				for(String items : menuitems) {
					String itemout[]=items.split("-");
					if(itemout[0].equalsIgnoreCase("grassblock")){
						Server server = player.getServer();
						event.setCancelled(true);
						player.closeInventory();
						if(player.isOp()){
						server.dispatchCommand(player, itemout[3]);
						}else{
							player.setOp(true);
							server.dispatchCommand(player, itemout[3]);
							player.setOp(false);
						}
					}
				}
			}
			if (item.getType() == Material.STONE) {
				for(String items : menuitems) {
					String itemout[]=items.split("-");
					if(itemout[0].equalsIgnoreCase("stoneblock")){
						Server server = player.getServer();
						event.setCancelled(true);
						player.closeInventory();
						if(player.isOp()){
						server.dispatchCommand(player, itemout[3]);
						}else{
							player.setOp(true);
							server.dispatchCommand(player, itemout[3]);
							player.setOp(false);
						}
					}
				}
			}
			if (item.getType() == Material.IRON_FENCE) {
				for(String items : menuitems) {
					String itemout[]=items.split("-");
					if(itemout[0].equalsIgnoreCase("ironbars")){
						Server server = player.getServer();
						event.setCancelled(true);
						player.closeInventory();
						if(player.isOp()){
						server.dispatchCommand(player, itemout[3]);
						}else{
							player.setOp(true);
							server.dispatchCommand(player, itemout[3]);
							player.setOp(false);
						}
					}
				}
			}
			if (item.getType() == Material.END_ROD) {
				for(String items : menuitems) {
					String itemout[]=items.split("-");
					if(itemout[0].equalsIgnoreCase("endrod")){
						Server server = player.getServer();
						event.setCancelled(true);
						player.closeInventory();
						if(player.isOp()){
						server.dispatchCommand(player, itemout[3]);
						}else{
							player.setOp(true);
							server.dispatchCommand(player, itemout[3]);
							player.setOp(false);
						}
					}
				}
			}
			if (item.getType() == Material.TOTEM) {
				for(String items : menuitems) {
					String itemout[]=items.split("-");
					if(itemout[0].equalsIgnoreCase("totem")){
						Server server = player.getServer();
						event.setCancelled(true);
						player.closeInventory();
						if(player.isOp()){
						server.dispatchCommand(player, itemout[3]);
						}else{
							player.setOp(true);
							server.dispatchCommand(player, itemout[3]);
							player.setOp(false);
						}
					}
				}
			}
			if (item.getType() == Material.GLASS) {
				for(String items : menuitems) {
					String itemout[]=items.split("-");
					if(itemout[0].equalsIgnoreCase("glassblock")){
						Server server = player.getServer();
						event.setCancelled(true);
						player.closeInventory();
						if(player.isOp()){
						server.dispatchCommand(player, itemout[3]);
						}else{
							player.setOp(true);
							server.dispatchCommand(player, itemout[3]);
							player.setOp(false);
						}
					}
				}
			}
			if (item.getType() == Material.SNOW_BALL) {
				for(String items : menuitems) {
					String itemout[]=items.split("-");
					if(itemout[0].equalsIgnoreCase("snowball")){
						Server server = player.getServer();
						event.setCancelled(true);
						player.closeInventory();
						if(player.isOp()){
						server.dispatchCommand(player, itemout[3]);
						}else{
							player.setOp(true);
							server.dispatchCommand(player, itemout[3]);
							player.setOp(false);
						}
					}
				}
			}
		}
	}
}
