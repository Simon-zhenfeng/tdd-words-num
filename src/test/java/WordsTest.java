import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/7/24 09:24
 */
public class WordsTest {
    @Test
    public void should_return_empty_string_given_empty_string() {
        Words words = new Words("");
        String result = words.statistics();
        assertThat(result).isEmpty();
    }

    @Test
    public void should_return_string_given_one_word() {
        Words words = new Words("he");
        String result = words.statistics();
        assertThat(result).isEqualTo("he 1");
    }

    @Test
    public void should_return_string_given_two_different_words() {
        Words words = new Words("he is");
        String result = words.statistics();
        assertThat(result).isEqualTo("he 1 is 1");
    }

    @Test
    public void should_return_string_given_duplicated_words() {
            Words words = new Words("is is he");
            String result = words.statistics();
            assertThat(result).isEqualTo("is 2 he 1");
    }

    @Test
    public void should_return_string_given_duplicated_word_need_be_sorted() {
        Words words = new Words("he is is");
        String result = words.statistics();
        assertThat(result).isEqualTo("is 2 he 1");
    }

    @Test
    public void should_return_string_given_duplicated_word_and_same_frequency_word_sorted_by_input_sequence() {
        Words words = new Words("he is is a boy");
        String result = words.statistics();
        assertThat(result).isEqualTo("is 2 he 1 a 1 boy 1");
    }

    @Test
    public void should_return_string_given_more_spaces() {
        Words words = new Words("  he is   is ");
        String result = words.statistics();
        assertThat(result).isEqualTo("is 2 he 1");
    }
}
