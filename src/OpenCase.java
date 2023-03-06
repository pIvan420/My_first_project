import java.util.Scanner;


// тут интерфейс консольный для открытия
public class OpenCase {
    public static void start(){
        Scanner scanner = new Scanner(System.in);
        Inventory inventory;
        Case spectrum = new Spectrum();
        System.out.print("Привет, это открытие кейса \"Спектр\" из Cs:Go\nСколько денег вы положите на счет?\nВведите сумму: ");
        while (true){ // кладем деньги на счет
            try{ // защита от дурака на случай ввода строки или отрицательного числа
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
        while (true){ // тут спрашиваю у игрока, хочет он открывать или нет
            if (inventory.getSum() >= inventory.getKeyPrice()) { // проверка, хватает ли денег
                System.out.println("Открываем? (Варианты ответа: Да, Нет)");
                String response = scanner.next();
                if (response.equals("Да")) { // если да, то работаем с OpenCase
                    try {
                        System.out.println("Открываем!");
                        Thread.sleep(1000);
                        System.out.println("Иии вам выпало...");
                        Thread.sleep(2000);
                        Skin skin = inventory.openCase();
                        System.out.println(skin.getSkinName() + "\nФлот скина: " + skin.getSkinFloat() + "\nЦена скина: " +
                                skin.getSkinPrice());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                } else if (response.equals("Нет")) { // тут надо прописать продажу скина и если не хочет, то выход из программы
                    System.out.println("Тогда до встречи! :)");
                    break;
                } else {
                    System.out.println("Извините, я не понял, что вы написали. Будем открывать кейс? (Варианты ответа: Да, Нет)");
                }
            }
            else{
                System.out.println("Извините, но вам не хватает на открытие кейса. Удачи!"); // написать, если не хватает денег, то можно продавать скины из инвентаря
                break;
            }
        }
    }
}
