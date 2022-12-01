import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/vocab.txt"))) {
            String s;
            do {
                s = br.readLine();
                if (s != null) for (int i = 0; i < s.length(); i++) {
                    String c = s.substring(i, i + 1).toLowerCase();
                    if (c.matches("[a-z]")) {
                        map.put(c, map.getOrDefault(c, 0) + 1);
                    }
                }
            } while (s != null);
                for (Map.Entry<String, Integer> line : map.entrySet()) {
                    System.out.println("Letter '" + line.getKey() + "' : appears " + line.getValue() + " times");
                }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
//Частота встречаемости букв в словах
