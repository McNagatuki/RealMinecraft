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
        // プラグインがオフなら何もしない
        if (!RealMinecraft.plugin.getRealConfig().isActivated()) return;

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
        if(loc == null) return;
        int x = loc.getBlockX();
        int z = loc.getBlockZ();

        // 当該座標に地雷がなければ何もしない
        if (!RealMinecraft.plugin.getMineManager().hasMine(x, z)) return;

        // 爆発処理
        RealMinecraft.plugin.getPlayerExploder().explode(loc, player, RealMinecraft.plugin.getRealConfig().getPower(), RealMinecraft.plugin.getRealConfig().getDamage());

        // 地雷除去（爆発しても地雷がなくならないようにするならここを変更）
        RealMinecraft.plugin.getMineManager().demine(x, z);

        RealMinecraft.plugin.getServer().broadcastMessage(ChatColor.BLUE + e.getPlayer().getName() + "は地雷を踏み抜いた");
    }
}
