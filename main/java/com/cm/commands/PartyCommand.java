package com.cm.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class PartyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        ArrayList<String> members = new ArrayList<String>();

        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("invite")) {
                members.add(args[1]);
                player.sendMessage(ChatColor.GREEN + "Added " + args[1] + " to the partychat!");
            } else if (args[0].equalsIgnoreCase("kick")) {

                if (members.contains(args[1])){
                    members.remove(args[1]);
                } else {
                    player.sendMessage(ChatColor.RED + "This Player is not in the Party");
                }
            }

        }

        System.out.println(members);

        return false;
    }
}
