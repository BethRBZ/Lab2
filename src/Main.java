import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        File folder = new File("C://Users//Beth//Desktop");
        Map<String, Integer> freqDict = new HashMap<>();
        for (File file : folder.listFiles()) {
            if (file.getName().endsWith(".txt")) {
                try (Scanner input = new Scanner(file)) {
                    while (input.hasNext()) {
                        String word = input.next();
                        word = word.replaceAll("[^A-Za-zА-Яа-я]", "").toLowerCase();
                        freqDict.put(file.getPath() + ' ' + word, freqDict.getOrDefault(word, 0) + 1);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(freqDict.entrySet());
        sortedList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        for (int i = 0; i < sortedList.size() && i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i).getKey() + " : " + sortedList.get(i).getValue());
        }
    }
}
