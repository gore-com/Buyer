package org.example;

import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;

public class Lang {
    private static final Map<String, Map<String, String>> translations = new HashMap<>();
    // По умолчанию язык консоли английский
    private static final String SERVER_LANG = "en";

    static {
        // Русский
        Map<String, String> ru = new HashMap<>();
        ru.put("menu_title", "§cСкупщик");
        ru.put("farmer", "§eФермер");
        ru.put("ores", "§bРуды");
        ru.put("mob_loot", "§7Лут с мобов");
        ru.put("back", "§eВернуться назад");
        ru.put("compass_lore", "§7buyer сделан по просьбе орущих пидоров");
        ru.put("no_permission", "§cУмоляй меня чтоб я выдал тебе права!!");
        ru.put("only_player", "§cТолько игрок может использовать эту команду!");
        ru.put("no_item", "§cУ вас нет этого предмета!");
        ru.put("sold_one", "§aВы продали %item% §aза §e%price% монет");
        ru.put("sold_many", "§aВы продали §e%amount%x %item% §aза §e%price% монет");
        ru.put("essentials_not_found", "§cОшибка: Essentials не найден!");
        ru.put("max_money", "§cОшибка: Достигнут максимальный лимит денег!");
        ru.put("plugin_loaded", "Плагин успешно загружен!");
        ru.put("plugin_disabled", "Essentials не найден! Плагин будет отключен!");
        
        // Предметы
        ru.put("item_apple", "§eЯблоко");
        ru.put("item_cooked_porkchop", "§eЖареная свинина");
        ru.put("item_golden_apple", "§6Золотое яблоко");
        ru.put("item_enchanted_golden_apple", "§6Зачарованное золотое яблоко");
        ru.put("item_wheat", "§eПшеница");
        ru.put("item_carrot", "§eМорковь");
        ru.put("item_potato", "§eКартофель");
        ru.put("item_pumpkin", "§eТыква");
        ru.put("item_melon", "§eАрбуз");
        ru.put("item_diamond", "§bАлмаз");
        ru.put("item_iron_ingot", "§7Железный слиток");
        ru.put("item_gold_ingot", "§6Золотой слиток");
        ru.put("item_emerald", "§aИзумруд");
        ru.put("item_netherite_ingot", "§8Незерит");
        ru.put("item_glowstone_dust", "§eСветокаменная пыль");
        ru.put("item_diamond_block", "§bБлок алмазов");
        ru.put("item_iron_block", "§7Блок железа");
        ru.put("item_gold_block", "§6Блок золота");
        ru.put("item_emerald_block", "§aБлок изумрудов");
        ru.put("item_gunpowder", "§7Порох");
        ru.put("item_rotten_flesh", "§7Гнилая плоть");
        ru.put("item_bone", "§7Кость");
        ru.put("item_ender_pearl", "§5Эндер-жемчужина");
        ru.put("item_feather", "§fПеро");
        ru.put("item_string", "§7Нитка");
        ru.put("item_slime_ball", "§aСгусток слизи");
        ru.put("item_blaze_rod", "§6Огненный стержень");
        ru.put("item_ghast_tear", "§fСлеза гаста");
        ru.put("item_blaze_powder", "§6Огненный порошок");
        ru.put("item_spider_eye", "§cМаринованный паучий глаз");
        
        // Цены
        ru.put("price_format", "§7Цена: §a%price% монет");

        // Английский
        Map<String, String> en = new HashMap<>();
        en.put("menu_title", "§cBuyer");
        en.put("farmer", "§eFarmer");
        en.put("ores", "§bOres");
        en.put("mob_loot", "§7Mob Loot");
        en.put("back", "§eGo back");
        en.put("compass_lore", "§7buyer made by request of screaming idiots");
        en.put("no_permission", "§cBeg me to give you permission!!");
        en.put("only_player", "§cOnly a player can use this command!");
        en.put("no_item", "§cYou don't have this item!");
        en.put("sold_one", "§aYou sold %item% §afor §e%price% coins");
        en.put("sold_many", "§aYou sold §e%amount%x %item% §afor §e%price% coins");
        en.put("essentials_not_found", "§cError: Essentials not found!");
        en.put("max_money", "§cError: Max money limit reached!");
        en.put("plugin_loaded", "Plugin loaded successfully!");
        en.put("plugin_disabled", "Essentials not found! Plugin will be disabled!");
        
        // Items
        en.put("item_apple", "§eApple");
        en.put("item_cooked_porkchop", "§eCooked Porkchop");
        en.put("item_golden_apple", "§6Golden Apple");
        en.put("item_enchanted_golden_apple", "§6Enchanted Golden Apple");
        en.put("item_wheat", "§eWheat");
        en.put("item_carrot", "§eCarrot");
        en.put("item_potato", "§ePotato");
        en.put("item_pumpkin", "§ePumpkin");
        en.put("item_melon", "§eMelon");
        en.put("item_diamond", "§bDiamond");
        en.put("item_iron_ingot", "§7Iron Ingot");
        en.put("item_gold_ingot", "§6Gold Ingot");
        en.put("item_emerald", "§aEmerald");
        en.put("item_netherite_ingot", "§8Netherite Ingot");
        en.put("item_glowstone_dust", "§eGlowstone Dust");
        en.put("item_diamond_block", "§bDiamond Block");
        en.put("item_iron_block", "§7Iron Block");
        en.put("item_gold_block", "§6Gold Block");
        en.put("item_emerald_block", "§aEmerald Block");
        en.put("item_gunpowder", "§7Gunpowder");
        en.put("item_rotten_flesh", "§7Rotten Flesh");
        en.put("item_bone", "§7Bone");
        en.put("item_ender_pearl", "§5Ender Pearl");
        en.put("item_feather", "§fFeather");
        en.put("item_string", "§7String");
        en.put("item_slime_ball", "§aSlime Ball");
        en.put("item_blaze_rod", "§6Blaze Rod");
        en.put("item_ghast_tear", "§fGhast Tear");
        en.put("item_blaze_powder", "§6Blaze Powder");
        en.put("item_spider_eye", "§cFermented Spider Eye");
        
        // Prices
        en.put("price_format", "§7Price: §a%price% coins");

        translations.put("ru", ru);
        translations.put("en", en);
    }

    public static String getLang(Player player) {
        String locale = player.getLocale();
        if (locale != null && locale.toLowerCase().startsWith("ru")) return "ru";
        return "en";
    }

    public static String t(String key, String lang) {
        return translations.getOrDefault(lang, translations.get("en")).getOrDefault(key, key);
    }

    public static String t(String key, Player player) {
        return t(key, getLang(player));
    }

    public static String console(String key) {
        return t(key, SERVER_LANG);
    }

    public static String format(String key, Player player, Map<String, String> params) {
        String msg = t(key, player);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            msg = msg.replace("%" + entry.getKey() + "%", entry.getValue());
        }
        return msg;
    }
    
    public static String price(int price, Player player) {
        Map<String, String> params = new HashMap<>();
        params.put("price", String.valueOf(price));
        return format("price_format", player, params);
    }
} 