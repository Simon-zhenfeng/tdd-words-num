
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author Simon
 * @date 2020/7/24 09:26
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
        String[] wordArray = split(wordsString);
        List<Word> groupedWords = group(wordArray);
        Collections.sort(groupedWords);
        return format(groupedWords);
    }

    private String format(List<Word> groupedWords) {
        return groupedWords.stream()
                .map(Word::format)
                .collect(Collectors.joining(" "));
    }

    private String[] split(String wordsString) {
        return wordsString.split("\\s+");
    }

    private List<Word> group(String[] wordArray) {
        List<Word> result = new ArrayList<>();
        Map<String, Word> map = new HashMap<>();
        for (String key : wordArray) {
            Word word = map.get(key);
            if (word == null) {
                word = new Word(key, 1);
                result.add(word);
                map.put(key, word);
            } else {
                word.addCount();
            }
        }
        return result;
    }

}
