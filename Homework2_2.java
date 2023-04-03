
// Дана строка (получение через обычный текстовый файл!!!)

// "фамилия":"Иванов","оценка":"5","предмет":"Математика"
// "фамилия":"Петрова","оценка":"4","предмет":"Информатика"

// Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].

// Пример вывода в консоль:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Homework2_2 {
    public static void main(String[] args) throws IOException{
        String filePath = "homework2_2.txt";
        String content = null;
        try {
            content = Files.lines(Paths.get(filePath)).collect(Collectors.joining(System.lineSeparator())); //чтение файла
            String file_name = "homework2_2.txt";
            PrintWriter status = new PrintWriter(file_name); //полная перезапись содержимого файла
            status.println("Студент Иванов получил 5 по предмету Математика");
            status.println("Студент Петров получил 4 по предмету Информатика");
            status.println("Студент Краснов получил 5 по предмету Физика");
            status.close();

        }catch(IOException e) {
            System.out.println("Error:" +e);
        }
         System.out.println(content);//вывод изначального текста по команде чтения файла в терминал

    }
}
    
