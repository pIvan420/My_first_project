import java.util.*;


// тут инвентарь игрока, вся логика прописана тут
public class Inventory {

    private float sum; // деньги на счете
    private ArrayList<Skin> inventory = new ArrayList<>(); // скины в инветаре
    private Case caseType; // какой кейс открываем (пока только спектр, так что только он)

    Inventory(float sum, Case caseType){
        this.sum = sum;
        this.caseType = caseType;
    }

    public float getSum(){
        return sum;
    }


    // кладу скин в инвентарь и передаю его в класс OpenCase
    public Skin openCase(){
        Skin skin = getSkin();
        inventory.add(skin);
        return skin;
    }

    /*
    происходит открытие кейса, где выбираем по шансам тип скинов, потом рандомно скин
    потом рандомно флот, потом рандомно цену (цену в кс определяет рынок, но тут я буду это делать своей логикой)
    */
    private Skin getSkin(){
        String skinType = getRandomWeaponType();
        String skin = getRandomSkin(skinType);
        Float[] prices = caseType.getSkinPrice(skinType, skin);
        Float skinFloat = getSkinFloat();
        Float skinPrice = getPrice(skinFloat, prices);
        return new Skin(skin, skinFloat, skinPrice);
    }

    // выбираем тип оружия
    private String getRandomWeaponType(){
        Random random = new Random();
        float randomValue = random.nextFloat();
        float sum = 0;
        for (int i = 0; i < Spectrum.getChances().length; i++){
            sum += Spectrum.getChances()[i];
            if (randomValue < sum){
                return caseType.getSkinType(i);
            }
        }
        return caseType.getSkinType(-1);
    }

    // тут цена скина
    private float getPrice(Float weaponFloat, Float[] weaponPrice){
        return ((weaponFloat * (weaponPrice[1] - weaponPrice[0])) + weaponPrice[0]);
    }


    // тут флот скина
    private Float getSkinFloat(){
        return (float) Math.random();
    }


    // Выбираем скин при готовом типе
    private String getRandomSkin(String skinType){
        Random random = new Random();
        List<String> skins = caseType.getSkins(skinType);
        int randomIndex = random.nextInt(skins.size());
        return skins.get(randomIndex);
    }


}
