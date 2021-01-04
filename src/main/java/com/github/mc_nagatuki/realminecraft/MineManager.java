package com.github.mc_nagatuki.realminecraft;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// 爆弾の管理
// NOTE: ワールド間で情報を分けていないので、オーバーワールドとネザーの同じ座標で爆発する
public class MineManager {
    private final Set<BlockPosition> mines = new HashSet<>();

    // 自動設置
    public void layAutomatically(BlockPosition pos1, BlockPosition pos2, double probability) {
        int x1 = Math.min(pos1.x, pos2.x);
        int x2 = Math.max(pos1.x, pos2.x);
        int z1 = Math.min(pos1.z, pos2.z);
        int z2 = Math.max(pos1.z, pos2.z);

        Random rd = new Random();
        for (int x = x1; x <= x2; ++x) {
            for (int z = z1; z <= z2; ++z) {
                double rdVal = rd.nextDouble();
                if (rdVal < probability) {
                    this.lay(new BlockPosition(x, z));
                }
            }
        }

        /*
        IntStream.rangeClosed(x1, x2)
                .mapToObj(x -> IntStream.rangeClosed(z1, z2)
                        .mapToObj(z -> new BlockPosition(x, z))
                )
                .flatMap(e -> e)
                .filter(e -> rd.nextDouble() < probability)
                .forEach(this::lay);
        */
    }

    // 手動設置
    public void lay(BlockPosition pos) {
        this.mines.add(pos);
    }

    // 手動解除
    public void demine(BlockPosition pos) {
        this.mines.remove(pos);
    }

    // 全解除
    public void demineAll() {
        this.mines.clear();
    }

    // 爆弾の有無
    public boolean hasMine(BlockPosition pos) {
        return this.mines.contains(pos);
    }
}