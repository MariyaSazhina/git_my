import java.util.Scanner;

// Вычислить n-ое треугольного число(сумма чисел от 1 до n), а так же n! (произведение чисел от 1 до n)
// Ввод:5
// Треугольное число 1 + 2 + 3 + 4 + 5 = 15
// n! 1 * 2 * 3 * 4 * 5 = 120
public class Homework1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число: ");
        int number = sc.nextInt();
        System.out.printf("Треугольное число: %d\n", giveMeNumber(number));
        System.out.printf("Произведение чисел: %d\n", getFactorial(number));
        sc.close();
    }
    public static int giveMeNumber(int a) {
        return (a * (a + 1)) / 2;
    }
    public static int getFactorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
           result = result * i;
        }
        return result;
}
}



