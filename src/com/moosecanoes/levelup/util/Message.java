/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  org.bukkit.configuration.file.FileConfiguration
 */
package com.moosecanoes.levelup.util;

import com.moosecanoes.levelup.Main;
import com.moosecanoes.levelup.util.Utils;
import com.moosecanoes.levelup.util.config.ConfigAccessor;
import java.util.Set;
import org.bukkit.configuration.file.FileConfiguration;

public enum Message {
    NO_PERMS("&cYou don't have permission!"),
    PLAYERS_ONLY("&cThis command is for players only!"),
    WORLD_ADDED("&aHeadHunter world added!"),
    WORLD_REMOVED("&aHeadHunter world removed!"),
    SIGN_CREATE("&aHeadHunter sign created!"),
    SIGN_BREAK("&aHeadHunter sign removed!"),
    WORLD_EXISTS("&cThat world is already a HeadHunter world!"),
    WORLD_INVALID("&cThat world is not a HeadHunter world!"),
    HEAD_INVALID("&cThis skull is invalid!"),
    NO_HEADS("&cYou are not holding player heads!"),
    NO_SKULLS("&cYou are not holding any heads!"),
    NO_BOUNTIES("&cThere are no bounties!"),
    BOUNTY_INVALID("&cThat bounty does not exist!"),
    BOUNTY_LOW("&cThat bounty is too low!"),
    BOUNTY_HIGH("&cThat bounty is too high!"),
    BOUNTY_COMPLETE("&aYour bounty target has been killed!"),
    BOUNTY_DISABLED("&cBounties are disabled!"),
    BOUNTIES_INVISIBLE("&cBounties cannot be displayed in a list!"),
    WHITELIST_EMPTY("&cThe whitelist is empty!"),
    WHITELIST_ADDED("&aPlayer added to HeadHunter whitelist!"),
    WHITELIST_REMOVED("&aPlayer removed from HeadHunter whitelist!"),
    WHITELIST_A_ERR("&cThat player is already on the whitelist!"),
    WHITELIST_R_ERR("&cThat player is not on the whitelist!"),
    AMOUNT_INVALID("&cThat is an invalid amount!"),
    SELF_TARGET("&cYou cannot target yourself!"),
    PLAYER_INVALID("&cThat's not a valid player!"),
    HOARD_MODE("&cYou cannot do that in Hoard Mode!"),
    CONVERT_SUCCESS("&aHeadHunter has successfully converted your inventory!"),
    CONVERT_NONE("&cFound no item stacks to convert."),
    CMD_ADD("&6Usage: /hunter addworld <world>"),
    CMD_REMOVE("&6Usage: /hunter removeworld <world>"),
    CMD_BOUNTY("&6Usage: /hunter bounty <add | remove | check | list>"),
    CMD_BOUNTY_CHECK("&6Usage: /hunter bounty check <target>"),
    CMD_BOUNTY_REMOVE("&6Usage: /hunter bounty remove <target> [amount]"),
    CMD_BOUNTY_ADD("&6Usage: /hunter bounty add <target> <amount>"),
    CMD_WHITELIST("&6Usage: /hunter whitelist [<add | remove> <target>]"),
    CMD_CONVERT("&6Usage: /hunter convert <PlayerHeads>"),
    CMD_CONVERT_ERR("&cYou cannot convert HeadHunter in Hoard Mode!");
    
    private String x;
    public static final String[] HELP_NORMAL;
    public static final String[] HELP_ADMIN;

    private Message(String x) {
        this.x = x;
    }

    public String x() {
        return Utils.color(this.x);
    }
/*
    public static void refresh(Main plugin) {
        Message.load(plugin);
        Message.save(plugin);
    }

    
    public static void load(Main plugin) {
        ConfigAccessor access = plugin.access("messages.yml");
        FileConfiguration config = access.getConfig();
        for (String key : config.getKeys(false)) {
            Message.valueOf((String)key).x = config.getString(key);
        }
        access.saveConfig();
    }

    public static void save(Main plugin) {
        ConfigAccessor access = plugin.access("messages.yml");
        FileConfiguration config = access.getConfig();
        for (Message msg : Message.values()) {
            config.set(msg.toString(), (Object)msg.x);
        }
        access.saveConfig();
    }
*/
    static {
        HELP_NORMAL = new String[]{"&6---=< &eHeadHunter Help &6>=---", "&6/hunter help", "   &eOpen this help message", "&6/hunter sellhead", "   &eSell one head from your inventory", "&6/hunter bounty <add | remove | check | list>", "   &eSet a bounty on a player's head"};
        HELP_ADMIN = new String[]{"&6/hunter addworld <world>", "   &eAdd a HeadHunter world", "&6/hunter removeworld <world>", "   &eRemove a HeadHunter world", "&6/hunter convert <PlayerHeads>", "   &eConvert your inventory to HeadHunter!", "&6/hunter whitelist [<add | remove> <target>]", "   &eChange the list of players to drop heads", "&6/hunter reload", "   &eReload the HeadHunter files"};
    }
}

