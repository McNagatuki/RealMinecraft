package com.github.mc_nagatuki.realminecraft;

import org.bukkit.Material;

public class Items {
    public static class ItemType {
        public final Material material;
        public final String id;
        public final String name;
        public final String color;

        public ItemType(Material material, String id, String name, String color) {
            this.material = material;
            this.id = id;
            this.name = name;
            this.color = color;
        }
    }

    public static final ItemType Detector = new ItemType(Material.BLAZE_ROD, "minecraft:blaze_rod", "地雷探知機", "green");
    public static final ItemType Installer = new ItemType(Material.BOWL, "minecraft:bowl", "ほんものの地雷", "red");
    public static final ItemType Sweeper = new ItemType(Material.WHEAT, "minecraft:wheat", "マインスイーパー", "yellow");
}
