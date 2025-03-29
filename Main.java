import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;
        boolean flag = true;

        while (flag) {
            System.out.println("Выберите операцию и введите её номер:\n" +
                    "1. Добавить новый доход\n" +
                    "2. Добавить новый расход\n" +
                    "3. Выбрать систему налогообложения");


            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String moneyStr2 = scanner.nextLine();
                    int money2 = Integer.parseInt(moneyStr2);
                    spendings = spendings + money2;
                    break;
                case 3:
                    int usn6 = taxEarnings(earnings, spendings);
                    int usn15 = taxEarningsMinusSpendings(earnings, spendings);

                    if (usn6 < usn15) {
                        System.out.println("Мы советуем вам УСН доходы\n" +
                                "Ваш налог составит: "+usn6+ " рублей\n" +
                                "Налог на другой системе: "+usn15+ " рублей\n" +
                                "Экономия: "+(usn15-usn6)+ " рублей");
                    } else {
                        System.out.println("Мы советуем вам УСН доходы минус расходы\n" +
                                "Ваш налог составит: "+usn15+ " рублей\n" +
                                "Налог на другой системе: "+usn6+ " рублей\n" +
                                "Экономия: "+(usn6-usn15)+ " рублей");
                    }
                    flag = false;

                    break;


                default:
                    System.out.println("Такой операции нет");
            }
        }

        System.out.println("Программа завершена!");
    }

    public static int taxEarnings(int earnings, int spendings) {
        int tax = earnings * 6 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            // если расходы оказались больше, то налог посчитается отрицательным
            return 0;
        }
    }


}