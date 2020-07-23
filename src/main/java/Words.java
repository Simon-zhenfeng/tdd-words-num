import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Simon
 * @date 2020/7/17 09:29
 */
public class Words {
    private final String wordString;

    public Words(String wordString) {
        this.wordString = wordString.trim();
    }

    public String statistic() {
        if (wordString.isEmpty()) {
            return wordString;
        }
        String[] words = split();
        List<Map.Entry<String, Integer>> groupedWords = group(words);
        sort(groupedWords);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : groupedWords) {
            sb.append(" ");
            sb.append(entry.getKey()).append(" ").append(entry.getValue());
        }
        return sb.substring(1, sb.length());
    }

    private void sort(List<Map.Entry<String, Integer>> groupedWords) {
        groupedWords.sort((x, y) -> y.getValue() - x.getValue());
    }

    private List<Map.Entry<String, Integer>> group(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        return new ArrayList<>(map.entrySet());
    }

    private String[] split() {
        return wordString.split("\\s+");
    }
}
