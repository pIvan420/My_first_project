import java.util.HashMap;
import java.util.Map;

public class Spectrum extends Case{

    // все передается в родительский класс
    Spectrum(){
        super(createBlueDrop(), createPurpleDrop(), createPinkDrop(), createRedDrop(), createGoldDrop());
    }

    // синий дроп
    private static Map<String, Float[]> createBlueDrop(){
        Map<String, Float[]> drop = new HashMap<>();
        drop.put("PP-Bizon | Вихрь джунглей", new Float[]{8.75f, 17.49f});
        drop.put("MP7 | Горн войны", new Float[] {6.01f, 17.28f});
        drop.put("P250 | Зыбь", new Float[] {6.67f, 17.28f});
        drop.put("Five-SeveN | Капилляры", new Float[] {6.76f, 19.54f});
        drop.put("SCAR-20 | Калька", new Float[] {6.76f, 24.05f});
        drop.put("Sawed-Off | Судак", new Float[] {5.26f, 33.82f});
        drop.put("Desert Eagle | Оксидное пламя", new Float[] {12.78f, 36.82f});
        return drop;
    }

    // фиолетовый дроп
    private static Map<String, Float[]> createPurpleDrop(){
        Map<String, Float[]> drop = new HashMap<>();
        drop.put("M249 | Укус изумрудного яда", new Float[]{ 71.94f, 144.63f });
        drop.put("Galil AR | Багровое цунами", new Float[]{ 70.42f, 145.39f });
        drop.put("MAC-10 | Последнее погружение", new Float[]{ 80.27f, 146.15f });
        drop.put("XM1014 | Времена года", new Float[]{ 72.70f, 149.94f });
        drop.put("UMP-45 | Каркас", new Float[]{ 65.12f, 159.78f });
        return drop;
    }

    // розовый дроп
    private static Map<String, Float[]> createPinkDrop() {
        Map<String, Float[]> drop = new HashMap<>();
        drop.put("CZ75-Auto | Сян-лю", new Float[]{ 499.03f, 729.23f });
        drop.put("AWP | Горячечные грёзы", new Float[]{ 570.97f, 994.27f });
        drop.put("M4A1-S | Опустошитель", new Float[]{ 732.26f, 2081.68f });
        return drop;
    }

    // красный дроп
    private static Map<String, Float[]> createRedDrop() {
        Map<String, Float[]> drop = new HashMap<>();
        drop.put("USP-S | Неонуар", new Float[]{ 1078.32f, 3289.49f });
        drop.put("AK-47 | Кровавый спорт", new Float[]{ 5484.76f, 7738.34f });
        return drop;
    }

    // ножи
    private static Map<String, Float[]> createGoldDrop() {
        Map<String, Float[]> drop = new HashMap<>();
        drop.put("★ Нож-бабочка | Волны Черная Жемчужина", new Float[]{ 280494.13f, 290000.00f });
        return drop;
    }


}
