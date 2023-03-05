import java.util.*;

public abstract class Case{
    private Map<String, Map<String, Float[]>> drop;

    private static final float[] chances = { 0.7992f, 0.1598f, 0.0320f, 0.0064f, 0.0026f }; // шанс выпадения

    private static final String[] skinTypes = {"Blue", "Purple", "Pink", "Red", "Gold"};

    Case(Map<String, Float[]> BlueDrop,
         Map<String, Float[]> PurpleDrop,
         Map<String, Float[]> PinkDrop,
         Map<String, Float[]> RedDrop,
         Map<String, Float[]> GoldDrop){
        drop = new HashMap<>();
        drop.put(skinTypes[0], BlueDrop);
        drop.put(skinTypes[1], PurpleDrop);
        drop.put(skinTypes[2], PinkDrop);
        drop.put(skinTypes[3], RedDrop);
        drop.put(skinTypes[4], GoldDrop);
    }

    public static float[] getChances(){
        return chances;
    } // выводим шансы

    public String getSkinType(int index){ // выводим выбитый скин
        return skinTypes[index];
    }

    public ArrayList<String> getSkins(String skinType){ // выводим скины выбранного типа
        return new ArrayList<String>(drop.get(skinType).keySet());
    }

    public Float[] getSkinPrice(String skinType, String skin){  // выводим цены оружия (мб плохо, что я не сделал try)
        return drop.get(skinType).get(skin);
    }
}
