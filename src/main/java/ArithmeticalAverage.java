import java.util.Scanner;

public class ArithmeticalAverage {
    public static void main(String[] args) {
        System.out.println("Введите диапазон - два целых числа через пробелы (например: -5  132 ):");

        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine().trim();

        String[] inputVariables = inputLine.trim().split("\\s+");
        inputVariables[0] = inputVariables[0].trim();
        inputVariables[1] = inputVariables[1].trim();

        int firstNumber = 0;
        int secondNumber = 0;

        try {
            firstNumber = Integer.parseInt(inputVariables[0]);
            secondNumber = Integer.parseInt(inputVariables[1]);
        } catch (Exception e) {
            System.out.println("Неверный ввод, программа завершена.");
            System.exit(0);
        }

        if (firstNumber > secondNumber) { //the smaller of the two entered numbers, put at the beginning of the range
            firstNumber ^= secondNumber;
            secondNumber ^= firstNumber;
            firstNumber ^= secondNumber;
        }

        int countNumbers = (firstNumber == secondNumber) ? 2 : Math.abs(firstNumber - secondNumber) + 1;

        int allEvenNumbersSum = 0;
        int allOddNumbersSum = 0;
        int allNumbersSum = 0;

        if (firstNumber == secondNumber) {
            allNumbersSum = firstNumber + secondNumber;
            allEvenNumbersSum = (firstNumber % 2 == 0) ? (firstNumber + secondNumber) : 0;
            allOddNumbersSum = (firstNumber % 2 != 0) ? (firstNumber + secondNumber) : 0;
        } else {

            for (int i = 0; i <= countNumbers - 1; i++) {
                allNumbersSum += i + firstNumber;

                if ((firstNumber + i) % 2 != 0) {
                    allOddNumbersSum += firstNumber + i;
                } else {
                    allEvenNumbersSum += firstNumber + i;
                }
            }
        }

        System.out.printf("Сумма всех целых чисел от %d до %d равна:%n", firstNumber, secondNumber);
        System.out.println(allNumbersSum);

        System.out.printf("Сумма всех четных целых чисел от %d до %d равна:%n", firstNumber, secondNumber);
        System.out.println(allEvenNumbersSum);

        System.out.printf("Сумма всех нечетных целых чисел от %d до %d равна:%n", firstNumber, secondNumber);
        System.out.println(allOddNumbersSum);

        double allNumberArithmeticalAverageValue = (double) allNumbersSum / countNumbers;
        System.out.printf("Среднее арифметическое всех целых чисел от %d до %d равно:%n", firstNumber, secondNumber);
        System.out.println(allNumberArithmeticalAverageValue);
    }
}