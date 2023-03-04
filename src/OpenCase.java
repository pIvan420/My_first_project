import java.util.Scanner;


// тут интерфейс консольный для открытия
public class OpenCase {
    public static void start(){
        Scanner scanner;
        Inventory inventory;
        Case spectrum = new Spectrum();
        float keyPrice = 145f;
        System.out.print("Привет, это открытие кейса \"Спектр\" из Cs:Go\nСколько денег вы положите на счет?\nВведите сумму: ");
        while (true){ // кладем деньги на счет
            scanner = new Scanner(System.in);
            if (scanner.hasNextFloat()){
                inventory = new Inventory(scanner.nextFloat(), spectrum); // деньги хранятся в инвентаре
                break;
            }
            else{
                System.out.print("\nОшибка ввода, введите сумму еще раз (Пример: 123.45)\nВведите сумму: ");
            }
        }
        System.out.println("\nСумма была положена на счет.");
        while (true){ // тут спрашиваю у игрока, хочет он открывать или нет
            if (inventory.getSum() >= keyPrice) {
                System.out.println("Открываем? (Варианты ответа: Да, Нет)");
                scanner = new Scanner(System.in);
                if (scanner.toString().equals("Да")) { // если да, то работаем с OpenCase
                    try {
                        System.out.println("Открываем!");
                        Thread.sleep(1000);
                        System.out.println("Иии вам выпало...");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                } else if (scanner.toString().equals("Нет")) {
                    System.out.println("Тогда до встречи! :)");
                    break;
                } else {
                    System.out.println("Извините, я не понял, что вы написали. Будем открывать кейс? (Варианты ответа: Да, Нет)");
                }
            }
            else{
                System.out.println("Извините, но вам не хватает на открытие кейса. Удачи!");
                break;
            }
        }
    }
}
