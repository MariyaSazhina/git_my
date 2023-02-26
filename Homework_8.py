def reed_contact(): # список всех контактов
  with open('new.txt', 'r', encoding='utf8') as file:
    for line in file:
      print(line)

def find_contaсt(name): # поиск контакта
  with open ('new.txt', 'r', encoding='utf8') as file:
    for line in file:
      if name in line:
        print(line)
        break

def add_contact (): # добавление контакта
  with open('new.txt', 'a', encoding='utf8') as file:
    file.write('\n')
    file.write(input('Введите Имя, Фамилию или номер телефона нового контакта: '))
    print('Новый контакт добавлен')

def edit_contact(word): # редактирование контакта
  with open ('new.txt', 'r',  encoding='utf8') as file:
   lines = file.read()
   new_word = (input('Введите Имя, Фамилию или номер телефона: '))
   new_data = lines.replace(word, new_word)
  with open ('new.txt', 'w') as file:
   file.write(new_data)
   print('Контакт оредактирован')


def del_contact(name_3): #удаление контакта
  while True:
     with open('new.txt', 'r', encoding='utf8') as file:
       lines = file.readlines()
       with open('new.txt', 'w', encoding='utf8') as file:
         for line in lines:
          if line.strip('\n') != name_3:
           file.write(line)
           print('Контакт удален')
       return   

def search_1_contact(name_3): #поиск на содержание для удаления контакта
  with open('new.txt', 'r', encoding='utf8')as file:
   lines = file.readlines()
   for i in lines:
      if name_3 in i:
        found = i.strip('\n')
        del_contact(found)
        print(found)    
        break   

def search_contact(word): #поиска на содержанию строки для редактирования контакта
  with open('new.txt', 'r', encoding='utf8')as file:
   lines = file.readlines()
   for i in lines:
      if word in i:
        word = i
        edit_contact(word.strip('\n'))
        print(word)

def main_menu(num):
  if num == 1:
    reed_contact()
  elif num == 2:
    name = (input('Введите имя, фамилию или номер телефона для поиска:'))
    find_contaсt(name)
  elif num == 3:
     add_contact()
  elif num == 4:
   word =(input('Введите имя, фамилию или номер телефона редактируемого контакта: '))
   search_contact(word)
  elif num == 5:
   name_3 =(input('Введите имя, фамилию или номер телефона удаляемого контакта: '))
   search_1_contact(name_3)
  elif num == 6:
    print('Вы выполнили выход из программы')
       
print('Добро пожаловать в телефонную книгу, сделайте выбор пункта меню.')
print ('1 - Показать все контакты.\n' '2 - Добавить новый контакт.\n' '3 - Поиск контакта.\n' '4 - Редактировать контакт.\n' '5 - Удалить контакт.\n' '6 - Выход.\n')
main_menu (int(input('Введите номер команды: ')))


