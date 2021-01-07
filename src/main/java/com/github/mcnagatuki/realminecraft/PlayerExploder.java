package com.github.mcnagatuki.realminecraft;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class PlayerExploder {
    public static void explode(Location l, Player p, int power, double damage) {
        World world = l.getWorld();
        if (world == null) return;

        world.createExplosion(l, power, false, false);
    }
}
