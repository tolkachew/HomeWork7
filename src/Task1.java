import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/vocab.txt"))) {
            String s;
            do {
                s = br.readLine();
                if (s != null) {
                    s = s.substring(0, 1).toLowerCase();
                    if (s.matches("[a-z]")) {
                        map.put(s, map.getOrDefault(s, 0) + 1);
                    }
                }
            } while (s != null);
            for (Map.Entry<String, Integer> line : map.entrySet()) {
                System.out.println("Words per letter '"+line.getKey() + "' : " + line.getValue() + " in file");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
//Количество слов, начинающихся на определенную букву (от 'a' до 'z')