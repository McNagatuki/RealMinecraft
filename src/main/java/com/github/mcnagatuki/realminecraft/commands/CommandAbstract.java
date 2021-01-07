package com.github.mcnagatuki.realminecraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

abstract public class CommandAbstract {
    abstract public boolean executeCommand(CommandSender sender, Command command, String label, String[] args);
    abstract public List<String> tabComplete(CommandSender sender, Command command, String alias, String[] args);
}
