package Lesson4;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
// В калькулятор добавьте возможность отменить последнюю операцию.


public class Homework_4_3 {
    public static void main(String[] args) throws IOException{

        Stack<String> outputs = new Stack<>();
       
        Logger log = Logger.getLogger(Homework_4_3.class.getName());
        FileHandler fh = new FileHandler("NewCalculator.log");
        log.addHandler(fh);
        fh.setFormatter(new SimpleFormatter());
       
               
        FirstDigit(outputs);
           
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("Enter first diggit = " + outputs.get(0)));
       
        Symbol(outputs);
               
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("Enter symbol diggit = " + outputs.get(1)));
       
           
        SecondDigit(outputs);
       
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("Enter second diggit = " + outputs.get(2)));
               
        System.out.println("Ваше выражение: \n" + outputs.get(0) + " " + outputs.get(1) + " " + outputs.get(2));
               
       
        int number = Integer.parseInt(outputs.get(0));
        int numberOne = Integer.parseInt(outputs.get(2));
       
        switch (outputs.get(1)){
        case "+":
        int result = number + numberOne;
        System.out.println("= " + result);
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("= " + result));
        break;
        case "-":
        int result1 = number - numberOne;
        System.out.println("= " + result1);
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("= " + result1));
        break;
        case "*":
        int result2 = number * numberOne;
        System.out.println("= " + result2);
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("= " + number + " * " + numberOne));
        break;
        case "/":
        if (numberOne != 0){
        int result3 = number / numberOne;
        System.out.println("= " + result3);
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("= " + number + " / " + numberOne));
        break;
                       }
        else {
        System.out.println("Are you trying to divide by" + numberOne);
        log.setLevel(Level.INFO);
        log.log(Level.WARNING, String.format("divide by" + numberOne));
        break;
                       }
       
               }
           
           }
        private static void FirstDigit(Stack<String> nums) {
        System.out.println("Введите, пожалуйста, первое число: ");
        Scanner scan = new Scanner(System.in);
        String number = scan.next();
        nums.add(number);
               
           }
        private static void Symbol(Stack<String> nums) {
        System.out.println("Введите, пожалуйста, операцию, которую хотели-бы произвести(+, -, *, /) или '<', если хотите отменить оперцию ");
        Scanner scan = new Scanner(System.in);
        String Symb = scan.next();
               
        while (Symb.equals("<")) {
        nums.pop();
        FirstDigit(nums);
        System.out.println("Введите, пожалуйста, операцию, которую хотели-бы произвести(+, -, *, /) или '<', если хотите отменить оперцию ");
        Symb = scan.next();
               }
        nums.add(Symb);
           }
           
           private static void SecondDigit(Stack<String> nums) {
               Scanner scan = new Scanner(System.in);
               System.out.println("Введите, пожалуйста, второе число: или '<', если хотите отменить оперцию ");
               String numberOne = scan.next();
               
               while (numberOne.equals("<")) {
                   nums.pop();
                   Symbol(nums);
                   System.out.println("Введите, пожалуйста, второе число: или '<', если хотите отменить оперцию ");
                   numberOne = scan.next();
               }
               nums.add(numberOne);
       }
}
  