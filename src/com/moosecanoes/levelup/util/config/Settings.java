/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  org.bukkit.configuration.file.FileConfiguration
 */
package com.moosecanoes.levelup.util.config;

import com.moosecanoes.levelup.Main;
import org.bukkit.configuration.file.FileConfiguration;

public final class Settings {
    private static boolean hoardMode = false;
    private static double sellRate = 10.0;
    private static boolean usePercent = true;
    private static boolean usePerms = true;
    private static double minBounty = 20.0;
    private static int listSize = -1;
    private static boolean godfatherMode = false;
    private static boolean gui_enabled = false;
    private static String gui_title = "&4&lSell Heads";
    private static int gui_size = 54;
    private static String gui_totalValue = "&eTotal Sell Price:&a $VALUE";
    private static String gui_sellMessage = "&6HUNTER sold AMOUNT head(s) for $VALUE!";
    private static boolean gui_sounds = false;
    private static boolean gui_bountyList = true;
    private static String gui_bountyListTitle = "&4&lBounty List";
    private static String gui_icon_sellTitle = "&a&lSell";
    private static String gui_icon_confirmTitle = "&a&lConfirm";
    private static String gui_icon_confirmDesc = "&eSell these heads?";
    private static String gui_icon_cancelTitle = "&c&lCancel";
    private static String gui_icon_cancelDesc = "&eGo back to head list?";
    private static String gui_icon_closeTitle = "&c&lClose";
    private static String gui_icon_closeDesc = "&eExit this menu?";
    private static double drop_rate = 100.0;
    private static boolean drop_withBalance = true;
    private static boolean drop_withBounty = true;
    private static boolean drop_fireTick = false;
    private static boolean drop_anyCause = false;
    private static int drop_lootingLevel = 0;
    private static boolean ench_enabled = false;
    private static double ench_chance = 10.0;
    private static int ench_minLevels = 20;
    private static int ench_maxLevels = 30;
    private static int ench_maxOthers = 2;
    private static boolean ench_allowBows = true;
    private static boolean ench_allowTools = false;
    private static boolean ench_allowBooks = false;
    private static boolean msg_sellNotify = true;
    private static boolean msg_sellPublic = true;
    private static boolean msg_bountyNotify = true;
    private static boolean msg_bountyPublic = true;
    private static boolean vp_balance = true;
    private static boolean vp_bounty = true;
    private static boolean vp_cumulative = false;
    private static String fmt_sign_top = "---------------";
    private static String fmt_sign_title = "&4&l[SellHead]";
    private static String fmt_sign_value = "VALUE";
    private static String fmt_sign_bottom = "---------------";
    private static String fmt_skullValue = "&eSell Price:&a $VALUE";
    private static String fmt_skullWorthless = "&eSell Price: &cWorthless";
    private static String fmt_sellNotify = "&6HUNTER sold VICTIM's head for $VALUE!";
    private static String fmt_sellWorthless = "&cThis skull is worthless! It has been removed from your inventory.";
    private static String fmt_placeBounty = "&6Player &eHUNTER &6has added&e $VALUE &6to &eVICTIM&6's bounty!";
    private static String fmt_removeBounty = "&6Player &eHUNTER &6has removed&e $VALUE &6from &eVICTIM&6's bounty!";
    private static String fmt_totalBounty = "&6Total Bounty on &eVICTIM&6:&e $VALUE";
    private static String fmt_personalBounty = "&6Your Bounty on &eVICTIM&6:&e $VALUE";
    private static boolean wrld_ignoreWorlds = false;
    private static boolean ps_factionsEnabledWilderness = true;
    private static boolean ps_factionsEnabledWarzone = false;
    private static boolean ps_factionsEnabledSafezone = false;
    private static boolean ps_minigamesEnabled = false;

    public static void refresh(Main plugin) {
        FileConfiguration config = plugin.getConfig();
        hoardMode = config.getBoolean("options.hoard-mode");
        config.set("options.hoard-mode", (Object)hoardMode);
        sellRate = config.getDouble("options.sell-rate");
        config.set("options.sell-rate", (Object)sellRate);
        usePercent = config.getBoolean("options.use-percentage");
        config.set("options.use-percentage", (Object)usePercent);
        usePerms = config.getBoolean("options.use-permissions");
        config.set("options.use-permissions", (Object)usePerms);
        listSize = config.getInt("options.bounty-list-size");
        config.set("options.bounty-list-size", (Object)listSize);
        minBounty = config.getDouble("options.minimum-bounty");
        config.set("options.minimum-bounty", (Object)minBounty);
        godfatherMode = config.getBoolean("options.godfather-mode");
        config.set("options.godfather-mode", (Object)godfatherMode);
        gui_enabled = config.getBoolean("options.gui.enabled");
        config.set("options.gui.enabled", (Object)gui_enabled);
        gui_title = config.getString("options.gui.title");
        config.set("options.gui.title", (Object)gui_title);
        gui_size = config.getInt("options.gui.size");
        config.set("options.gui.size", (Object)gui_size);
        gui_totalValue = config.getString("options.gui.total-value");
        config.set("options.gui.total-value", (Object)gui_totalValue);
        gui_sellMessage = config.getString("options.gui.sell-message");
        config.set("options.gui.sell-message", (Object)gui_sellMessage);
        gui_sounds = config.getBoolean("options.gui.sounds");
        config.set("options.gui.sounds", (Object)gui_sounds);
        gui_bountyList = config.getBoolean("options.gui.bounty-list");
        config.set("options.gui.bounty-list", (Object)gui_bountyList);
        gui_bountyListTitle = config.getString("options.gui.bounty-list-title");
        config.set("options.gui.bounty-list-title", (Object)gui_bountyListTitle);
        gui_icon_sellTitle = config.getString("options.gui.icon.sell-title");
        config.set("options.gui.icon.sell-title", (Object)gui_icon_sellTitle);
        gui_icon_confirmTitle = config.getString("options.gui.icon.confirm-title");
        config.set("options.gui.icon.confirm-title", (Object)gui_icon_confirmTitle);
        gui_icon_confirmDesc = config.getString("options.gui.icon.confirm-desc");
        config.set("options.gui.icon.confirm-desc", (Object)gui_icon_confirmDesc);
        gui_icon_cancelTitle = config.getString("options.gui.icon.cancel-title");
        config.set("options.gui.icon.cancel-title", (Object)gui_icon_cancelTitle);
        gui_icon_cancelDesc = config.getString("options.gui.icon.cancel-desc");
        config.set("options.gui.icon.cancel-desc", (Object)gui_icon_cancelDesc);
        gui_icon_closeTitle = config.getString("options.gui.icon.close-title");
        config.set("options.gui.icon.close-title", (Object)gui_icon_closeTitle);
        gui_icon_closeDesc = config.getString("options.gui.icon.close-desc");
        config.set("options.gui.icon.close-desc", (Object)gui_icon_closeDesc);
        drop_rate = config.getDouble("options.drop.rate");
        config.set("options.drop.rate", (Object)drop_rate);
        drop_withBalance = config.getBoolean("options.drop.with-balance");
        config.set("options.drop.with-balance", (Object)drop_withBalance);
        drop_withBounty = config.getBoolean("options.drop.with-bounty");
        config.set("options.drop.with-bounty", (Object)drop_withBounty);
        drop_fireTick = config.getBoolean("options.drop.fire-tick");
        config.set("options.drop.fire-tick", (Object)drop_fireTick);
        drop_anyCause = config.getBoolean("options.drop.any-cause");
        config.set("options.drop.any-cause", (Object)drop_anyCause);
        drop_lootingLevel = config.getInt("options.drop.looting-level");
        config.set("options.drop.looting-level", (Object)drop_lootingLevel);
        ench_enabled = config.getBoolean("options.enchantment.enabled");
        config.set("options.enchantment.enabled", (Object)ench_enabled);
        ench_chance = config.getDouble("options.enchantment.chance");
        config.set("options.enchantment.chance", (Object)ench_chance);
        ench_minLevels = config.getInt("options.enchantment.min-levels");
        config.set("options.enchantment.min-levels", (Object)ench_minLevels);
        ench_maxLevels = config.getInt("options.enchantment.max-levels");
        config.set("options.enchantment.max-levels", (Object)ench_maxLevels);
        ench_maxOthers = config.getInt("options.enchantment.max-other-enchantments");
        config.set("options.enchantment.max-other-enchantments", (Object)ench_maxOthers);
        ench_allowBows = config.getBoolean("options.enchantment.allowed-on-bows");
        config.set("options.enchantment.allowed-on-bows", (Object)ench_allowBows);
        ench_allowTools = config.getBoolean("options.enchantment.allowed-on-tools");
        config.set("options.enchantment.allowed-on-tools", (Object)ench_allowTools);
        ench_allowBooks = config.getBoolean("options.enchantment.allowed-on-books");
        config.set("options.enchantment.allowed-on-books", (Object)ench_allowBooks);
        msg_sellNotify = config.getBoolean("options.message.sell-notify");
        config.set("options.message.sell-notify", (Object)msg_sellNotify);
        msg_sellPublic = config.getBoolean("options.message.sell-public");
        config.set("options.message.sell-public", (Object)msg_sellPublic);
        msg_bountyNotify = config.getBoolean("options.message.bounty-notify");
        config.set("options.message.bounty-notify", (Object)msg_bountyNotify);
        msg_bountyPublic = config.getBoolean("options.message.bounty-public");
        config.set("options.message.bounty-public", (Object)msg_bountyPublic);
        vp_balance = config.getBoolean("options.value-placement.balance");
        config.set("options.value-placement.balance", (Object)vp_balance);
        vp_bounty = config.getBoolean("options.value-placement.bounty");
        config.set("options.value-placement.bounty", (Object)vp_bounty);
        vp_cumulative = config.getBoolean("options.value-placement.cumulative");
        config.set("options.value-placement.cumulative", (Object)vp_cumulative);
        fmt_sign_top = config.getString("options.format.sign.top");
        config.set("options.format.sign.top", (Object)fmt_sign_top);
        fmt_sign_title = config.getString("options.format.sign.title");
        config.set("options.format.sign.title", (Object)fmt_sign_title);
        fmt_sign_value = config.getString("options.format.sign.value");
        config.set("options.format.sign.value", (Object)fmt_sign_value);
        fmt_sign_bottom = config.getString("options.format.sign.bottom");
        config.set("options.format.sign.bottom", (Object)fmt_sign_bottom);
        fmt_skullValue = config.getString("options.format.skull-value");
        config.set("options.format.skull-value", (Object)fmt_skullValue);
        fmt_skullWorthless = config.getString("options.format.skull-worthless");
        config.set("options.format.skull-worthless", (Object)fmt_skullWorthless);
        fmt_sellNotify = config.getString("options.format.sell-notify");
        config.set("options.format.sell-notify", (Object)fmt_sellNotify);
        fmt_sellWorthless = config.getString("options.format.sell-worthless");
        config.set("options.format.sell-worthless", (Object)fmt_sellWorthless);
        fmt_placeBounty = config.getString("options.format.place-bounty");
        config.set("options.format.place-bounty", (Object)fmt_placeBounty);
        fmt_removeBounty = config.getString("options.format.remove-bounty");
        config.set("options.format.remove-bounty", (Object)fmt_removeBounty);
        fmt_totalBounty = config.getString("options.format.total-bounty");
        config.set("options.format.total-bounty", (Object)fmt_totalBounty);
        fmt_personalBounty = config.getString("options.format.personal-bounty");
        config.set("options.format.personal-bounty", (Object)fmt_personalBounty);
        wrld_ignoreWorlds = config.getBoolean("worlds.ignore-worlds");
        config.set("worlds.ignore-worlds", (Object)wrld_ignoreWorlds);
        ps_factionsEnabledWilderness = config.getBoolean("plugin-support.factions.enabled.wilderness");
        config.set("plugin-support.factions.enabled.wilderness", (Object)ps_factionsEnabledWilderness);
        ps_factionsEnabledWarzone = config.getBoolean("plugin-support.factions.enabled.warzone");
        config.set("plugin-support.factions.enabled.warzone", (Object)ps_factionsEnabledWarzone);
        ps_factionsEnabledSafezone = config.getBoolean("plugin-support.factions.enabled.safezone");
        config.set("plugin-support.factions.enabled.safezone", (Object)ps_factionsEnabledSafezone);
        ps_minigamesEnabled = config.getBoolean("plugin-support.minigames.enabled");
        config.set("plugin-support.minigames.enabled", (Object)ps_minigamesEnabled);
        plugin.saveConfig();
    }

    public static boolean isHoardMode() {
        return hoardMode;
    }

    public static double getSellRate() {
        return sellRate;
    }

    public static boolean isUsePercent() {
        return usePercent;
    }

    public static boolean isUsePerms() {
        return usePerms;
    }

    public static double getMinBounty() {
        return minBounty;
    }

    public static int getListSize() {
        return listSize;
    }

    public static boolean isGodfatherMode() {
        return godfatherMode;
    }

    public static boolean isGui_enabled() {
        return gui_enabled;
    }

    public static String getGui_title() {
        return gui_title;
    }

    public static int getGui_size() {
        return gui_size;
    }

    public static String getGui_totalValue() {
        return gui_totalValue;
    }

    public static String getGui_sellMessage() {
        return gui_sellMessage;
    }

    public static boolean isGui_sounds() {
        return gui_sounds;
    }

    public static boolean isGui_bountyList() {
        return gui_bountyList;
    }

    public static String getGui_bountyListTitle() {
        return gui_bountyListTitle;
    }

    public static String getGui_icon_sellTitle() {
        return gui_icon_sellTitle;
    }

    public static String getGui_icon_confirmTitle() {
        return gui_icon_confirmTitle;
    }

    public static String getGui_icon_confirmDesc() {
        return gui_icon_confirmDesc;
    }

    public static String getGui_icon_cancelTitle() {
        return gui_icon_cancelTitle;
    }

    public static String getGui_icon_cancelDesc() {
        return gui_icon_cancelDesc;
    }

    public static String getGui_icon_closeTitle() {
        return gui_icon_closeTitle;
    }

    public static String getGui_icon_closeDesc() {
        return gui_icon_closeDesc;
    }

    public static double getDrop_rate() {
        return drop_rate;
    }

    public static boolean isDrop_withBalance() {
        return drop_withBalance;
    }

    public static boolean isDrop_withBounty() {
        return drop_withBounty;
    }

    public static boolean isDrop_fireTick() {
        return drop_fireTick;
    }

    public static boolean isDrop_anyCause() {
        return drop_anyCause;
    }

    public static int getDrop_lootingLevel() {
        return drop_lootingLevel;
    }

    public static boolean isEnch_enabled() {
        return ench_enabled;
    }

    public static double getEnch_chance() {
        return ench_chance;
    }

    public static int getEnch_minLevels() {
        return ench_minLevels;
    }

    public static int getEnch_maxLevels() {
        return ench_maxLevels;
    }

    public static int getEnch_maxOthers() {
        return ench_maxOthers;
    }

    public static boolean isEnch_allowBows() {
        return ench_allowBows;
    }

    public static boolean isEnch_allowTools() {
        return ench_allowTools;
    }

    public static boolean isEnch_allowBooks() {
        return ench_allowBooks;
    }

    public static boolean isMsg_sellNotify() {
        return msg_sellNotify;
    }

    public static boolean isMsg_sellPublic() {
        return msg_sellPublic;
    }

    public static boolean isMsg_bountyNotify() {
        return msg_bountyNotify;
    }

    public static boolean isMsg_bountyPublic() {
        return msg_bountyPublic;
    }

    public static boolean isVp_balance() {
        return vp_balance;
    }

    public static boolean isVp_bounty() {
        return vp_bounty;
    }

    public static boolean isVp_cumulative() {
        return vp_cumulative;
    }

    public static String getFmt_sign_top() {
        return fmt_sign_top;
    }

    public static String getFmt_sign_title() {
        return fmt_sign_title;
    }

    public static String getFmt_sign_value() {
        return fmt_sign_value;
    }

    public static String getFmt_sign_bottom() {
        return fmt_sign_bottom;
    }

    public static String getFmt_skullValue() {
        return fmt_skullValue;
    }

    public static String getFmt_skullWorthless() {
        return fmt_skullWorthless;
    }

    public static String getFmt_sellNotify() {
        return fmt_sellNotify;
    }

    public static String getFmt_sellWorthless() {
        return fmt_sellWorthless;
    }

    public static String getFmt_placeBounty() {
        return fmt_placeBounty;
    }

    public static String getFmt_removeBounty() {
        return fmt_removeBounty;
    }

    public static String getFmt_totalBounty() {
        return fmt_totalBounty;
    }

    public static String getFmt_personalBounty() {
        return fmt_personalBounty;
    }

    public static boolean isWrld_ignoreWorlds() {
        return wrld_ignoreWorlds;
    }

    public static boolean isPs_factionsEnabledWilderness() {
        return ps_factionsEnabledWilderness;
    }

    public static boolean isPs_factionsEnabledWarzone() {
        return ps_factionsEnabledWarzone;
    }

    public static boolean isPs_factionsEnabledSafezone() {
        return ps_factionsEnabledSafezone;
    }

    public static boolean isPs_minigamesEnabled() {
        return ps_minigamesEnabled;
    }
}

