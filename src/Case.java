import java.util.*;

public abstract class Case{
    private Map<String, Map<String, Float[]>> drop;

    private static final float[] CHANCES = { 0.7992f, 0.1598f, 0.0320f, 0.0064f, 0.0026f }; // шанс выпадения

    private static final String[] SKINTYPES = {"Blue", "Purple", "Pink", "Red", "Gold"};

    Case(Map<String, Float[]> BlueDrop,
         Map<String, Float[]> PurpleDrop,
         Map<String, Float[]> PinkDrop,
         Map<String, Float[]> RedDrop,
         Map<String, Float[]> GoldDrop){
        drop = new HashMap<>();
        drop.put(SKINTYPES[0], BlueDrop);
        drop.put(SKINTYPES[1], PurpleDrop);
        drop.put(SKINTYPES[2], PinkDrop);
        drop.put(SKINTYPES[3], RedDrop);
        drop.put(SKINTYPES[4], GoldDrop);
    }

    public static float[] getChances(){
        return CHANCES;
    } // выводим шансы

    public String getSkinType(int index){ // выводим выбитый скин
        return SKINTYPES[index];
    }

    public ArrayList<String> getSkins(String skinType){ // выводим скины выбранного типа
        return new ArrayList<>(drop.get(skinType).keySet());
    }

    public Float[] getSkinPrice(String skinType, String skin){  // выводим цены оружия (мб плохо, что я не сделал try)
        return drop.get(skinType).get(skin);
    }
}
