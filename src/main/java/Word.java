/**
 * @author Simon
 * @date 2020/7/30 09:03
 */
public class Word implements Comparable<Word>{
    private final String key;
    private int count;

    public Word(String key, int count) {
        this.key = key;
        this.count = count;
    }

    public String getKey() {
        return key;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        count++;
    }

    @Override
    public int compareTo(Word other) {
        return other.count - this.count;
    }

    public String format() {
        return key + " " + count;
    }
}
