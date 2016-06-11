/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.OfflinePlayer
 *  org.bukkit.Sound
 *  org.bukkit.World
 *  org.bukkit.block.Block
 *  org.bukkit.block.BlockState
 *  org.bukkit.block.Sign
 *  org.bukkit.command.CommandSender
 *  org.bukkit.enchantments.EnchantmentTarget
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 *  org.bukkit.permissions.PermissionAttachmentInfo
 */
package com.moosecanoes.levelup.util;

import com.moosecanoes.levelup.util.config.Settings;
import com.moosecanoes.levelup.util.pairing.PairState;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.PermissionAttachmentInfo;

public final class Utils {
    public static final String[] CONFIGS = new String[]{"messages.yml", "mobhunter.yml", "offers.yml", "signs.yml", "skulls.yml", "whitelist.yml"};
    private static final DecimalFormat MONEY = new DecimalFormat("0.00");

    public static String color(String s) {
        s = s.replaceAll("&([a-zA-Z0-9])", "\u00a7$1");
        return s;
    }

    public static String color(String s, String codeRegex) {
        s = s.replaceAll(codeRegex + "([a-zA-Z0-9])", "\u00a7$1");
        return s;
    }

    public static OfflinePlayer getPlayerFromString(String s) {
        if (Bukkit.getPlayer((String)s) != null) {
            return Bukkit.getPlayer((String)s);
        }
        if (Bukkit.getPlayerExact((String)s) != null) {
            return Bukkit.getPlayerExact((String)s);
        }
        return Bukkit.getOfflinePlayer((String)s);
    }

    public static boolean hasPlayedBefore(OfflinePlayer player) {
        for (OfflinePlayer p : Bukkit.getOfflinePlayers()) {
            if (!p.getUniqueId().equals(player.getUniqueId())) continue;
            return true;
        }
        for (Player p2 : Bukkit.getOnlinePlayers()) {
            if (!p2.getUniqueId().equals(player.getUniqueId())) continue;
            return true;
        }
        return false;
    }

    public static /* varargs */ boolean perms(CommandSender cs, String ... perms) {
        if (!Settings.isUsePerms()) {
            return true;
        }
        if (cs.hasPermission("hunter.admin")) {
            return true;
        }
        for (String s : perms) {
            if (!cs.hasPermission(s)) continue;
            return true;
        }
        return false;
    }

    public static boolean isNumeric(String s) {
        return s.matches("[0-9]+") || s.matches("[0-9]*[.][0-9]+") || s.matches("[0-9]+[.][0-9]*");
    }

    public static Sound getGUINope() {
        try {
            return Sound.valueOf((String)"NOTE_SNARE_DRUM");
        }
        catch (Exception e) {
            return Sound.valueOf((String)"BLOCK_NOTE_SNARE");
        }
    }

    public static Sound getGUIDing() {
        try {
            return Sound.valueOf((String)"NOTE_PIANO");
        }
        catch (Exception e) {
            return Sound.valueOf((String)"BLOCK_NOTE_HARP");
        }
    }

    public static Sound getGUIDingaling() {
        try {
            return Sound.valueOf((String)"LEVEL_UP");
        }
        catch (Exception e) {
            return Sound.valueOf((String)"ENTITY_PLAYER_LEVELUP");
        }
    }

    public static String money(double n) {
        return MONEY.format(n);
    }

    public static String f(String x, String victim, double value) {
        String s = x.replace("VICTIM", victim);
        s = s.replace("VALUE", Utils.money(value));
        return Utils.color(s);
    }

    public static String f(String x, String hunter, String victim, double value) {
        String s = x.replace("HUNTER", hunter);
        s = s.replace("VICTIM", victim);
        s = s.replace("VALUE", Utils.money(value));
        return Utils.color(s);
    }

    public static String f(String x, String hunter, double value, int amount) {
        String s = x.replace("HUNTER", hunter);
        s = s.replace("VALUE", Utils.money(value));
        s = s.replace("AMOUNT", "" + amount + "");
        return Utils.color(s);
    }

    public static String f(String x, String hunter, String victim, double value, int amount) {
        String s = x.replace("HUNTER", hunter);
        s = s.replace("VICTIM", victim);
        s = s.replace("VALUE", Utils.money(value));
        s = s.replace("AMOUNT", "" + amount + "");
        return Utils.color(s);
    }

    public static boolean luckDrop(double dropRate) {
        Random random = new Random();
        double x = random.nextInt(10000);
        return (x /= 100.0) < dropRate;
    }

    public static double getValue(ItemStack skull) {
        String loreString = (String)skull.getItemMeta().getLore().get(0);
        loreString = Utils.removeLoreFormat(loreString);
        double skullWorth = 0.0;
        if (!loreString.isEmpty()) {
            skullWorth = Double.parseDouble(loreString);
        }
        return skullWorth;
    }

    public static String removeLoreFormat(String s) {
        String crap = s.replaceAll("[0-9]*[,.]?[0-9]*", "");
        String notCrap = s.replaceAll("[" + crap + "]", "");
        while (notCrap.length() > 0 && !Character.isDigit(notCrap.charAt(0))) {
            notCrap = notCrap.substring(1);
        }
        while (notCrap.length() > 0 && !Character.isDigit(notCrap.charAt(notCrap.length() - 1))) {
            notCrap = notCrap.substring(0, notCrap.length() - 1);
        }
        return notCrap.replaceAll(",", ".");
    }

    public static boolean dropWith(PairState skullState) {
        boolean dropWithBalance = Settings.isDrop_withBalance();
        boolean dropWithBounty = Settings.isDrop_withBounty();
        if (dropWithBalance) {
            if (dropWithBounty) {
                return skullState != null && skullState != PairState.NEITHER;
            }
            return skullState == PairState.BALANCE;
        }
        if (dropWithBounty) {
            return skullState == PairState.BOUNTY;
        }
        return skullState == PairState.NEITHER;
    }

    public static String parseLocation(Location loc) {
        String tag = "";
        tag = tag + loc.getWorld().getName() + "%";
        tag = tag + loc.getX() + "%";
        tag = tag + loc.getY() + "%";
        tag = tag + loc.getZ();
        tag = tag.replaceAll("(\\d+)\\.(\\d+)", "$1,$2");
        return tag;
    }

    public static Location buildLocation(String tag) {
        String[] arr = tag.split("%", 4);
        arr[0] = arr[0].replaceAll(",", ".");
        arr[1] = arr[1].replaceAll(",", ".");
        arr[2] = arr[2].replaceAll(",", ".");
        arr[3] = arr[3].replaceAll(",", ".");
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        if (Utils.isNumeric(arr[1])) {
            x = Double.parseDouble(arr[1]);
        }
        if (Utils.isNumeric(arr[2])) {
            y = Double.parseDouble(arr[2]);
        }
        if (Utils.isNumeric(arr[2])) {
            z = Double.parseDouble(arr[2]);
        }
        return new Location(Bukkit.getWorld((String)arr[0]), x, y, z);
    }

    public static double getSellRate(Player p) {
        double sellRate = Settings.getSellRate();
        if (p != null) {
            for (PermissionAttachmentInfo perm : p.getEffectivePermissions()) {
                String num;
                if (!perm.getPermission().startsWith("hunter.sellrate.") || !Utils.isNumeric(num = perm.getPermission().replace("hunter.sellrate.", ""))) continue;
                sellRate = Double.parseDouble(num);
            }
        }
        return sellRate;
    }

    public static void updateSignAt(Player p, Location loc) {
        if (loc.getBlock().getState() instanceof Sign) {
            String top = Settings.getFmt_sign_top();
            String title = Settings.getFmt_sign_title();
            String value = Settings.getFmt_sign_value();
            String bottom = Settings.getFmt_sign_bottom();
            String rate = "" + Utils.getSellRate(p) + "";
            value = Settings.isUsePercent() ? value + "%" : "$" + value;
            top = Utils.color(top.replace("VALUE", rate));
            title = Utils.color(title.replace("VALUE", rate));
            value = Utils.color(value.replace("VALUE", rate));
            bottom = Utils.color(bottom.replace("VALUE", rate));
            p.sendSignChange(loc, new String[]{top, title, value, bottom});
        }
    }

    public static boolean testEnchantment(ItemStack item) {
        return item != null && (EnchantmentTarget.WEAPON.includes(item) || Settings.isEnch_allowBows() && EnchantmentTarget.BOW.includes(item) || Settings.isEnch_allowTools() && EnchantmentTarget.TOOL.includes(item) || Settings.isEnch_allowBooks() && item.getType() == Material.BOOK);
    }
}

