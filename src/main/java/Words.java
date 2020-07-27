import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Simon
 * @date 2020/7/27 23:43
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
        Map<String, Word> cache = new HashMap<>();
        for (String name : wordArray) {
            Word word = cache.get(name);
            if (word == null) {
                word = new Word(name, 1);
                cache.put(name, word);
                result.add(word);
            } else {
                word.addCount();
            }
        }
        return result;
    }

}
