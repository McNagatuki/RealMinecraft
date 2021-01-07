package com.github.mcnagatuki.realminecraft.commands;

import com.github.mcnagatuki.realminecraft.RealMinecraft;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.List;

public class CmdSweepAll extends CommandAbstract {
    private String cmdStr = "sweepall";

    public boolean executeCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase(this.cmdStr)) {
            RealMinecraft.plugin.getMineManager().demineAll();
            sender.sendMessage("[RealMinecraft] All mines were swept.");
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
