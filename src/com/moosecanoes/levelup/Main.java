package com.moosecanoes.levelup;

import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Logger;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{

    private static final Logger log = Logger.getLogger("Minecraft");
    public static Economy econ = null;
    public static Chat chat = null;
    public static FileConfiguration config;
    
    public static Permission perms;

    @Override
    public void onDisable() {
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
    }

    @Override
    public void onEnable() 
    {
//    	this.getConfig();
//    	this.getConfig().addDefault("youAreAwesome", true);
//    	this.saveDefaultConfig();
    	
        if (Bukkit.getPluginManager().isPluginEnabled("HeadHunter")) 
        {
          log.info(String.format("[%s] - Head Hunter found!", getDescription().getName()));
        }
        else
        {
            log.severe(String.format("[%s] -  No HeadHunter dependency found!", getDescription().getName()));	
        }
    	
    	
    	this.getServer().getPluginManager().registerEvents((Listener)new BlockPlaceEvents(this), this);
  
        
    	if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        else
        {
        	log.info(String.format("[%s] Vault enabled for LevelUp", getDescription().getName()));
        }
        
        //setupPermissions();
        //setupChat();
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        
    	 if (!sender.hasPermission(command.getPermission())) {
    	        command.setPermissionMessage("BLALALL");
    	        return false;
           }
    	 
    	if(!(sender instanceof Player)) 
        {
            log.info("Only players are supported for this Example Plugin, but you should not do this!!!");
            return true;
        }
    	    	
        Player player = (Player) sender;
        
//      Save level for each ability in config then insert string here.
        if(player.hasPermission("levelup.1"))
        {
        	log.info("Player has level 1 permission");
        }
        if (player.hasPermission("levelup.10"))
        {
        	log.info("Player has level 10 permission");
        }
        
        
        if(command.getLabel().equals("levelup")) 
        {	
        	HashMap<UUID, PermissionAttachment> perms = new HashMap<UUID, PermissionAttachment>();
        	
        	String newString = "levelup." + (player.getLevel() + 1);
        	
        	PermissionAttachment attachment = player.addAttachment(this);
        	perms.put(player.getUniqueId(), attachment);
        	PermissionAttachment pperms = perms.get(player.getUniqueId());
        	pperms.setPermission(newString, true);
        	
        	int levelOne = 2000;
        	float percentageOfLevel = player.getExp();
            
            float percentageRemaining = 1 - percentageOfLevel;
            int xpRemaining = (int)(percentageRemaining * levelOne);
            int level = player.getLevel();
            if (xpRemaining > 1)
            {
            	player.sendMessage(ChatColor.RED + "You still need " + (xpRemaining - 1) + " XP to LevelUp!" );
            	return true;
            }
        	
        	player.setExp(0);
        	player.setLevel(player.getLevel() + 1);
        	player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 3.0F, 0.533F);

//        	player.giveExpLevels(player.getLevel() + 1);
            // Lets give the player 1.05 currency (note that SOME economic plugins require rounding!)
            
            EconomyResponse r = econ.depositPlayer(player, 1.05);
            if(r.transactionSuccess()) {
                sender.sendMessage(String.format("You were given %s and now have %s", econ.format(r.amount), econ.format(r.balance)));
                sender.sendMessage(String.format("You have %s", econ.format(econ.getBalance(player.getName()))));
            } else {
                sender.sendMessage(String.format("An error occured: %s", r.errorMessage));
            }
            return true;
        }
        else if(command.getLabel().equals("prestige"))
        {
            // Lets test if user has the node "example.plugin.awesome" to determine if they are awesome or just suck
            if(player.hasPermission("levelup.prestige")) 
            {
                	player.setLevel(1);
                	player.setExp(0.0f);
//                	Get prestige level from database
                	String newString = "levelup.prestige" + (1);
                	
                	HashMap<UUID, PermissionAttachment> perms = new HashMap<UUID, PermissionAttachment>();

                	PermissionAttachment attachment = player.addAttachment(this);
                	perms.put(player.getUniqueId(), attachment);
                	PermissionAttachment pperms = perms.get(player.getUniqueId());
                	pperms.setPermission(newString, true);        	
            }
            return true;
        } else {
            return false;
        }
    }
}
