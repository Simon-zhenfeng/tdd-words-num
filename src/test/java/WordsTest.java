import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/7/14 21:01
 */
public class WordsTest {
    @Test
    public void should_return_empty_string_given_empty_string() {
        Words words = new Words("");
        assertThat(words.statistic()).isEmpty();
    }

    @Test
    public void should_return_string_given_one_word() {
        Words words = new Words("he");
        assertThat(words.statistic()).isEqualTo("he 1");
    }

    @Test
    public void should_return_string_given_two_different_words() {
        Words words = new Words("he is");
        assertThat(words.statistic()).isEqualTo("he 1 is 1");
    }

    @Test
    public void should_return_string_given_duplicated_words() {
        Words words = new Words("he he is");
        assertThat(words.statistic()).isEqualTo("he 2 is 1");
    }

    @Test
    public void should_return_string_given_duplicated_words_need_to_be_sorted() {
        Words words = new Words("he he is is is he he");
        assertThat(words.statistic()).isEqualTo("he 4 is 3");
    }

    @Test
    public void should_return_string_given_words_with_muti_space() {
        Words words = new Words(" he he is is is he   he  ");
        assertThat(words.statistic()).isEqualTo("he 4 is 3");
    }
}
