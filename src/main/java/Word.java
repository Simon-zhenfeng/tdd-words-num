/**
 * @author Simon
 * @date 2020/7/27 09:44
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
        this.count++;
    }

    @Override
    public int compareTo(Word other) {
        return other.count - this.count;
    }
}
