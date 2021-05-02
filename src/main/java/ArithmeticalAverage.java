import java.util.Scanner;

public class ArithmeticalAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начало диапазона -  целое число :");
        int startNumber = scanner.nextInt();

        System.out.println("Введите конец диапазона, второе целое число :");
        int finishNumber = scanner.nextInt();

        if (startNumber > finishNumber) { // fix incorrect input
            int temp = finishNumber;
            finishNumber = startNumber;
            startNumber = temp;
        }

        int evenNumbersSum = 0;
        int oddNumbersSum;
        int allNumbersSum = 0;
        int count = 0;
        int evenCount = 1;
        int temp = startNumber;

        while (temp <= finishNumber) {
            allNumbersSum = allNumbersSum + temp;

            if (temp % 2 == 0) {
                evenNumbersSum = evenNumbersSum + temp;
                evenCount++;
            }
            temp++;
            count++;
        }

        if (allNumbersSum == finishNumber) {
            allNumbersSum *= 2;
            evenNumbersSum *= 2;
            count *= 2;
        } else {
            evenCount -= 1;
        }
        oddNumbersSum = allNumbersSum - evenNumbersSum;

        printInfo(startNumber, finishNumber, evenNumbersSum, oddNumbersSum,
                allNumbersSum, count, evenCount);
    }

    static void printInfo(int startNumber, int finishNumber, int evenNumbersSum, int oddNumbersSum,
                          int allNumbersSum, int count, int evenCount) {
        System.out.printf("Сумма всех целых чисел от %d до %d равна:%n", startNumber, finishNumber);
        System.out.println(allNumbersSum);

        System.out.printf("Сумма всех четных целых чисел от %d до %d равна:%n", startNumber, finishNumber);
        System.out.println(evenNumbersSum);

        System.out.printf("Сумма всех нечетных целых чисел от %d до %d равна:%n", startNumber, finishNumber);
        System.out.println(oddNumbersSum);

        double allNumberAverage = (double) allNumbersSum / count;
        System.out.printf("Среднее арифметическое всех целых чисел от %d до %d равно:%n", startNumber, finishNumber);
        System.out.println(allNumberAverage);

        double evenNumbersAverage = (evenCount == 0) ? 0 : (double) evenNumbersSum / evenCount;
        System.out.printf("Среднее арифметическое всех четных чисел от %d до %d равно:%n", startNumber, finishNumber);
        System.out.println(evenNumbersAverage);
    }
}