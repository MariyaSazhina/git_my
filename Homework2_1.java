import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

// Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
// результат после каждой итерации запишите в лог-файл.
public class Homework2_1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите кол-во элементов массива: ");
        int size = sc.nextInt();;
        int [] arr = new int [size];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Введите элемент массива: ");
            arr[i] = sc.nextInt();
        }
        sc.close();
        int temp;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                sb.append(Arrays.toString(arr)).append("\n");
                try {
                    FileWriter fw = new FileWriter("homework2_1.txt", false);
                    fw.write(sb.toString());
                    fw.close();
                } catch (Exception e) {
                    System.out.println("ERROR!");
                }  
            }
        }
    }
    }
   
    

