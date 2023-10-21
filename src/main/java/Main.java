import java.util.Scanner;
public class Main {
    static int Guests;
    static Scanner scanner = new Scanner(System.in);

    public static int countOfGuests() {
        System.out.println("На сколько гостей необходимо разделить счет?");
        while (true) {
            if (scanner.hasNextInt()) {
                int i = scanner.nextInt();
                if (i == 1) {
                    System.out.println("Для одного гостя разбивать счёт нет необходимости. Введите другое число гостей");
                } else if (i < 1) {
                    System.out.println("Платить некому.Введите другое число гостей");
                } else {
                    Guests = i;
                    break;
                }
            } else {
                System.out.println("Введите целое число гостей");
                scanner.nextLine();
            }
        }
        return Guests;
    }
}

