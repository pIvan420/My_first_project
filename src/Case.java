import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class Case{
    private Map<String, Map<String, Float[]>> drop = createDrop();

    private static final float[] chance = { 0.7992f, 0.1598f, 0.0320f, 0.0064f, 0.0026f }; // шанс выпадения

    private static float[] getChance(){
        return chance;
    }

    public ArrayList<String> getSkinType(){
        return ;
    }


    // виды выпадаемого оружия
    private Map<String, Map<String, Float[]>> createDrop() {
        Map<String, Map<String, Float[]>> drop = new HashMap<>();
        drop.put("Blue", createBlueDrop());
        drop.put("Purple", createPurpleDrop());
        drop.put("Pink", createPinkDrop());
        drop.put("Red", createRedDrop());
        drop.put("Gold", createGoldDrop());
        return drop;
    }

    Map<String, Float[]> createBlueDrop() {
        Map<String, Float[]> drop = new HashMap<>();
        return drop;
    }

    Map<String, Float[]> createPurpleDrop() {
        Map<String, Float[]> drop = new HashMap<>();
        return drop;
    }

    Map<String, Float[]> createPinkDrop() {
        Map<String, Float[]> drop = new HashMap<>();
        return drop;
    }

    Map<String, Float[]> createRedDrop() {
        Map<String, Float[]> drop = new HashMap<>();
        return drop;
    }

    Map<String, Float[]> createGoldDrop() {
        Map<String, Float[]> drop = new HashMap<>();
        return drop;
    }
}
