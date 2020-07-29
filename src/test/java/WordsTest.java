import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/7/29 09:21
 */
public class WordsTest {
    @Test
    public void should_return_empty_given_empty() {
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
    public void should_return_string_given_two_different_words() {
        Words words = new Words("hi man");
        String result = words.statistics();
        assertThat(result).isEqualTo("hi 1 man 1");
    }

    @Test
    public void should_return_string_give_duplicated_words() {
        Words words = new Words("hi hi man");
        String result = words.statistics();
        assertThat(result).isEqualTo("hi 2 man 1");
    }

    @Test
    public void should_return_string_given_duplicated_words_need_be_sorted() {
        Words words = new Words("hi hi man man man");
        String result = words.statistics();
        assertThat(result).isEqualTo("man 3 hi 2");
    }

    @Test
    public void should_return_string_given_words_with_more_spaces() {
        Words words = new Words("   hi hi    man man man  ");
        String result = words.statistics();
        assertThat(result).isEqualTo("man 3 hi 2");
    }
}
