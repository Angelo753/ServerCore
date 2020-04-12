package me.angelcore.commands;

import me.angelcore.configurations.Messages;
import me.angelcore.utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class speed implements CommandExecutor {

    public boolean isInt(String integer){
        try {
            Integer.parseInt(integer);
        }catch (NumberFormatException | NullPointerException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (args.length == 1) {
            if (isInt(args[0])) {
                if (p.isOp() || p.hasPermission("*") || p.hasPermission("angelcore.command.speed")) {
                    if (!p.isOnGround()) {
                        Integer arg = Integer.parseInt(args[0]);
                        if (!(arg > 10)){
                        switch (args[0]) {
                            case "0":
                                p.setFlySpeed(0f);
                                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedFly").replace("%amount%", args[0])));
                                break;
                            case "1":
                                p.setFlySpeed(0.1f);
                                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedFly").replace("%amount%", args[0])));
                                break;
                            case "2":
                                p.setFlySpeed(0.2f);
                                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedFly").replace("%amount%", args[0])));
                                break;
                            case "3":
                                p.setFlySpeed(0.3f);
                                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedFly").replace("%amount%", args[0])));
                                break;
                            case "4":
                                p.setFlySpeed(0.4f);
                                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedFly").replace("%amount%", args[0])));
                                break;
                            case "5":
                                p.setFlySpeed(0.5f);
                                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedFly").replace("%amount%", args[0])));
                                break;
                            case "6":
                                p.setFlySpeed(0.6f);
                                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedFly").replace("%amount%", args[0])));
                                break;
                            case "7":
                                p.setFlySpeed(0.7f);
                                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedFly").replace("%amount%", args[0])));
                                break;
                            case "8":
                                p.setFlySpeed(0.8f);
                                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedFly").replace("%amount%", args[0])));
                                break;
                            case "9":
                                p.setFlySpeed(0.9f);
                                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedFly").replace("%amount%", args[0])));
                                break;
                            case "10":
                                p.setFlySpeed(1f);
                                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedFly").replace("%amount%", args[0])));
                                break;
                        }
                        }else {
                            p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedError")));
                        }
                    }else {
                        Integer arg = Integer.parseInt(args[0]);
                        if (!(arg > 10)){
                            switch (args[0]) {
                                case "0":
                                    p.setWalkSpeed(0f);
                                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedWalk").replace("%amount%", args[0])));
                                    break;
                                case "1":
                                    p.setWalkSpeed(0.1f);
                                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedWalk").replace("%amount%", args[0])));
                                    break;
                                case "2":
                                    p.setWalkSpeed(0.2f);
                                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedWalk").replace("%amount%", args[0])));
                                    break;
                                case "3":
                                    p.setWalkSpeed(0.3f);
                                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedWalk").replace("%amount%", args[0])));
                                    break;
                                case "4":
                                    p.setWalkSpeed(0.4f);
                                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedWalk").replace("%amount%", args[0])));
                                    break;
                                case "5":
                                    p.setWalkSpeed(0.5f);
                                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedWalk").replace("%amount%", args[0])));
                                    break;
                                case "6":
                                    p.setWalkSpeed(0.6f);
                                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedWalk").replace("%amount%", args[0])));
                                    break;
                                case "7":
                                    p.setWalkSpeed(0.7f);
                                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedWalk").replace("%amount%", args[0])));
                                    break;
                                case "8":
                                    p.setWalkSpeed(0.8f);
                                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedWalk").replace("%amount%", args[0])));
                                    break;
                                case "9":
                                    p.setWalkSpeed(0.9f);
                                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedWalk").replace("%amount%", args[0])));
                                    break;
                                case "10":
                                    p.setWalkSpeed(1f);
                                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedWalk").replace("%amount%", args[0])));
                                    break;
                            }
                        }else {
                            p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedError")));
                        }
                    }
                }
            } else {
                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedError")));
            }
        }else {
            p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("speedError")));
        }
        return false;
    }
}
