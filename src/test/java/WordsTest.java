import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/7/27 09:16
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
    public void should_return_string_given_tow_duplicated_words() {
        Words words = new Words("he he is");
        String result = words.statistics();
        assertThat(result).isEqualTo("he 2 is 1");
    }

    @Test
    public void should_return_string_given_tow_duplicated_words_need_be_sorted() {
        Words words = new Words("he is is");
        String result = words.statistics();
        assertThat(result).isEqualTo("is 2 he 1");
    }

    @Test
    public void should_return_string_given_same_frequency_words_need_be_sorted_by_text_sequence() {
        Words words = new Words("he is is a boy !");
        String result = words.statistics();
        assertThat(result).isEqualTo("is 2 he 1 a 1 boy 1 ! 1");
    }

    @Test
    public void should_return_string_given_mutiple_space() {
        Words words = new Words("   he is is a   boy !   ");
        String result = words.statistics();
        assertThat(result).isEqualTo("is 2 he 1 a 1 boy 1 ! 1");
    }
}
