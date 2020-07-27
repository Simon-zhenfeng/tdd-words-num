import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Simon
 * @date 2020/7/27 09:18
 */
public class Words {
    private final String wordsString;

    public Words(String wordsString) {
        this.wordsString = wordsString.trim();
    }

    public String statistics() {
        if (wordsString.isEmpty()) {
            return "";
        }
        String[] wordsArray = split(wordsString);
        List<Word> wordList = group(wordsArray);
        Collections.sort(wordList);
        return wordList.stream()
                .map(word -> format(word.getName(), word.getCount()))
                .collect(Collectors.joining(" "));
    }

    private String[] split(String wordsString) {
        return wordsString.split("\\s+");
    }

    private List<Word> group(String[] wordsArray) {
        List<Word> result = new ArrayList<>();
        Map<String, Word> map = new HashMap<>();
        for (String wordString : wordsArray) {
            Word word = map.get(wordString);
            if (word == null) {
                word = new Word(wordString, 1);
                map.put(wordString, word);
                result.add(word);
            } else {
                word.addCount();
            }
        }
        return result;
    }

    private String format(String word, int count) {
        return word + " " + count;
    }
}
