package com.github.mc_nagatuki.realminecraft;

import org.bukkit.Material;

public class Items {
    public static class Detector{
        public static final Material material = Material.BLAZE_ROD;
        public static final String id = "minecraft:blaze_rod";
        public static final String name = "地雷探知機";
        public static final String color = "green";
    }

    public static class Installer{
        public static final Material material = Material.BOWL;
        public static final String id = "minecraft:bowl";
        public static final String name = "ほんものの地雷";
        public static final String color = "red";
    }

    public static class Sweeper{
        public static final Material material = Material.WHEAT;
        public static final String id = "minecraft:wheat";
        public static final String name = "マインスイーパー";
        public static final String color = "yellow";
    }
}
