import java.util.Scanner;
public class Calculate {
    class Product {
        String name;
        double price;

        void input() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите наименование товара");
            name = scanner.next();

            System.out.println("Введите стоимость товара в формате [руб,коп]");

            while (true) {
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                    if (price < 0) {
                        System.out.println("Введено недопустимое значение.Введите число больше 0 ");
                        scanner.nextLine();
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Введено недопустимое значение. Введите число больше 0");
                    scanner.nextLine();
                }
            }
        }
    }

    Product product = new Product();
    double sum = 0.00f;
    String menu = "";
    Scanner scannerAdd = new Scanner(System.in);
    int persons = Main.countOfGuests();// ссылка на число гостей из класса майн

    public void receipt() {
        while (true) {
            product.input();
            menu = menu.concat(product.name).concat("\n");
            sum = sum + product.price;
            System.out.println("Товар успешно добавлен");
            System.out.println("Чтобы завершить добавление товаров введите [Завершить].\n\nДля продолжения внесения товаров  введите любое другое значение.");

            String add = scannerAdd.next();
            if (add.equalsIgnoreCase("Завершить")) {
                System.out.println("Список товаров:\n" + menu);
                double personPay = sum / persons; // сумма на каждого человека
                if ((Math.floor(personPay) % 100 >= 11) && (Math.floor(personPay) % 100 <= 19)) {
                    String format = "Каждый гость должен: %.2f рублей";
                    System.out.println(String.format(format, personPay));
                } else if (Math.floor(personPay) % 10 > 5) {
                    String format = "Каждый гость должен: %.2f рублей";
                    System.out.println(String.format(format, personPay));
                } else if ((2 <= Math.floor(personPay) % 10) && (Math.floor(personPay) % 10 <= 4)) {
                    String format = "Каждый гость должен: %.2f рубля";
                    System.out.println(String.format(format, personPay));
                } else {
                    String format = "Каждый гость должен: %.2f рубль";
                    System.out.println(String.format(format, personPay));
                }
                break;
            }
        }
    }
}

