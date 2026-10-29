import java.util.Locale;
import java.util.Scanner;

public class Task5 {

    static final Scanner scanner = new Scanner(System.in);

    static void printMenu() {
        System.out.println();
        System.out.println("=== ГЛАВНОЕ МЕНЮ ===");
        System.out.println("1 - Выполнить расчёт");
        System.out.println("2 - Информация о программе");
        System.out.println("3 - Информация о разработчике");
        System.out.println("0 - Выход");
        System.out.print("Ваш выбор: ");
    }

    static void printProgramInfo() {
        System.out.println(
                "Программа вычисляет кинетическую энергию: E = m * v^2 / 2."
        );
        System.out.println("Масса вводится в кг (> 0).");
        System.out.println("Скорость вводится в м/с (>= 0).");
        System.out.println("Для отмены ввода введите q.");
    }

    static void printDeveloperInfo() {
        System.out.println("Разработчик: Байнов Иван Алексеевич");
    }

    // Методы проверки.
    static boolean isValidMass(double mass) {
        return Double.isFinite(mass) && mass > 0;
    }

    static boolean isValidSpeed(double speed) {
        return Double.isFinite(speed) && speed >= 0;
    }

    // Ввод числа. null означает отмену.
    static Double readNumber(String prompt) {
        while (true) {
            System.out.println(prompt + " (или q для отмены):");
            String line = scanner.nextLine().trim();

            if (line.equalsIgnoreCase("q")) {
                return null;
            }

            try {
                double value = Double.parseDouble(
                        line.replace(',', '.')
                );

                if (Double.isFinite(value)) {
                    return value;
                }

                System.out.println("Ошибка: введите конечное число.");
            } catch (NumberFormatException e) {
                System.out.println(
                        "Ошибка: введите число, например 12.5."
                );
            }
        }
    }

    static Double readMass() {
        while (true) {
            Double mass = readNumber("Введите массу тела m (кг)");

            if (mass == null) {
                return null;
            }

            if (isValidMass(mass)) {
                return mass;
            }

            System.out.println(
                    "Ошибка: масса должна быть строго больше нуля."
            );
        }
    }

    static Double readSpeed() {
        while (true) {
            Double speed = readNumber("Введите скорость тела v (м/с)");

            if (speed == null) {
                return null;
            }

            if (isValidSpeed(speed)) {
                return speed;
            }

            System.out.println(
                    "Ошибка: скорость не может быть отрицательной."
            );
        }
    }

    // Ввод параметров и сохранение их в массиве.
    static double[] readParameters() {
        Double mass = readMass();

        if (mass == null) {
            return null;
        }

        Double speed = readSpeed();

        if (speed == null) {
            return null;
        }

        double[] parameters = {mass, speed};
        return parameters;
    }

    // Вычисление по параметрам из массива.
    static double kineticEnergy(double[] parameters) {
        double mass = parameters[0];
        double speed = parameters[1];

        return mass * speed * speed / 2.0;
    }

    // Вывод исходных данных и результата.
    static void printResult(double[] parameters, double energy) {
        System.out.println("Результаты расчёта:");
        System.out.printf("Масса: %.2f кг%n", parameters[0]);
        System.out.printf("Скорость: %.2f м/с%n", parameters[1]);
        System.out.printf("Кинетическая энергия: %.2f Дж%n", energy);
    }

    // Организация ввода, вычисления и вывода.
    static void runCalculation() {
        double[] parameters = readParameters();

        if (parameters == null) {
            System.out.println("Ввод отменён, возврат в меню.");
            return;
        }

        double energy = kineticEnergy(parameters);

        // Даже конечные числа при умножении могут дать переполнение.
        if (!Double.isFinite(energy)) {
            System.out.println(
                    "Ошибка: результат слишком велик для типа double."
            );
            System.out.println(
                    "Повторите расчёт с меньшими значениями."
            );
            return;
        }

        printResult(parameters, energy);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.out.println("Калькулятор кинетической энергии.");

        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    runCalculation();
                    break;

                case "2":
                    printProgramInfo();
                    break;

                case "3":
                    printDeveloperInfo();
                    break;

                case "0":
                    running = false;
                    break;

                default:
                    System.out.println(
                            "Неизвестный пункт меню, введите 0, 1, 2 или 3."
                    );
            }
        }

        System.out.println("Программа завершена.");
    }
}