package org.example;

import net.ess3.api.IEssentials;
import net.ess3.api.MaxMoneyException;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.math.BigDecimal;
import java.util.Arrays;

public class BuyerSubMenu {
    public static void openFarmerMenu(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, "§eФермер");
        
        // Добавляем предметы для продажи
        addSellableItem(inv, Material.APPLE, 0, "§eЯблоко", "§7Цена: §a120 монет");
        addSellableItem(inv, Material.COOKED_PORKCHOP, 1, "§eЖареная свинина", "§7Цена: §a50 монет");
        addSellableItem(inv, Material.GOLDEN_APPLE, 2, "§6Золотое яблоко", "§7Цена: §a800 монет");
        addSellableItem(inv, Material.ENCHANTED_GOLDEN_APPLE, 3, "§6Зачарованное золотое яблоко", "§7Цена: §a6000 монет");
        addSellableItem(inv, Material.WHEAT, 4, "§eПшеница", "§7Цена: §a10 монет");
        addSellableItem(inv, Material.CARROT, 5, "§eМорковь", "§7Цена: §a8 монет");
        addSellableItem(inv, Material.POTATO, 6, "§eКартофель", "§7Цена: §a8 монет");
        addSellableItem(inv, Material.PUMPKIN, 7, "§eТыква", "§7Цена: §a15 монет");
        addSellableItem(inv, Material.MELON, 8, "§eАрбуз", "§7Цена: §a12 монет");
        
        addCompass(inv);
        player.openInventory(inv);
    }
    
    public static void openOresMenu(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, "§bРуды");
        
        // Добавляем предметы для продажи
        addSellableItem(inv, Material.DIAMOND, 0, "§bАлмаз", "§7Цена: §a150 монет");
        addSellableItem(inv, Material.IRON_INGOT, 1, "§7Железный слиток", "§7Цена: §a100 монет");
        addSellableItem(inv, Material.GOLD_INGOT, 2, "§6Золотой слиток", "§7Цена: §a80 монет");
        addSellableItem(inv, Material.EMERALD, 3, "§aИзумруд", "§7Цена: §a400 монет");
        addSellableItem(inv, Material.NETHERITE_INGOT, 4, "§8Незерит", "§7Цена: §a600 монет");
        addSellableItem(inv, Material.GLOWSTONE_DUST, 5, "§eСветокаменная пыль", "§7Цена: §a200 монет");
        
        // Блоки
        addSellableItem(inv, Material.DIAMOND_BLOCK, 9, "§bБлок алмазов", "§7Цена: §a1350 монет");
        addSellableItem(inv, Material.IRON_BLOCK, 10, "§7Блок железа", "§7Цена: §a900 монет");
        addSellableItem(inv, Material.GOLD_BLOCK, 11, "§6Блок золота", "§7Цена: §a720 монет");
        addSellableItem(inv, Material.EMERALD_BLOCK, 12, "§aБлок изумрудов", "§7Цена: §a3600 монет");
        
        addCompass(inv);
        player.openInventory(inv);
    }
    
    public static void openMobLootMenu(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, "§7Лут с мобов");
        
        // Добавляем предметы для продажи
        addSellableItem(inv, Material.GUNPOWDER, 0, "§7Порох", "§7Цена: §a80 монет");
        addSellableItem(inv, Material.ROTTEN_FLESH, 1, "§7Гнилая плоть", "§7Цена: §a20 монет");
        addSellableItem(inv, Material.BONE, 2, "§7Кость", "§7Цена: §a50 монет");
        addSellableItem(inv, Material.ENDER_PEARL, 3, "§5Эндер-жемчужина", "§7Цена: §a100 монет");
        addSellableItem(inv, Material.FEATHER, 4, "§fПеро", "§7Цена: §a40 монет");
        addSellableItem(inv, Material.STRING, 5, "§7Нитка", "§7Цена: §a60 монет");
        addSellableItem(inv, Material.SLIME_BALL, 6, "§aСгусток слизи", "§7Цена: §a110 монет");
        addSellableItem(inv, Material.BLAZE_ROD, 7, "§6Огненный стержень", "§7Цена: §a120 монет");
        addSellableItem(inv, Material.GHAST_TEAR, 8, "§fСлеза гаста", "§7Цена: §a360 монет");
        addSellableItem(inv, Material.BLAZE_POWDER, 9, "§6Огненный порошок", "§7Цена: §a200 монет");
        addSellableItem(inv, Material.SPIDER_EYE, 10, "§cМаринованный паучий глаз", "§7Цена: §a250 монет");
        
        addCompass(inv);
        player.openInventory(inv);
    }
    
    private static void addSellableItem(Inventory inv, Material material, int slot, String name, String... lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        inv.setItem(slot, item);
    }
    
    private static void addCompass(Inventory inv) {
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta meta = compass.getItemMeta();
        meta.setDisplayName("§eВернуться назад");
        meta.setLore(Arrays.asList("§7buyer сделан по просьбе орущих пидоров"));
        compass.setItemMeta(meta);
        inv.setItem(26, compass);
    }

    public static void sellItem(Player player, ItemStack item, int price, boolean isShiftClick) {
        IEssentials ess = BuyerPlugin.getEssentials();
        if (ess == null) {
            player.sendMessage("§cОшибка: Essentials не найден!");
            return;
        }
        Material material = item.getType();
        int amount = 1;
        if (isShiftClick) {
            for (ItemStack invItem : player.getInventory().getContents()) {
                if (invItem != null && invItem.getType() == material) {
                    amount = invItem.getAmount();
                    break;
                }
            }
        }
        try {
            player.getInventory().removeItem(new ItemStack(material, amount));
            BigDecimal totalPrice = BigDecimal.valueOf(price * amount);
            ess.getUser(player).giveMoney(totalPrice);
            if (amount > 1) {
                player.sendMessage("§aВы продали §e" + amount + "x " + item.getItemMeta().getDisplayName() +
                                 " §aза §e" + totalPrice + " монет");
            } else {
                player.sendMessage("§aВы продали " + item.getItemMeta().getDisplayName() +
                                 " §aза §e" + price + " монет");
            }
        } catch (MaxMoneyException e) {
            player.sendMessage("§cОшибка: Достигнут максимальный лимит денег!");
        }
    }
} 