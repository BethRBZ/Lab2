import java.io.*;

public class Main {
    public static void main(String[] args) {
        File directory = new File("C://Users//Beth//Desktop");
        File[] files = directory.listFiles();
        int count = 0;
        for (File file : files) {
            if (file.getName().endsWith(".txt")) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    int lineCount = 0;

                    while ((line = br.readLine()) != null) {
                        String[] words = line.split("\\s+");
                        lineCount += words.length;
                    }

                    System.out.printf("Файл %s содержит %d слов.\n", file.getName(), lineCount);
                    count += lineCount;
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
        System.out.printf("Общее количество слов во всех файлов: %d\n", count);
    }
}
