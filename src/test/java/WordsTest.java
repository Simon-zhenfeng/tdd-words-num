import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/7/17 09:27
 */
public class WordsTest {
    @Test
    public void should_return_empty_string_given_empty_space() {
        Words words = new Words("");
        String result = words.statistic();
        assertThat(result).isEmpty();
    }

    @Test
    public void should_return_format_string_given_one_word() {
        Words words = new Words("hi");
        String result = words.statistic();
        assertThat(result).isEqualTo("hi 1");
    }

    @Test
    public void should_return_format_string_given_two_word() {
        Words words = new Words("hi lucy");
        String result = words.statistic();
        assertThat(result).isEqualTo("hi 1 lucy 1");
    }

    @Test
    public void should_return_format_string_given_duplicated_words() {
        Words words = new Words("hi hi luck");
        String result = words.statistic();
        assertThat(result).isEqualTo("hi 2 luck 1");
    }

    @Test
    public void should_return_format_string_given_duplicated_words_by_sorted() {
        Words words = new Words("hi hi a a a luck");
        String result = words.statistic();
        assertThat(result).isEqualTo("a 3 hi 2 luck 1");
    }

    @Test
    public void should_return_format_string_given_muti_space() {
        Words words = new Words(" hi hi a   a a  luck  ");
        String result = words.statistic();
        assertThat(result).isEqualTo("a 3 hi 2 luck 1");
    }
}
