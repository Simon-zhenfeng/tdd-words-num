/**
 * @author Simon
 * @date 2020/7/28 09:16
 */
public class Word implements Comparable<Word>{
    private final String key;
    private int count;

    public Word(String key, int count) {
        this.key = key;
        this.count = count;
    }

    public String format() {
        return key + " " + count;
    }

    public void addCount() {
        count++;
    }

    @Override
    public int compareTo(Word other) {
        return other.count - this.count;
    }
}
