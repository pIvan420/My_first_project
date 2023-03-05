import java.util.*;

public abstract class Case{
    private Map<String, Map<String, Float[]>> drop;

    private static final float[] chance = { 0.7992f, 0.1598f, 0.0320f, 0.0064f, 0.0026f }; // шанс выпадения

    public static float[] getChance(){
        return chance;
    }

    public Set<String> getSkinType(){
        return drop.keySet();
    }

    Case(Map<String, Float[]> BlueDrop,
         Map<String, Float[]> PurpleDrop,
         Map<String, Float[]> PinkDrop,
         Map<String, Float[]> RedDrop,
         Map<String, Float[]> GoldDrop){
        drop.put("Blue", BlueDrop);
        drop.put("Purple", PurpleDrop);
        drop.put("Pink", PinkDrop);
        drop.put("Red", RedDrop);
        drop.put("Gold", GoldDrop);
    }
}
