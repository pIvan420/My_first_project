public class Skin { // тут будут храниться цена, флот, название скина

    Skin(String skinName, Float skinFloat, Float skinPrice){
        this.skinName = skinName;
        this.skinFloat = skinFloat;
        this.skinPrice = skinPrice;
    }

    private String skinName;
    private Float skinFloat;
    private Float skinPrice;

    public String getSkinName(){
        return skinName;
    }

    public Float getSkinFloat(){
        return skinFloat;
    }

    public Float getSkinPrice(){
        return skinPrice;
    }


}
