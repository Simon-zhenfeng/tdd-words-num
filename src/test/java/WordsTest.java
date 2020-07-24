import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/7/23 23:35
 */
public class WordsTest {
    @Test
    public void should_return_empty_string_given_space() {
        Words words = new Words("");
        String result = words.statistics();
        assertThat(result).isEmpty();
    }

    @Test
    public void should_return_format_string_given_one_word() {
        Words words = new Words("hi");
        String result = words.statistics();
        assertThat(result).isEqualTo("hi 1");
    }

    @Test
    public void should_return_format_string_given_two_different_words() {
        Words words = new Words("hi monitoring");
        String result = words.statistics();
        assertThat(result).isEqualTo("hi 1 monitoring 1");
    }

    @Test
    public void should_return_format_string_given_duplicated_words() {
        Words words = new Words("hi monitoring hi");
        String result = words.statistics();
        assertThat(result).isEqualTo("hi 2 monitoring 1");
    }

    @Test
    @Ignore
    public void should_return_format_string_given_two_different_words_sorted_by_word_sequence() {
        Words words = new Words("hi monitoring a");
        String result = words.statistics();
        assertThat(result).isEqualTo("hi 1 monitoring 1 a 1");
    }

    @Test
    public void should_return_format_string_given_duplicated_words_by_sorted() {
        Words words = new Words("hi is is");
        String result = words.statistics();
        assertThat(result).isEqualTo("is 2 hi 1");
    }

    @Test
    public void should_return_format_string_given_mutiple_space() {
        Words words = new Words("  hi is    is  ");
        String result = words.statistics();
        assertThat(result).isEqualTo("is 2 hi 1");
    }
}
