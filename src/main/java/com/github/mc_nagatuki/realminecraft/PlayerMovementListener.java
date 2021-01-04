package com.github.mc_nagatuki.realminecraft;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMovementListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onPlayerMoveEvent(PlayerMoveEvent e) {
        MineConfiguration config = RealMinecraft.plugin.getMineConfig();

        // プラグインがオフなら何もしない
        if (!config.isActivated()) return;

        // プレイヤーを取得
        Player player = e.getPlayer();

        // プレイヤーがクリエイティブかスペクテイターならなにもしない
        if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR) return;

        // プレイヤーが浮いていたら何もしない
        // ただし乗り物に乗っている場合を除く
        // 厳密にやるならy座標を見た方がいいらしい
        if (!(player.isOnGround() || player.isInsideVehicle())) return;

        //移動先の座標を得る
        Location loc = e.getTo();
        if (loc == null) return;
        BlockPosition pos = BlockPosition.fromLocation(loc);

        // 当該座標に地雷がなければ何もしない
        if (!RealMinecraft.plugin.getMineManager().hasMine(pos)) return;

        // 爆発処理
        PlayerExploder.explode(loc, player, config.getPower(), config.getDamage());

        // 地雷除去（爆発しても地雷がなくならないようにするならここを変更）
        RealMinecraft.plugin.getMineManager().demine(pos);

        RealMinecraft.plugin.getServer().broadcastMessage(ChatColor.BLUE + e.getPlayer().getName() + "は地雷を踏み抜いた");
    }
}
