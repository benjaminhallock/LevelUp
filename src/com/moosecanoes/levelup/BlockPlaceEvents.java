package com.moosecanoes.levelup;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExpEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.block.Chest;
import org.bukkit.material.Bed;
import net.milkbowl.vault.economy.EconomyResponse;

import com.moosecanoes.levelup.EventSellHeads;

public class BlockPlaceEvents implements Listener 
{
	  
    private Main plugin;
    private static final Logger log = Logger.getLogger("Minecraft");

    public BlockPlaceEvents(Main instance) {
        this.plugin = instance;
    }  
    
    @EventHandler
    public void onPlayerChat(PlayerChatEvent e)
    {	
    	if (e.getPlayer().getLevel() < 5)
    	{
    		e.getPlayer().sendMessage("You can't chat until level 5!");
    		EventSellHeads sell = new EventSellHeads();
    		plugin.getServer().getPluginManager().callEvent(sell);
    		e.setCancelled(true);
    	}
    }
    
    @EventHandler
    public void onEventSell (EventSellHeads e)
    {
    	log.info("PLayer sold heads");
    }
    
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
//    	event.getPlayer().setExp(0);
    	log.info("Player did join");
    }
    
    @EventHandler
    public void OnDeath(PlayerDeathEvent e)
    {
    	log.info("Player died");
    }
    
    @EventHandler
    public void onDeath(EntityDeathEvent e) {
//        if (this.plugin.getConfig().getBoolean("EXP.Mob")) {
            e.setDroppedExp(0);
            log.info("entity died with xp of " + e.getDroppedExp());
//        }
    }
    
    @EventHandler
    public void onPlayerExpChange(PlayerExpChangeEvent e) {
//        if (this.plugin.getConfig().getBoolean("EXP.ALL")) {
            e.setAmount(0);
            log.info("Player xp changed with" + e.getAmount());
//        }
    }
    
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
//        if (this.plugin.getConfig().getBoolean("EXP.Ore")) {
            e.setExpToDrop(0);
//        }
    }
    
  @EventHandler
  public void onBlockPlace(BlockPlaceEvent e) 
  {	  
      EventSellHeads event = new EventSellHeads();
      plugin.getServer().getPluginManager().callEvent(event);
	  
      ItemStack is = e.getPlayer().getItemOnCursor();
      Player plr = e.getPlayer();
//      if (!Config.denySpawnerPlacement || is.getType() != Material.MOB_SPAWNER || plr.hasPermission("headrankup.anyspawner")) {
//          return;
//      }
//    Collect xp amount and give it to player if xp is requested.
      int level = plr.getLevel();
      if (level == 0) plr.setLevel(1);
      int expNeededToLevelUp = 2000;
      int expTotalToLevelUp = plr.getExpToLevel();
      float percentageOfLevel = plr.getExp();
      int expOfTotal = plr.getTotalExperience();
      log.info("xptolevel: " + expTotalToLevelUp + percentageOfLevel + "total EXP: " + expOfTotal);
      
      float newPercentage = (float) (percentageOfLevel + (5.0/(float)expNeededToLevelUp));
      if (newPercentage < 1) plr.setExp(newPercentage);
      else
      {
      plr.setExp(1.0f);
      plr.getWorld().playSound(plr.getLocation(), Sound.FIREWORK_LARGE_BLAST2, 3.0F, 0.533F);
      plr.getWorld().playSound(plr.getLocation(), Sound.FIREWORK_TWINKLE, 3.0F, 0.533F);
      plr.getWorld().playSound(plr.getLocation(), Sound.FIREWORK_TWINKLE2, 3.0F, 0.533F);
      }
      
      float percentageRemaining = 1 - newPercentage;
      int xpRemaining = (int)(percentageRemaining * (float)expNeededToLevelUp);
      log.info("Xp Remaining:" + xpRemaining);
      log.info("Current Level:" + plr.getLevel());
      /*
      boolean isUserRewarded = true;    
      if (isUserRewarded)
      {
      	EconomyResponse r = econ.depositPlayer(plr, 100.00);
          if(r.transactionSuccess()) {
              plr.sendMessage(String.format("You were given %s and now have %s", econ.format(r.amount), econ.format(r.balance)));
          } else {
              plr.sendMessage(String.format("An error occured: %s", r.errorMessage));
          }
      } 
	*/
}
}
