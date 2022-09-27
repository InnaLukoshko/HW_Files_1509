package Task7;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class Task7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к файлу ");
        String dir = bufferedReader.readLine();
        File file = new File(dir, "Text_with_dangerWord.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter("Text_without_dangerWord.txt"))) {

            System.out.println("Введите список запрещенных слов в строку через пробел");
            String s = bufferedReader.readLine();
            String[] dangerWords = s.split(" ");

            String str;
            int countWords = 0;
            while ((str = reader.readLine()) != null) {
                String[] wordInFile = str.split(" ");
                for (String x : dangerWords) {
                    for (String y : wordInFile) {
                        if (!(x.equalsIgnoreCase(y))) {
                            writer.write(y + " ");
                        } else {
                            countWords++;
                        }
                    }
                    System.out.println("Количество удалённых слов " + x + " равно " + countWords);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}