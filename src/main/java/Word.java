/**
 * @author Simon
 * @date 2020/7/24 09:51
 */
public class Word implements Comparable<Word>{
    private final String word;
    private int count;

    public Word(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        count++;
    }

    @Override
    public int compareTo(Word o) {
        return o.count - this.count;
    }

    public String format() {
        return word +
                " " +
                count;
    }
}
