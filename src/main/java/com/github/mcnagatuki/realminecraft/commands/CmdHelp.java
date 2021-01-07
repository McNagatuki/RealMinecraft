package com.github.mcnagatuki.realminecraft.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class CmdHelp extends CommandAbstract {
    private String cmdStr = "help";

    final static String[] HELP_MESSAGE = {
            "----------------[" + ChatColor.BLUE + "This is \"Real\" Minecraft!" + ChatColor.RESET + "]----------------",
            "/real help: ヘルプ表示",
            "/real < on | off >: プラグインを有効化/無効化",
            "/real set < pos1 | pos2 > x, z : ランダム設置の始点/終点を設定",
            "/real set power: 爆発の大きさの設定",
//            "/real set damage: 与ダメージ量の設定",
            "/real set probability: ランダム設置の頻度",
            "/real autolay: pos1とpos2で指定した範囲に地雷を自動設置",
            "/real autolay x1, z1, x2, z2: 範囲を指定して地雷を自動設置",
            "/real sweepall: 設置した地雷を全撤去する",
            "-----------------------------------------------------",
    };

    public boolean executeCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase(this.cmdStr)) {
            Stream.of(HELP_MESSAGE).forEach(sender::sendMessage);
            return true;
        }

        return false;
    }

    public List<String> tabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1 && this.cmdStr.startsWith(args[0])) {
            return Collections.singletonList(this.cmdStr);
        }

        return null;
    }
}
