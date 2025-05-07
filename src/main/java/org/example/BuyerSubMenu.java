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
        String lang = Lang.getLang(player);
        Inventory inv = Bukkit.createInventory(null, 27, Lang.t("farmer", player));
        
        // Добавляем предметы для продажи
        addSellableItem(inv, Material.APPLE, 0, lang.equals("ru") ? "§eЯблоко" : "§eApple", lang.equals("ru") ? "§7Цена: §a120 монет" : "§7Price: §a120 coins");
        addSellableItem(inv, Material.COOKED_PORKCHOP, 1, lang.equals("ru") ? "§eЖареная свинина" : "§eCooked Porkchop", lang.equals("ru") ? "§7Цена: §a50 монет" : "§7Price: §a50 coins");
        addSellableItem(inv, Material.GOLDEN_APPLE, 2, lang.equals("ru") ? "§6Золотое яблоко" : "§6Golden Apple", lang.equals("ru") ? "§7Цена: §a800 монет" : "§7Price: §a800 coins");
        addSellableItem(inv, Material.ENCHANTED_GOLDEN_APPLE, 3, lang.equals("ru") ? "§6Зачарованное золотое яблоко" : "§6Enchanted Golden Apple", lang.equals("ru") ? "§7Цена: §a6000 монет" : "§7Price: §a6000 coins");
        addSellableItem(inv, Material.WHEAT, 4, lang.equals("ru") ? "§eПшеница" : "§eWheat", lang.equals("ru") ? "§7Цена: §a10 монет" : "§7Price: §a10 coins");
        addSellableItem(inv, Material.CARROT, 5, lang.equals("ru") ? "§eМорковь" : "§eCarrot", lang.equals("ru") ? "§7Цена: §a8 монет" : "§7Price: §a8 coins");
        addSellableItem(inv, Material.POTATO, 6, lang.equals("ru") ? "§eКартофель" : "§ePotato", lang.equals("ru") ? "§7Цена: §a8 монет" : "§7Price: §a8 coins");
        addSellableItem(inv, Material.PUMPKIN, 7, lang.equals("ru") ? "§eТыква" : "§ePumpkin", lang.equals("ru") ? "§7Цена: §a15 монет" : "§7Price: §a15 coins");
        addSellableItem(inv, Material.MELON, 8, lang.equals("ru") ? "§eАрбуз" : "§eMelon", lang.equals("ru") ? "§7Цена: §a12 монет" : "§7Price: §a12 coins");
        
        addCompass(inv, player);
        player.openInventory(inv);
    }
    
    public static void openOresMenu(Player player) {
        String lang = Lang.getLang(player);
        Inventory inv = Bukkit.createInventory(null, 27, Lang.t("ores", player));
        
        // Добавляем предметы для продажи
        addSellableItem(inv, Material.DIAMOND, 0, lang.equals("ru") ? "§bАлмаз" : "§bDiamond", lang.equals("ru") ? "§7Цена: §a150 монет" : "§7Price: §a150 coins");
        addSellableItem(inv, Material.IRON_INGOT, 1, lang.equals("ru") ? "§7Железный слиток" : "§7Iron Ingot", lang.equals("ru") ? "§7Цена: §a100 монет" : "§7Price: §a100 coins");
        addSellableItem(inv, Material.GOLD_INGOT, 2, lang.equals("ru") ? "§6Золотой слиток" : "§6Gold Ingot", lang.equals("ru") ? "§7Цена: §a80 монет" : "§7Price: §a80 coins");
        addSellableItem(inv, Material.EMERALD, 3, lang.equals("ru") ? "§aИзумруд" : "§aEmerald", lang.equals("ru") ? "§7Цена: §a400 монет" : "§7Price: §a400 coins");
        addSellableItem(inv, Material.NETHERITE_INGOT, 4, lang.equals("ru") ? "§8Незерит" : "§8Netherite", lang.equals("ru") ? "§7Цена: §a600 монет" : "§7Price: §a600 coins");
        addSellableItem(inv, Material.GLOWSTONE_DUST, 5, lang.equals("ru") ? "§eСветокаменная пыль" : "§eGlowstone Dust", lang.equals("ru") ? "§7Цена: §a200 монет" : "§7Price: §a200 coins");
        
        // Блоки
        addSellableItem(inv, Material.DIAMOND_BLOCK, 9, lang.equals("ru") ? "§bБлок алмазов" : "§bDiamond Block", lang.equals("ru") ? "§7Цена: §a1350 монет" : "§7Price: §a1350 coins");
        addSellableItem(inv, Material.IRON_BLOCK, 10, lang.equals("ru") ? "§7Блок железа" : "§7Iron Block", lang.equals("ru") ? "§7Цена: §a900 монет" : "§7Price: §a900 coins");
        addSellableItem(inv, Material.GOLD_BLOCK, 11, lang.equals("ru") ? "§6Блок золота" : "§6Gold Block", lang.equals("ru") ? "§7Цена: §a720 монет" : "§7Price: §a720 coins");
        addSellableItem(inv, Material.EMERALD_BLOCK, 12, lang.equals("ru") ? "§aБлок изумрудов" : "§aEmerald Block", lang.equals("ru") ? "§7Цена: §a3600 монет" : "§7Price: §a3600 coins");
        
        addCompass(inv, player);
        player.openInventory(inv);
    }
    
    public static void openMobLootMenu(Player player) {
        String lang = Lang.getLang(player);
        Inventory inv = Bukkit.createInventory(null, 27, Lang.t("mob_loot", player));
        
        // Добавляем предметы для продажи
        addSellableItem(inv, Material.GUNPOWDER, 0, lang.equals("ru") ? "§7Порох" : "§7Gunpowder", lang.equals("ru") ? "§7Цена: §a80 монет" : "§7Price: §a80 coins");
        addSellableItem(inv, Material.ROTTEN_FLESH, 1, lang.equals("ru") ? "§7Гнилая плоть" : "§7Rotten Flesh", lang.equals("ru") ? "§7Цена: §a20 монет" : "§7Price: §a20 coins");
        addSellableItem(inv, Material.BONE, 2, lang.equals("ru") ? "§7Кость" : "§7Bone", lang.equals("ru") ? "§7Цена: §a50 монет" : "§7Price: §a50 coins");
        addSellableItem(inv, Material.ENDER_PEARL, 3, lang.equals("ru") ? "§5Эндер-жемчужина" : "§5Ender Pearl", lang.equals("ru") ? "§7Цена: §a100 монет" : "§7Price: §a100 coins");
        addSellableItem(inv, Material.FEATHER, 4, lang.equals("ru") ? "§fПеро" : "§fFeather", lang.equals("ru") ? "§7Цена: §a40 монет" : "§7Price: §a40 coins");
        addSellableItem(inv, Material.STRING, 5, lang.equals("ru") ? "§7Нитка" : "§7String", lang.equals("ru") ? "§7Цена: §a60 монет" : "§7Price: §a60 coins");
        addSellableItem(inv, Material.SLIME_BALL, 6, lang.equals("ru") ? "§aСгусток слизи" : "§aSlime Ball", lang.equals("ru") ? "§7Цена: §a110 монет" : "§7Price: §a110 coins");
        addSellableItem(inv, Material.BLAZE_ROD, 7, lang.equals("ru") ? "§6Огненный стержень" : "§6Blaze Rod", lang.equals("ru") ? "§7Цена: §a120 монет" : "§7Price: §a120 coins");
        addSellableItem(inv, Material.GHAST_TEAR, 8, lang.equals("ru") ? "§fСлеза гаста" : "§fGhast Tear", lang.equals("ru") ? "§7Цена: §a360 монет" : "§7Price: §a360 coins");
        addSellableItem(inv, Material.BLAZE_POWDER, 9, lang.equals("ru") ? "§6Огненный порошок" : "§6Blaze Powder", lang.equals("ru") ? "§7Цена: §a200 монет" : "§7Price: §a200 coins");
        addSellableItem(inv, Material.SPIDER_EYE, 10, lang.equals("ru") ? "§cМаринованный паучий глаз" : "§cFermented Spider Eye", lang.equals("ru") ? "§7Цена: §a250 монет" : "§7Price: §a250 coins");
        
        addCompass(inv, player);
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
    
    private static void addCompass(Inventory inv, Player player) {
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta meta = compass.getItemMeta();
        meta.setDisplayName(Lang.t("back", player));
        meta.setLore(Arrays.asList(Lang.t("compass_lore", player)));
        compass.setItemMeta(meta);
        inv.setItem(26, compass);
    }

    public static void sellItem(Player player, ItemStack item, int price, boolean isShiftClick) {
        IEssentials ess = BuyerPlugin.getEssentials();
        if (ess == null) {
            player.sendMessage(Lang.t("essentials_not_found", player));
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
                player.sendMessage(String.format(Lang.t("sold_many", player), amount, item.getItemMeta().getDisplayName(), totalPrice));
            } else {
                player.sendMessage(String.format(Lang.t("sold", player), item.getItemMeta().getDisplayName(), price));
            }
        } catch (MaxMoneyException e) {
            player.sendMessage(Lang.t("max_money", player));
        }
    }
} 