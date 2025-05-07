package org.example;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuyerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Lang.console("only_player"));
            return true;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("buyer.use")) {
            player.sendMessage(Lang.t("no_permission", player));
            return true;
        }
        BuyerMenu.openMenu(player);
        return true;
    }
} 