import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Simon
 * @date 2020/7/28 08:51
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
        String[] wordArray = split();
        List<Word> wordList = group(wordArray);
        Collections.sort(wordList);
        return format(wordList);
    }

    private String format(List<Word> wordList) {
        return wordList.stream()
                .map(Word::format)
                .collect(Collectors.joining(" "));
    }

    private String[] split() {
        return wordsString.split("\\s+");
    }

    private List<Word> group(String[] wordArray) {
        List<Word> result = new ArrayList<>();
        Map<String, Word> map = new HashMap<>();
        for (String key : wordArray) {
            Word word = map.get(key);
            if (word == null) {
                word = new Word(key, 1);
                map.put(key, word);
                result.add(word);
            } else {
                word.addCount();
            }
        }
        return result;
    }

}
