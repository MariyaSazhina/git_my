# Задача 30: Заполните массив элементами арифметической прогрессии. 
# Её первый элемент, разность и количество элементов нужно ввести с клавиатуры. 
# Формула для получения n-го члена прогрессии: an = a1 + (n-1) * d.
# Каждое число вводится с новой строки.
a1, d, n = int(input()), int(input()), int(input())
progressive = [a1 + (i - 1) * d for i in range(1, n + 1)]
print(*progressive)

# Задача 32: Определить индексы элементов массива (списка), значения которых принадлежат заданному диапазону
#  (т.е. не меньше заданного минимума и не больше заданного максимума)
import random

mas=[random.randint(-50, 50) for i in range(random.randint(10,20))]

print(*mas)

maxi=int(input("MAX= "))

mini=int(input("MIN= "))

masi=[]

if maxi>=mini:

   for i in range(len(mas)):

      if maxi>=mas[i] and mini<=mas[i]:

          masi.append(i)

   print("Кол-во:",len(masi))

   print("Индексы:",masi)

