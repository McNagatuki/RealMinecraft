package com.github.mc_nagatuki.realminecraft;

import org.bukkit.Location;
import java.util.Objects;

public class BlockPosition {
    public final int x;
    public final int z;

    public BlockPosition(int x, int y) {
        this.x = x;
        this.z = y;
    }

    public static BlockPosition fromLocation(Location location){
        return new BlockPosition(location.getBlockX(), location.getBlockZ());
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
