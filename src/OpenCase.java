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
                        " раз (Пример: 123.45)\nВведите сумму: ");
                float curScanner = scanner.nextFloat();
                if (curScanner <= 0) throw new IllegalArgumentException("Ошибка ввода, сумма не может быть" +
                        " отрицательной, введите сумму еще раз (Пример: 123.45)\nВведите сумму: ");
                inventory = new Inventory(curScanner, spectrum); // деньги хранятся в инвентаре
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
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

                    } else if (response.equalsIgnoreCase("нет")) { // тут надо прописать продажу скина и если не хочет, то выход из программы
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
                        System.out.println("На вашем счету недостаточно средств...");
                        break open;
                    }
                }
            }
        }
        System.out.println("Спасибо что открывали кейс. Удачи!");
    }

    // добавить бы еще проверку на то, что у чела нет денег и нет оружия в инвентаре и сразу выход из игры в случае чего
    private static boolean checkInventory(Inventory inventory){ // тут надо прописать проверку инвентаря и продажу скинов или еще как то, я пока не продумал
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Хотите ли посмотреть инвентарь и продать ненужные скины? (Варианты ответа: Да, Нет)");
            String strAnswer = scanner.next();
            if (strAnswer.equalsIgnoreCase("да")) {
                System.out.println("Ваши оружия:");
                inventory.getSkins();
                System.out.println("Напишите индекс скина, который хотите продать."); //тут доделать продажу скинов
                return true;
            } else if (strAnswer.equalsIgnoreCase("нет")) {
                return false;
            } else {
                System.out.println("Извините, я не понял, что вы написали. Повторите ответ.");
            }
        }
    }
}
