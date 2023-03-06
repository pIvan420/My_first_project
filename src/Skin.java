public class Skin { // тут будут храниться цена, флот, название скина

    Skin(String skinType, String skinName, Float skinFloat, Float skinPrice, boolean isStarTrack){
        this.skinType = skinType;
        this.skinName = skinName;
        this.skinFloat = skinFloat;
        this.skinPrice = skinPrice;
        this.isStarTrack = isStarTrack;
    }

    private String skinType;
    private String skinName;
    private Float skinFloat;
    private Float skinPrice;

    private boolean isStarTrack;

    public String getSkinType() {
        return skinType;
    }

    public String getSkinName(){
        return (isStarTrack ? skinName + " ★StarTrack★" : skinName);
    }

    public Float getSkinFloat(){
        return skinFloat;
    }

    public Float getSkinPrice(){
        return skinPrice;
    }


}
