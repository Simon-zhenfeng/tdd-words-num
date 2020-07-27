import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/7/27 23:42
 */
public class WordsTest {
    @Test
    public void should_return_empty_string_given_empty() {
        Words words = new Words("");
        String result = words.statistics();
        assertThat(result).isEmpty();
    }

    @Test
    public void should_return_string_given_one_word() {
        Words words = new Words("hi");
        String result = words.statistics();
        assertThat(result).isEqualTo("hi 1");
    }

    @Test
    public void should_return_string_given_two_words() {
        Words words = new Words("hi boy");
        String result = words.statistics();
        assertThat(result).isEqualTo("hi 1 boy 1");
    }

    @Test
    public void should_return_string_given_more_words() {
        Words words = new Words("hi boy hello");
        String result = words.statistics();
        assertThat(result).isEqualTo("hi 1 boy 1 hello 1");
    }

    @Test
    public void should_return_string_given_duplicated_words() {
        Words words = new Words("hi boy hi hi");
        String result = words.statistics();
        assertThat(result).isEqualTo("hi 3 boy 1");
    }

    @Test
    public void should_return_string_given_duplicated_words_need_be_sorted() {
        Words words = new Words("boy hi hi a");
        String result = words.statistics();
        assertThat(result).isEqualTo("hi 2 boy 1 a 1");
    }

    @Test
    public void should_return_string_given_mutiple_space() {
        Words words = new Words("   hi boy   hi hi  ");
        String result = words.statistics();
        assertThat(result).isEqualTo("hi 3 boy 1");
    }
}
