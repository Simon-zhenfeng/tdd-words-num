import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Simon
 * @date 2020/7/30 08:46
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
        sort(wordList);
        return format2(wordList);
    }

    private String format2(List<Word> wordList) {
        return wordList.stream()
                .map(Word::format)
                .collect(Collectors.joining(" "));
    }

    private void sort(List<Word> words) {
        Collections.sort(words);
    }

    private String[] split() {
        return wordsString.split("\\s+");
    }

    public List<Word> group(String[] wordArray) {
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
