package com.github.mcnagatuki.realminecraft.commands;

import com.github.mcnagatuki.realminecraft.Items;
import com.github.mcnagatuki.realminecraft.RealMinecraft;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CmdGive extends CommandAbstract {
    private String cmdStr = "give";

    private CommandAbstract[] subCommands = new CommandAbstract[]{
            new Detector(),
            new Installer(),
            new Sweeper(),
    };

    public boolean executeCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 2) {
            for (CommandAbstract e : this.subCommands) {
                boolean ret = e.executeCommand(sender, command, label, args);
                if (ret) return true;
            }
        }

        return false;
    }

    public List<String> tabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 0) {
            return Collections.singletonList(this.cmdStr);
        }

        if (args.length == 1) {
            if (this.cmdStr.startsWith(args[0])) {
                return Collections.singletonList(this.cmdStr);
            }
            return null;
        }

        // args.length >= 2
        if (args[0].equalsIgnoreCase(this.cmdStr)) {
            List<String> result = new ArrayList<>();

            for (CommandAbstract e : this.subCommands) {
                List<String> ret = e.tabComplete(sender, command, alias, args);

                if (ret == null) continue;

                result.addAll(ret);
            }

            if (result.size() > 0) {
                return result;
            }
        }

        return null;
    }

    // give detector target [amount]
    class Detector extends CommandAbstract {
        private String cmdStr = "detector";

        private String itemId = Items.Detector.id;
        private String itemName = Items.Detector.name;
        private String itemNameColor = Items.Detector.color;
        private String nbt;
//        private String itemLore = "左クリックで地雷が埋まっているかを確認";

        public Detector() {
            super();
            this.nbt = "{display:{Name:\"{\\\"text\\\":\\\"" + this.itemName + "\\\",\\\"color\\\":\\\"" + this.itemNameColor + "\\\"}\"}}";
        }

        // /give Nagatuki minecraft:iron_bars{display:{Name:"{\"text\":\"地雷探知機\",\"color\":\"green\"}"}} 1
        public boolean executeCommand(CommandSender sender, Command command, String label, String[] args) {
            if (args.length == 3 && args[1].equalsIgnoreCase(this.cmdStr)) {
                String cmd = String.join(" ", new String[]{"give", args[2], this.itemId + this.nbt});
                return Bukkit.dispatchCommand(sender, cmd);
            }

            if (args.length == 4 && args[1].equalsIgnoreCase(this.cmdStr) && CommandArgsParser.isNaturalNumber(args[3])) {
                String cmd = String.join(" ", new String[]{"give", args[2], this.itemId + this.nbt, args[3]});
                return Bukkit.dispatchCommand(sender, cmd);
            }

            return false;
        }

        public List<String> tabComplete(CommandSender sender, Command command, String alias, String[] args) {
            if (args.length == 2 && this.cmdStr.startsWith(args[1])) {
                return Collections.singletonList(this.cmdStr);
            }

            if (args.length == 3 && args[1].equalsIgnoreCase(this.cmdStr)) {
                List<String> ret = new ArrayList<>();
                for (Player p : RealMinecraft.plugin.getServer().getOnlinePlayers()) {
                    String pName = p.getName();
                    if (pName.startsWith(args[2])) {
                        ret.add(pName);
                    }
                }
                return ret;
            }

            return null;
        }
    }

    // give installer target
    class Installer extends CommandAbstract {
        private String cmdStr = "installer";

        private String itemId = Items.Installer.id;
        private String itemName = Items.Installer.name;
        private String itemNameColor = Items.Installer.color;
        private String nbt;

        public Installer() {
            super();
            this.nbt = "{display:{Name:\"{\\\"text\\\":\\\"" + this.itemName + "\\\",\\\"color\\\":\\\"" + this.itemNameColor + "\\\"}\"}}";
        }

        public boolean executeCommand(CommandSender sender, Command command, String label, String[] args) {
            if (args.length == 3 && args[1].equalsIgnoreCase(this.cmdStr)) {
                String cmd = String.join(" ", new String[]{"give", args[2], this.itemId + this.nbt});
                return Bukkit.dispatchCommand(sender, cmd);
            }

            if (args.length == 4 && args[1].equalsIgnoreCase(this.cmdStr) && CommandArgsParser.isNaturalNumber(args[3])) {
                String cmd = String.join(" ", new String[]{"give", args[2], this.itemId + this.nbt, args[3]});
                return Bukkit.dispatchCommand(sender, cmd);
            }

            return false;
        }

        public List<String> tabComplete(CommandSender sender, Command command, String alias, String[] args) {
            if (args.length == 2 && this.cmdStr.startsWith(args[1])) {
                return Collections.singletonList(this.cmdStr);
            }

            if (args.length == 3 && args[1].equalsIgnoreCase(this.cmdStr)) {
                List<String> ret = new ArrayList<>();
                for (Player p : RealMinecraft.plugin.getServer().getOnlinePlayers()) {
                    String pName = p.getName();
                    if (pName.startsWith(args[2])) {
                        ret.add(pName);
                    }
                }
                return ret;
            }

            return null;
        }
    }

    // give sweeper target
    class Sweeper extends CommandAbstract {
        private String cmdStr = "sweeper";

        private String itemId = Items.Sweeper.id;
        private String itemName = Items.Sweeper.name;
        private String itemNameColor = Items.Sweeper.color;
        private String nbt;

        public Sweeper() {
            super();
            this.nbt = "{display:{Name:\"{\\\"text\\\":\\\"" + this.itemName + "\\\",\\\"color\\\":\\\"" + this.itemNameColor + "\\\"}\"}}";
        }

        public boolean executeCommand(CommandSender sender, Command command, String label, String[] args) {
            if (args.length == 3 && args[1].equalsIgnoreCase(this.cmdStr)) {
                String cmd = String.join(" ", new String[]{"give", args[2], this.itemId + this.nbt});
                return Bukkit.dispatchCommand(sender, cmd);
            }

            if (args.length == 4 && args[1].equalsIgnoreCase(this.cmdStr) && CommandArgsParser.isNaturalNumber(args[3])) {
                String cmd = String.join(" ", new String[]{"give", args[2], this.itemId + this.nbt, args[3]});
                return Bukkit.dispatchCommand(sender, cmd);
            }

            return false;
        }

        public List<String> tabComplete(CommandSender sender, Command command, String alias, String[] args) {
            if (args.length == 2 && this.cmdStr.startsWith(args[1])) {
                return Collections.singletonList(this.cmdStr);
            }

            if (args.length == 3 && args[1].equalsIgnoreCase(this.cmdStr)) {
                List<String> ret = new ArrayList<>();
                for (Player p : RealMinecraft.plugin.getServer().getOnlinePlayers()) {
                    String pName = p.getName();
                    if (pName.startsWith(args[2])) {
                        ret.add(pName);
                    }
                }
                return ret;
            }

            return null;
        }
    }
}
