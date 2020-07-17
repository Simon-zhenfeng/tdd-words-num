import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Simon
 * @date 2020/7/14 21:03
 */
public class Words {
    private final String wordsString;

    public Words(String wordsString) {
        this.wordsString = wordsString.trim();
    }

    public String statistic() {
        if (wordsString.isEmpty()) {
            return wordsString;
        }
        String[] wordArray = split();
        if (wordArray.length == 1) {
            return format(wordsString, 1);
        }
        Map<String, Integer> group = group(wordArray);
        List<Map.Entry<String, Integer>> soredWords = sort(group);
        StringBuilder sb = new StringBuilder();
        soredWords.forEach(entry -> sb.append(format(entry.getKey(), entry.getValue())).append(" "));
        return sb.substring(0, sb.length() - 1);
    }

    private List<Map.Entry<String, Integer>> sort(Map<String, Integer> group) {
        List<Map.Entry<String, Integer>> result = new ArrayList<>(
                group.entrySet()
        );
        result.sort((x, y) -> y.getValue() - x.getValue());
        return result;
    }

    private Map<String, Integer> group(String[] wordArray) {
        Map<String, Integer> result = new HashMap<>(wordArray.length);
        for (String word : wordArray) {
            if (result.containsKey(word)) {
                result.put(word, result.get(word) + 1);
            } else {
                result.put(word, 1);
            }
        }
        return result;
    }

    private String[] split() {
        return wordsString.split("\\s+");
    }

    private static String format(String wordsString, int count) {
        return wordsString + " " + count;
    }
}
