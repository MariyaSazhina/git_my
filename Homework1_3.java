

// Реализовать простой калькулятор (+ - / *)
// Ввод числа ->
// Ввод знака ->
// Ввод числа ->


import java.util.Scanner;
public class Homework1_3  {
   static Scanner scanner =  new Scanner(System.in);
   public static void main(String[] args) {
      int num1 = getInt();
      int num2 = getInt();
      char operation = getOperation();
      int result = calc(num1, num2, operation);
      System.out.println("Результат операции: " + result);
   }
   public static int getInt() {
      System.out.println("Ввод числа => ");
      int num;
      if(scanner.hasNextInt()) {
         num = scanner.nextInt();
      } else {
         System.out.println("Вы совершили ошибку, попробуйте еще раз!");
         scanner.next();
         num = getInt();
      }
      return num;
   }
   public static char getOperation() {
      System.out.println("Ввод знака => ");
      char operation;
      if(scanner.hasNext()) {
         operation = scanner.next().charAt(0);
      }else {
         System.out.println("Вы совершили ошибку, попробуйте еще раз!");
         scanner.next();
         operation = getOperation();
      }
      return operation;
   }
   public static int calc(int num1, int num2, char operation) {
      int result;
      switch(operation) {
         case '+':
         result = num1 + num2;
         break;
         case '-':
         result = num1 - num2;
         break;
         case '*':
         result = num1 * num2;
         break;
         case '/':
         result = num1 / num2;
         break;
         default:
         System.out.println("Операция не прошла, проверьте правильность ввода!");
         result = calc(num1, num2, getOperation());
      }
      return result;
   }
}
   