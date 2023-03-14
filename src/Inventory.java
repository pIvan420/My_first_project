import java.util.*;


// тут инвентарь игрока, вся логика прописана тут
public class Inventory {

    private float sum; // деньги на счете

    private final float KEYPRICE = 145f;
    private ArrayList<Skin> inventory = new ArrayList<>(); // скины в инветаре
    private Case caseType; // какой кейс открываем (пока только спектр, так что только он)

    Inventory(float sum, Case caseType){
        this.sum = sum;
        this.caseType = caseType;
    }

    public float getSum(){
        return sum;
    }

    private void reduceSum() { sum -= KEYPRICE; } // при получении скина списываем деньги за ключ

    public float getKeyPrice() {
        return KEYPRICE;
    }

    // кладу скин в инвентарь и передаю его в класс OpenCase
    public Skin openCase(){
        reduceSum();
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
        boolean isStarTrack = isStarTrack();
        String skin = getRandomSkin(skinType);
        Float[] prices = caseType.getSkinPrice(skinType, skin);
        Float skinFloat = getSkinFloat();
        Float skinPrice = getPrice(skinFloat, prices, isStarTrack);
        return new Skin(skinType, skin, skinFloat, skinPrice, isStarTrack);
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
    // тут ваще пиздец, чо происходит. Я обрезаю цену до сотых через форматирование строки, но format меняет точку на запятую,
    // а потом parseFloat не может работать с запятой, так что ее надо опять менять на точку через метод replace
    private float getPrice(Float weaponFloat, Float[] weaponPrice, boolean isStarTrack){
        float price = weaponPrice[1] - (weaponFloat * (weaponPrice[1] - weaponPrice[0]));
        if (isStarTrack) price *= 1.5; // если стартрек, то буду на полтора увеличивать цену
        return Float.parseFloat(String.format("%.2f", price).replace(",", "."));
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

    private boolean isStarTrack(){
        return (Math.random() <= 0.1);
    }

    public void getSkins() throws InventoryIsNull { // фигнюха, шоб выводить скины, которые лежат в инвентаре
        if (inventory.size() == 0) throw new InventoryIsNull("Ваш инвентарь пуст");
        for (Skin skin: inventory){
            System.out.println("Индекс: " + inventory.indexOf(skin) + "\n" + skin + "\n");
        }
    }

    public void sellSkin(int index) throws IllegalArgumentException{ // тут буду продавать скины из инвентаря
        if (index < 0 || index >= inventory.size()) throw new IllegalArgumentException("Ошибка ввода, такого индекса нет, введите индекс из предложенных выше.");
        sum += inventory.remove(index).getSkinPrice();
        System.out.println("Ваш скин был продан, ваша на вашем счету " + getSum() + " рублей.");
    }


}

class InventoryIsNull extends Exception{
    public InventoryIsNull(String message){
        super(message);
    }
}
