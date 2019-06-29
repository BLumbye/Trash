package net.blumbye.trash;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class Trash extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        this.getCommand("trash").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("trash")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Only players can use this command!");
                return true;
            }

            if (!sender.hasPermission(command.getPermission())) {
                sender.sendMessage(command.getPermissionMessage());
                return true;
            }

            Player p = (Player) sender;
            Inventory inventory = Bukkit.createInventory(p, 27, "Trash");
            p.openInventory(inventory);
        }

        return true;
    }
}
