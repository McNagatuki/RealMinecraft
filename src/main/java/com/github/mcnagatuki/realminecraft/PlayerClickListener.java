package com.github.mcnagatuki.realminecraft;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerClickListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onItemClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();

        // 右クリックしてなかったら無視する
        if (a != Action.RIGHT_CLICK_BLOCK) return;
        // アイテムを持っていなかったら無視する
        if (e.getItem() == null) return;

        ItemStack item = e.getItem();
        Material type = item.getType();
        ItemMeta im = item.getItemMeta();
        if (im == null) return;

        Block block = e.getClickedBlock();
        if (block == null) return;

        BlockPosition pos = BlockPosition.fromBlock(block);

        MineManager manager = RealMinecraft.plugin.getMineManager();

        // Detector
        if (type == Items.Detector.material && im.getDisplayName().endsWith(Items.Detector.name)) {
            if (manager.hasMine(pos)) {
                p.sendMessage(ChatColor.RED + "地雷が埋まっています");
            } else {
                p.sendMessage(ChatColor.GREEN + "地雷は見つかりませんでした");
            }
        }

        // Installer
        if (type == Items.Installer.material && im.getDisplayName().endsWith(Items.Installer.name)) {
            GameMode gm = p.getGameMode();
            if (gm == GameMode.SURVIVAL || gm == GameMode.ADVENTURE) {
                // アイテムを一個減らす
                int num = item.getAmount();
                if (num > 0) --num;
                item.setAmount(num);
            }

            manager.lay(pos);
            p.sendMessage("地雷を設置しました");
        }

        // Sweeper
        if (type == Items.Sweeper.material && im.getDisplayName().endsWith(Items.Sweeper.name)) {
            if (manager.hasMine(pos)) {
                manager.demine(pos);
            } else {
                manager.lay(pos);
            }
            p.sendMessage("地雷を除去しました");
        }
    }
}
