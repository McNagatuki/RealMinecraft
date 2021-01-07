package com.github.mcnagatuki.realminecraft;

import com.github.mcnagatuki.realminecraft.commands.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class CommandManager implements CommandExecutor, TabCompleter {
    private CommandAbstract[] commands;

    public CommandManager() {
        this.commands = new CommandAbstract[]{
                new CmdOn(),
                new CmdOff(),
                new CmdHelp(),
                new CmdSet(),
                new CmdAutoLay(),
                new CmdSweepAll(),
                new CmdGive(),
        };
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (args.length == 0) return false;

        for (CommandAbstract e : this.commands) {
            boolean ret = e.executeCommand(sender, command, label, args);
            if (ret) return true;
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {
        List<String> result = new ArrayList<>();

        for (CommandAbstract e : this.commands) {
            List<String> ret = e.tabComplete(sender, command, alias, args);

            if (ret == null) continue;

            result.addAll(ret);
        }

        return result;
    }
}
