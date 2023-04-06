// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее ариф. из этого списка.
package Lesson3;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.round;
import static java.util.Collections.max;
import static java.util.Collections.min;
public class Homework_3 {
    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 8; i++) {
            int val = rnd.nextInt(0, 50);
            list.add(val);
        }
        System.out.printf("начальный список целых чисел %s\n", list);
        // int max = max(list);
        // int min = min(list);
        int maxItem = list.get(0);
        int minItem = list.get(0);
        int sumItems = 0;
        for (int item : list) {
            if (item > maxItem) {
                maxItem = item;
            }
            if (item < minItem) {
                minItem = item;
            }
            sumItems += item;
        }
        float average = (float)sumItems/list.size();
        // System.out.printf("Максимальный элемент при помощи max %s\n", max);
        System.out.printf("Максимальный элемент %s\n", maxItem);
        // System.out.printf("Минимальный элемент при помощи min %s\n", min);
        System.out.printf("Минимальный элемент %s\n", minItem);
        // System.out.printf("Сумма элементов %s\n", sumItems);
        System.out.printf("Среднее арифметическое %s\n", average);
    }
}
