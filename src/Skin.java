public class Skin { // тут будут храниться цена, флот, название скина

    Skin(String skinName, float skinFloat, float skinPrice){
        this.skinName = skinName;
        this.skinFloat = skinFloat;
        this.skinPrice = skinPrice;
    }

    private String skinName;
    private float skinFloat;
    private float skinPrice;

    public String getSkinName(){
        return skinName;
    }

    public float getSkinFloat(){
        return skinFloat;
    }

    public float getSkinPrice(){
        return skinPrice;
    }


}
