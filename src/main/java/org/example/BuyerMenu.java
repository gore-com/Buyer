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

public class BuyerMenu implements Listener {
    public static void openMenu(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, "§cСкупщик");

        // Пшеница (фермер)
        ItemStack wheat = new ItemStack(Material.WHEAT);
        ItemMeta wheatMeta = wheat.getItemMeta();
        wheatMeta.setDisplayName("§eФермер");
        wheat.setItemMeta(wheatMeta);
        inv.setItem(11, wheat);

        // Алмаз (руды)
        ItemStack diamond = new ItemStack(Material.DIAMOND);
        ItemMeta diamondMeta = diamond.getItemMeta();
        diamondMeta.setDisplayName("§bРуды");
        diamond.setItemMeta(diamondMeta);
        inv.setItem(13, diamond);

        // Порох (лут с мобов)
        ItemStack gunpowder = new ItemStack(Material.GUNPOWDER);
        ItemMeta gunpowderMeta = gunpowder.getItemMeta();
        gunpowderMeta.setDisplayName("§7Лут с мобов");
        gunpowder.setItemMeta(gunpowderMeta);
        inv.setItem(15, gunpowder);

        // Добавляем компас
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compassMeta = compass.getItemMeta();
        compassMeta.setDisplayName("§eВернуться назад");
        compassMeta.setLore(java.util.Arrays.asList("§7buyer сделан по просьбе орущих пидоров"));
        compass.setItemMeta(compassMeta);
        inv.setItem(26, compass);

        player.openInventory(inv);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        
        // Проверяем, что это наше меню
        if (!event.getView().getTitle().contains("Скупщик") && 
            !event.getView().getTitle().contains("Фермер") && 
            !event.getView().getTitle().contains("Руды") && 
            !event.getView().getTitle().contains("Лут с мобов")) {
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
        if (title.contains("Скупщик")) {
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
                player.sendMessage("§cУ вас нет этого предмета!");
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