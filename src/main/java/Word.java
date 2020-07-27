/**
 * @author Simon
 * @date 2020/7/28 00:00
 */
public class Word implements Comparable<Word>{
    private final String name;
    private int count;

    public Word(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        count++;
    }

    @Override
    public int compareTo(Word other) {
        return other.count - count;
    }

    public String format() {
        return name + " " + count;
    }
}
