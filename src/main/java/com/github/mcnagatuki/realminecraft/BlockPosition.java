package com.github.mcnagatuki.realminecraft;

import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.Objects;

public class BlockPosition {
    public final int x;
    public final int z;

    public BlockPosition(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public static BlockPosition fromLocation(Location location) {
        return new BlockPosition(location.getBlockX(), location.getBlockZ());
    }

    public static BlockPosition fromBlock(Block block) {
        return new BlockPosition(block.getX(), block.getZ());
    }

    @Override
    public String toString() {
        return "(" + x + ", " + z + ")";
    }

    // 「生成/equals()およびhasCode()」から比較を行うのに適当な関数群を生成する
    // hashCodeはequalsの前の簡易的な比較としても使える
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlockPosition that = (BlockPosition) o;
        return x == that.x &&
                z == that.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, z);
    }
}
