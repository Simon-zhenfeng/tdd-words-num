import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/7/28 08:50
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
        Words words = new Words("he");
        String result = words.statistics();
        assertThat(result).isEqualTo("he 1");
    }

    @Test
    public void should_return_string_given_two_words() {
        Words words = new Words("he is");
        String result = words.statistics();
        assertThat(result).isEqualTo("he 1 is 1");
    }

    @Test
    public void should_return_string_given_more_words() {
        Words words = new Words("he is a boy");
        String result = words.statistics();
        assertThat(result).isEqualTo("he 1 is 1 a 1 boy 1");
    }

    @Test
    public void should_return_string_given_duplicated_words() {
        Words words = new Words("he is a boy he");
        String result = words.statistics();
        assertThat(result).isEqualTo("he 2 is 1 a 1 boy 1");
    }

    @Test
    public void should_return_string_given_duplicated_words_need_be_sorted() {
        Words words = new Words("he is a boy is");
        String result = words.statistics();
        assertThat(result).isEqualTo("is 2 he 1 a 1 boy 1");
    }

    @Test
    public void should_return_string_given_more_spaces() {
        Words words = new Words("  he is a boy   is  ");
        String result = words.statistics();
        assertThat(result).isEqualTo("is 2 he 1 a 1 boy 1");
    }
}
