package com.cm.commands;

import com.cm.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PartyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("invite")) {
                if (Main.members.size() == 0){
                    Main.owner = player.getName();
                    player.sendMessage(ChatColor.GREEN + "You are the owner now of the party");
                }
                Main.members.add(args[1]);
                player.sendMessage(ChatColor.GREEN + "Added " + args[1] + " to the partychat!");
            } else if (args[0].equalsIgnoreCase("kick")) {
                if(Main.owner.equalsIgnoreCase(player.getName())) {
                    if (Main.members.contains(args[1])) {
                        Main.members.remove(args[1]);
                    } else {
                        player.sendMessage(ChatColor.RED + "This Player is not in the Party");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Only owners can kick players!");
                }
            } else if (args[0].equalsIgnoreCase("chat")) {
                for (int i = 0; i < Main.members.size(); i++) {
                    Player other = Bukkit.getPlayer(Main.members.get(i));

                    if (!Main.members.get(i).equalsIgnoreCase(player.getName())) {
                        other.sendMessage("[" + ChatColor.BLUE + "PARTY" + ChatColor.RESET + "]: " + args[1]);
                    }
                }
            }
        } else if (args.length > 0) {
            if (args[0].equalsIgnoreCase("chat")) {
                String msg = "";
                for (int i = 1; i < args.length; i++) {
                    msg = msg + args[i] + " ";
                }

                for (int i = 0; i < Main.members.size(); i++) {
                    Player other = Bukkit.getPlayer(Main.members.get(i));

                    if (!Main.members.get(i).equalsIgnoreCase(player.getName())) {
                        other.sendMessage("[" + ChatColor.BLUE + "PARTY" + ChatColor.RESET + "]: " + msg);
                    }
                }
            }
        } else {
            player.sendMessage(ChatColor.RED + "Invalid Arguments! Use /p <invite/kick/chat> <player/msg>");
        }
        return false;
    }
}
