package org.example;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class BuyerMenu implements Listener {
    public static void openMenu(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, Lang.t("menu_title", player));

        // Пшеница (фермер)
        ItemStack wheat = new ItemStack(Material.WHEAT);
        ItemMeta wheatMeta = wheat.getItemMeta();
        wheatMeta.setDisplayName(Lang.t("farmer", player));
        wheat.setItemMeta(wheatMeta);
        inv.setItem(11, wheat);

        // Алмаз (руды)
        ItemStack diamond = new ItemStack(Material.DIAMOND);
        ItemMeta diamondMeta = diamond.getItemMeta();
        diamondMeta.setDisplayName(Lang.t("ores", player));
        diamond.setItemMeta(diamondMeta);
        inv.setItem(13, diamond);

        // Порох (лут с мобов)
        ItemStack gunpowder = new ItemStack(Material.GUNPOWDER);
        ItemMeta gunpowderMeta = gunpowder.getItemMeta();
        gunpowderMeta.setDisplayName(Lang.t("mob_loot", player));
        gunpowder.setItemMeta(gunpowderMeta);
        inv.setItem(15, gunpowder);

        // Добавляем компас
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compassMeta = compass.getItemMeta();
        compassMeta.setDisplayName(Lang.t("back", player));
        compassMeta.setLore(Arrays.asList(Lang.t("compass_lore", player)));
        compass.setItemMeta(compassMeta);
        inv.setItem(26, compass);

        player.openInventory(inv);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        
        // Проверяем, что это наше меню
        if (!event.getView().getTitle().contains(Lang.t("menu_title", player).replace("§c", "")) && 
            !event.getView().getTitle().contains(Lang.t("farmer", player).replace("§e", "")) && 
            !event.getView().getTitle().contains(Lang.t("ores", player).replace("§b", "")) && 
            !event.getView().getTitle().contains(Lang.t("mob_loot", player).replace("§7", ""))) {
            return;
        }

        // Отменяем перемещение предметов
        event.setCancelled(true);

        // Проверяем клик по предметам
        if (event.getCurrentItem() == null) return;
        
        String title = event.getView().getTitle();
        ItemStack clickedItem = event.getCurrentItem();
        boolean isShiftClick = event.isShiftClick();

        // Обработка кликов в главном меню
        if (title.contains(Lang.t("menu_title", player).replace("§c", ""))) {
            if (clickedItem.getType() == Material.WHEAT) {
                BuyerSubMenu.openFarmerMenu(player);
            } else if (clickedItem.getType() == Material.DIAMOND) {
                BuyerSubMenu.openOresMenu(player);
            } else if (clickedItem.getType() == Material.GUNPOWDER) {
                BuyerSubMenu.openMobLootMenu(player);
            } else if (clickedItem.getType() == Material.COMPASS) {
                player.closeInventory();
            }
        }
        // Обработка кликов в подменю
        else {
            if (clickedItem.getType() == Material.COMPASS) {
                openMenu(player);
                return;
            }

            // Проверяем, есть ли у игрока этот предмет
            if (!player.getInventory().contains(clickedItem.getType())) {
                player.sendMessage(Lang.t("no_item", player));
                return;
            }

            // Получаем цену из описания предмета
            String lore = clickedItem.getItemMeta().getLore().get(0);
            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("(\\d+)").matcher(lore);
            int price = 0;
            while (matcher.find()) {
                price = Integer.parseInt(matcher.group(1));
            }
            
            // Продаём предмет
            BuyerSubMenu.sellItem(player, clickedItem, price, isShiftClick);
        }
    }
} 