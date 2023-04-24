import Classes.Toy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        // Очищаем старый файл призов, либо создаём новый пустой файл
        try (FileWriter writer = new FileWriter("prizes.txt", false);) {
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        // Инициализация списка игрущек для розыгрыща
        ArrayList<Toy> arrayOfToys = new ArrayList<Toy>();
        arrayOfToys.add(new Toy(1, "Мнушка голубь", 1, 10));
        arrayOfToys.add(new Toy(2, "Ёжик", 2, 20));
        arrayOfToys.add(new Toy(3, "Машина пожарная", 1, 5));
        arrayOfToys.add(new Toy(4, "Робот", 1, 30));

        // Сортируем список для получения самого вероятного выигрыша
        arrayOfToys.sort((o1, o2) -> (o2.getWeight() - o1.getWeight()));

        // Инициализация списка призов
        ArrayList<Toy> arrayOfWinners = new ArrayList<Toy>();

        // Определяем победителей

        int numberOfWinners = 10;
        int maxWinners = getMaxWinners(arrayOfToys);

        for (int i = 0; i < Math.min(numberOfWinners, maxWinners); i++) {
            Toy winner = getToy(arrayOfToys);
            if (winner == null) {
                System.out.println("Призы закончились!");
                break;
            } else {
                arrayOfWinners.add(winner);
            }
        }

        // Выводим на экран список призов
        arrayOfWinners.forEach(toy -> toy.print());

        // Выдача призов
        giveToy(arrayOfWinners);
        giveToy(arrayOfWinners);
        giveToy(arrayOfWinners);
        giveToy(arrayOfWinners);
        giveToy(arrayOfWinners);
        giveToy(arrayOfWinners);
        giveToy(arrayOfWinners);

    }

    // Максимальное количество победителей, чтобы не выдать больше, чем есть
    public static int getMaxWinners(ArrayList<Toy> toyArrayList) {
        return toyArrayList.stream().mapToInt(Toy::getQuantity).sum();
    }

    // Проверка совпадения ID
    public static boolean checkToy (int id, ArrayList<Toy> toyArrayList) {
        if (toyArrayList.size() == 0) {
            return false;
        }
        for (Toy toy: toyArrayList) {
            if (toy.getId() == id) {
                return true;
            }
        }
        return false;
    }

    // Изменение веса игрущки
    public static void changeWeight(ArrayList<Toy> toyArrayList) {

        Scanner in = new Scanner(System.in);

        if (toyArrayList.size() == 0) {
            System.out.println("Список призов пуст!");
            return;
        }

        while (true) {
            System.out.println("Введите id игрущки: ");
            int idToChange = in.nextInt();

            for (int i = 0; i < toyArrayList.size(); i++) {
                if (toyArrayList.get(i).getId() == idToChange) {
                    Toy currToy = toyArrayList.get(i);
                    currToy.print();

                    int weight = 0;
                    while (weight <= 0) {
                        System.out.println("Введите новый вес: ");
                        weight = in.nextInt();
                    }

                    currToy.setWeight(weight);
                    return;

                }
            }

            System.out.println("ID игрущки не найдено, повторите ввод ID");

        }


    }

    // Добавляем игрущку в список
    public static void addToy (ArrayList<Toy> toyArrayList) {

        Scanner in = new Scanner(System.in);

        // Проверяем на совпадение id
        int id;
        while (true) {
            System.out.println("Введите ID игрушки:");
            id = in.nextInt();
            if (checkToy(id, toyArrayList) == false) {
                break;
            }
        }

        // Проверяем на пустую строку в наименовании
        String name = "";
        while (name.isEmpty()) {
            System.out.println("Введите название:");
            name = in.nextLine();
        }

        // Количество больше нуля
        int quantity = 0;
        while (quantity <= 0) {
            System.out.println("Введите количество: ");
            quantity = in.nextInt();
        }

        // Вес больше нуля
        int weight = 0;
        while (weight <= 0) {
            System.out.println("Введите вес: ");
            weight = in.nextInt();
        }

        toyArrayList.add(new Toy(id, name, quantity, weight));

    }

    // Определение призов из списка
    public static Toy getToy(ArrayList<Toy> toyArrayList) {

        // Получаем сумму всего веса из призов
        int sumOfWeight = 0;
        // Список весов, понадобится для определения минимального веса для случайного числа
        ArrayList<Integer> arrayOfWeights = new ArrayList<Integer>();

        // Проверяем на остаток игрушек, отбираем только те, что есть на остатке
        for (int i = 0; i < toyArrayList.size(); i++) {
            if (toyArrayList.get(i).getQuantity() > 0) {
                int currWeight = toyArrayList.get(i).getWeight();
                sumOfWeight += currWeight;
                arrayOfWeights.add(currWeight);
            }
        }

        // Определим минимальный вес
        int minWeight = Collections.min(arrayOfWeights);

        // Случайное число + минимальный вес, чтобы не было случайного числа меньше минимального веса
        Random random = new Random();
        int randomSeed = random.nextInt(sumOfWeight)  + minWeight;

        // Так как список отсортирован, проходим по нему от максимального веса к минимальному
        for (int i = 0; i < toyArrayList.size(); i++) {

            // Учитываем остаток призов
            if ((randomSeed - toyArrayList.get(i).getWeight() >= 0) && (toyArrayList.get(i).getQuantity() > 0)) {
                Toy winnerToy = toyArrayList.get(i);
                winnerToy.reduceQuantity();
                return winnerToy;
            }
        }

        // Загрушка, если для розыгрыща ничего не осталось, но есть попытка розыгрыша
        return null;

    }

    // Вылача приза
    public static void giveToy (ArrayList<Toy> toyArrayList) {

        // Проверка есть что выдавать?
        if (toyArrayList.isEmpty()) {
            System.out.println("Нет игрушек для выдачи!");
            return;
        }

        System.out.println("Игрущка: " + toyArrayList.get(0).getName() + " выдана победителю!");

        // Записываем игрущку в файл выдачи
        try (FileWriter writer = new FileWriter("prizes.txt", true);) {
            writer.write("Игрущка: " + toyArrayList.get(0).getName() + " выдана победителю!\n");
            writer.close();
            // Удалили игрущку из очереди выдачи
            toyArrayList.remove(0);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}