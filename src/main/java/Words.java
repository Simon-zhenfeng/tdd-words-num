import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Simon
 * @date 2020/7/23 23:37
 */
public class Words {
    private final String wordsString;

    public Words(String wordsString) {
        this.wordsString = wordsString.trim();
    }

    public String statistics() {
        if (wordsString.isEmpty()) {
            return wordsString;
        }
        String[] wordsArray = wordsString.split("\\s+");
        List<Pair<String, Integer>> groups = group(wordsArray);
        groups.sort((x, y) -> y.getValue() - x.getValue());
        StringBuilder stringBuilder = new StringBuilder();
        for (Pair<String, Integer> group : groups) {
            stringBuilder.append(group.getKey())
                    .append(" ")
                    .append(group.getValue())
                    .append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    private List<Pair<String, Integer>> group(String[] wordsArray) {
        Map<String, Pair<String, Integer>> map = new HashMap<>();
        for (String word : wordsArray) {
            if (map.containsKey(word)) {
                map.put(word, new Pair<>(word, map.get(word).getValue() + 1));
            } else {
                map.put(word, new Pair<>(word, 1));
            }
        }
        return new ArrayList<>(map.values());
    }
}
