# Задача №2:Петя и Катя – брат и сестра. Петя – студент, а Катя – школьница. Петя помогает Кате по математике. 
# Он задумывает два натуральных числа X и Y (X,Y≤1000), а Катя должна их отгадать. 
# Для этого Петя делает две подсказки. Он называет сумму этих чисел S и их произведение P. 
# Помогите Кате отгадать задуманные Петей числа.
# Пример:
# 4 4 -> 2 2
# 5 6 -> 2 3
S = int(input('Введите число S: '))
P = int(input('Введите число P: '))
X = 1
Y = S - X
while True:
    if (Y == S - X) and (P == X * (S - X)):
         print (X,Y)  
         break
    else:
        X += 1
        Y -= 1

# Задача №1:
# На столе лежат n монеток. Некоторые из них лежат вверх решкой, а некоторые – гербом. 
# Определите минимальное число монеток, которые нужно перевернуть, чтобы все монетки были повернуты вверх одной и той же стороной.
#  Выведите минимальное количество монет, которые нужно перевернуть.
# Пример:
# 5 -> 1 0 1 1 0
n = int(input('введите кол-во монет:'))
count = 0
max_count = 0
for i in range (n):
    m = int(input('введите 1 если монета лежит решкой и 0 если орлом:'))
    if m == 1:
        count +=1
    else:
        if  count > max_count:
            max_count = count
print (max_count)            

# Задача №3:
# Требуется вывести все целые степени двойки (т.е. числа вида 2k), не превосходящие числа N.
# Пример:
# 10 -> 1 2 4 8
# 
n = int(input('Введите число: '))
m = 0
while m < n:
    if (2 ** m > n):
        break
    else:
        print (2**m)
        m+=1