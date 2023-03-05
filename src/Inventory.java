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

    /*
    происходит открытие кейса, где выбираем по шансам тип скинов, потом рандомно скин
    потом рандомно флот, потом рандомно цену (цену в кс определяет рынок, но тут я буду это делать своей логикой)
    после чего кладу оружие в инвентарь
     */
    public void openCase(){
        Skin skin;

    }

    private String getRandomWeapon(){
        Random random = new Random();
        float randomValue = random.nextFloat();
        float sum = 0;
        for (int i = 0; i < Spectrum.getChance().length; i++){
            sum += Spectrum.getChance()[i];
            if (randomValue < sum){
                return skinType.get(i);
            }
        }
        return skinType.get(-1);
    }

    private float getPrice(float weaponFloat, float[] weaponPrice){
        return ((weaponFloat * (weaponPrice[1] - weaponPrice[0])) + weaponPrice[0]);
    }

    private Map<String, Float> getRandom(){
        String skinType = getRandomWeapon();
        Map<String, Float[]> skin = getRandomSkin(skinType);
    }

    private Map<String, Float[]> getRandomSkin(String skinType){
        Random random = new Random();
        List<String> skins = new ArrayList<>(Spectrum.getDrop().get(skinType).keySet());
        int randomIndex = random.nextInt(skins.size());
        String skin = skins.get(randomIndex);

    }


}
