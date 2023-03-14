import java.util.InputMismatchException;
import java.util.Scanner;


// тут интерфейс консольный для открытия
public class OpenCase {
    public static void start(){
        Scanner scanner;
        Inventory inventory;
        Case spectrum = new Spectrum();
        System.out.print("Привет, это открытие кейса \"Спектр\" из Cs:Go\nСколько денег вы положите на счет?\nВведите сумму: ");
        while (true){ // кладем деньги на счет
            try{ // защита от дурака на случай ввода строки или отрицательного числа
                scanner = new Scanner(System.in);
                if (!scanner.hasNextFloat()) throw new IllegalArgumentException("Ошибка ввода, введите сумму еще" +
                        " раз (Пример: 123,45)\nВведите сумму: ");
                float curScanner = scanner.nextFloat();
                if (curScanner <= 0) throw new IllegalArgumentException("Ошибка ввода, сумма не может быть" +
                        " отрицательной, введите сумму еще раз (Пример: 123,45)\nВведите сумму: ");
                if (String.valueOf(curScanner).split("\\.")[1].length() > 2) throw new IllegalArgumentException("Ошибка ввода, " +
                        "после запятой идет максимум 2 знака, введите сумму еще раз (Пример: 123,45)\nВведите сумму: ");
                inventory = new Inventory(curScanner, spectrum); // деньги хранятся в инвентаре
                break;
            }catch (IllegalArgumentException e){
                System.out.print(e.getMessage());
            }
        }
        System.out.println("Сумма была положена на счет.");
        open: // именованный блок для выхода из всех циклов (их тут оч много и все для защиты от дурака, да и сделаны костыльно)
        {
            while (true) { // тут спрашиваю у игрока, хочет он открывать или нет
                if (inventory.getSum() >= inventory.getKeyPrice()) { // проверка, хватает ли денег
                    System.out.println("Открываем? (Варианты ответа: Да, Нет)");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("да")) { // если да, то работаем с OpenCase
                        try {
                            System.out.println("Открываем!");
                            Thread.sleep(1000);
                            System.out.println("Иии вам выпало...");
                            Thread.sleep(2000);
                            Skin skin = inventory.openCase();
                            System.out.println(skin);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    } else if (response.equalsIgnoreCase("нет")) {
                        checkInventory(inventory);
                        System.out.println("Хотите ли продолжить открывать кейсы?");
                        while (true) {
                            String answer = scanner.next();
                            if (answer.equalsIgnoreCase("да")) break;
                            else if (answer.equalsIgnoreCase("нет")) break open;
                            else System.out.println("Извините, я не понял, что вы написали. Продолжим открывать кейс?");
                        }
                    } else {
                        System.out.println("Извините, я не понял, что вы написали. Будем открывать кейс? (Варианты ответа: Да, Нет)");
                    }
                } else {
                    System.out.println("Извините, но вам не хватает на открытие кейса. Ваш баланс: " + inventory.getSum()); // написать, если не хватает денег, то можно продавать скины из инвентаря
                    boolean answer = checkInventory(inventory);
                    if (answer) {
                        System.out.println("Хорошо, продолжаем");
                    } else {
                        System.out.println("На вашем счету недостаточно средств, придется завершать игру...");
                        break open;
                    }
                }
            }
        }
        System.out.println("Спасибо что открывали кейс. Удачи!");
    }

    // тут идет просмотр инвентаря и продажа оружий из него
    private static boolean checkInventory(Inventory inventory){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Хотите ли посмотреть инвентарь и продать ненужные скины? (Варианты ответа: Да, Нет)");
            String strAnswer = scanner.next();
            if (strAnswer.equalsIgnoreCase("да")) {
                while (true) { // цикл нужен для продажи оружий несколько раз
                    System.out.println("Ваши оружия:");
                    try {
                        inventory.getSkins();
                    } catch (
                            InventoryIsNull e) { // тут прописана проверка при пустом инвентаре, если деньги на счете еще есть, то открываем дальше, если нет, то
                        System.out.println(e.getMessage()); // принудительно завершаем
                        if (inventory.getSum() < inventory.getKeyPrice()) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                    System.out.println("Напишите индекс скина, который хотите продать.");
                    while (true) {
                        try { // тут пиздец костыли, оно с хуято не читает нужные строки, я не ебу почему, а разбираться в падлу, так шо пусть так
                            scanner = new Scanner(System.in); // просто защита от дурака, ввел ли он строку или число, но работало оно через жопу
                            int curIndex;
                            if (scanner.hasNextInt()) {
                                curIndex = scanner.nextInt();
                            } else throw new IllegalArgumentException("Ошибка ввода, введите индекс скина.");
                            inventory.sellSkin(curIndex);
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println("Хотите еще продать оружия?");
                    String sellAgain = scanner.next();
                    if (sellAgain.equalsIgnoreCase("да")){
                        System.out.println("Продолжаем!");
                    }
                    else {
                        System.out.println("Будем считать, что нет"); // я рот ебал прописывать эту ЗоД
                        break;
                    }

                }
                return true;
            } else if (strAnswer.equalsIgnoreCase("нет")) {
                return false;
            } else {
                System.out.println("Извините, я не понял, что вы написали. Повторите ответ.");
            }
        }
    }
}
