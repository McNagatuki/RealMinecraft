package com.github.mcnagatuki.realminecraft.commands;

import com.github.mcnagatuki.realminecraft.BlockPosition;
import com.github.mcnagatuki.realminecraft.MineConfiguration;
import com.github.mcnagatuki.realminecraft.RealMinecraft;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CmdAutoLay extends CommandAbstract {
    private String cmdStr = "autolay";

    public boolean executeCommand(CommandSender sender, Command command, String label, String[] args) {
        RealMinecraft plugin = RealMinecraft.plugin;
        MineConfiguration config = plugin.getMineConfig();

        if (args.length == 1 && args[0].equalsIgnoreCase(this.cmdStr)) {
            BlockPosition pos1, pos2;
            double prob;
            pos1 = config.getPos1();
            pos2 = config.getPos2();
            prob = config.getProbability();

            plugin.getMineManager().layAutomatically(pos1, pos2, prob);
            sender.sendMessage("[RealMinecraft] set mines automatically");
            return true;
        }

        if (args.length == 5 && args[0].equalsIgnoreCase(this.cmdStr)) {
            Location loc = ((Player) sender).getLocation();

            Optional<Integer> x1optional = CommandArgsParser.parsePosArgToBlockPos(args[1], loc.getX());
            Optional<Integer> z1optional = CommandArgsParser.parsePosArgToBlockPos(args[2], loc.getZ());
            Optional<Integer> x2optional = CommandArgsParser.parsePosArgToBlockPos(args[3], loc.getX());
            Optional<Integer> z2optional = CommandArgsParser.parsePosArgToBlockPos(args[4], loc.getZ());

            if(!(x1optional.isPresent() && z1optional.isPresent() && x2optional.isPresent() && z2optional.isPresent())){
                return false;
            }

            BlockPosition pos1 = new BlockPosition(x1optional.get(), z1optional.get());
            BlockPosition pos2 = new BlockPosition(x2optional.get(), z2optional.get());
            double prob = config.getProbability();

            plugin.getMineManager().layAutomatically(pos1, pos2, prob);
            sender.sendMessage("[RealMinecraft] set mines automatically");
            return true;
        }

        return false;
    }

    public List<String> tabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1 && this.cmdStr.startsWith(args[0])) {
            return Arrays.asList(this.cmdStr);
        }

        if (args[0].equalsIgnoreCase(this.cmdStr)) {
            switch (args.length) {
                case 2:
                    return Arrays.asList("~ ~ ~ ~");
                case 3:
                    return Arrays.asList("~ ~ ~");
                case 4:
                    return Arrays.asList("~ ~");
                case 5:
                    return Arrays.asList("~");
            }
        }

        return null;
    }
}
