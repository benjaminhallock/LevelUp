/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  org.bukkit.inventory.ItemStack
 */
package com.moosecanoes.levelup.util.pairing;

import com.moosecanoes.levelup.util.pairing.PairState;
import java.util.UUID;
import org.bukkit.inventory.ItemStack;

public final class PairedSkull {
    private final ItemStack skull;
    private final double ecoLoss;
    private final PairState state;
    private final UUID godfather;

    public PairedSkull(ItemStack skull, double ecoLoss, PairState state, UUID godfather) {
        this.skull = skull;
        this.ecoLoss = ecoLoss;
        this.state = state;
        this.godfather = godfather;
    }

    public ItemStack getSkull() {
        return this.skull;
    }

    public double getEcoLoss() {
        return this.ecoLoss;
    }

    public PairState getState() {
        return this.state;
    }

    public UUID getGodfather() {
        return this.godfather;
    }
}

