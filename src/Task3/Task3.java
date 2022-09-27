package Task3;

import java.io.*;
import java.nio.file.Files;

public class Task3 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к файлу ");
        InputStream inputStream = null;
        try {
            String dir = reader.readLine();
            File file = new File(dir, "FindWord.txt");
            System.out.println("Введите слово, которое хотите найти в файле");
            String word = reader.readLine();

            inputStream = Files.newInputStream(file.toPath());
            byte[] byteInput = new byte[inputStream.available()];
            inputStream.read(byteInput);

            int countWords = 0;
            String[] wordInFile = new String(byteInput).split(" ");
            for (String s : wordInFile) {
                if (s.equalsIgnoreCase(word)) {
                    countWords++;
                }
            }
            System.out.println("Количество слов " + word + " в файле равно " + countWords);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
