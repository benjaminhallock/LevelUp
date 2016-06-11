/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  org.bukkit.configuration.Configuration
 *  org.bukkit.configuration.ConfigurationSection
 *  org.bukkit.configuration.file.FileConfiguration
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.plugin.Plugin
 */
package com.moosecanoes.levelup.util.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public final class ConfigAccessor {
    private final String fileName;
    private final Plugin plugin;
    private File configFile;
    private FileConfiguration fileConfiguration;

    public ConfigAccessor(Plugin plugin, String fileName) {
        this(plugin, fileName, "");
    }

    public ConfigAccessor(Plugin plugin, String fileName, String newDir) {
        if (plugin == null) {
            throw new IllegalArgumentException("plugin cannot be null");
        }
        if (!plugin.isEnabled()) {
            throw new IllegalArgumentException("plugin must be initialized");
        }
        this.plugin = plugin;
        this.fileName = fileName;
        File dataFolder = plugin.getDataFolder();
        if (dataFolder == null) {
            throw new IllegalStateException();
        }
        String string = newDir = newDir.equals("") ? newDir : File.separator + newDir;
        if (!newDir.equals("")) {
            File dir = new File(plugin.getDataFolder() + newDir);
            dir.mkdirs();
        }
        this.configFile = new File(plugin.getDataFolder() + newDir, fileName);
    }

    public void reloadConfig() {
        this.fileConfiguration = YamlConfiguration.loadConfiguration((File)this.configFile);
        InputStream defConfigStream = this.plugin.getResource(this.fileName);
        if (defConfigStream != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration((File)this.configFile);
            this.fileConfiguration.setDefaults((Configuration)defConfig);
        }
    }

    public FileConfiguration getConfig() {
        if (this.fileConfiguration == null) {
            this.reloadConfig();
        }
        return this.fileConfiguration;
    }

    public void saveConfig() {
        if (this.fileConfiguration == null || this.configFile == null) {
            return;
        }
        try {
            this.getConfig().save(this.configFile);
        }
        catch (IOException e) {
            this.plugin.getLogger().log(Level.SEVERE, "Could not save config to " + this.configFile, e);
        }
    }

    public void saveDefaultConfig() {
        if (!this.configFile.exists()) {
            this.plugin.saveResource(this.fileName, false);
        }
    }

    public void resetConfig() {
        if (this.configFile.delete()) {
            this.saveDefaultConfig();
        }
    }

    public boolean contains(String path) {
        return this.getConfig().contains(path);
    }

    public ConfigurationSection getSection(String path) {
        return this.getConfig().getConfigurationSection(path);
    }

    public ItemStack getItemStack(String path) {
        return this.getConfig().getItemStack(path);
    }

    public String getString(String path) {
        return this.getConfig().getString(path);
    }

    public int getInt(String path) {
        return this.getConfig().getInt(path);
    }

    public void set(String path, Object value) {
        this.getConfig().set(path, value);
    }

    public Set<String> getKeys(boolean deep) {
        return this.getConfig().getKeys(deep);
    }
}

