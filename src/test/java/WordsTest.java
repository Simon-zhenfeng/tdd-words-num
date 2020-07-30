import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/7/30 08:45
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
    public void should_return_string_given_three_words() {
        Words words = new Words("he is a");
        String result = words.statistics();
        assertThat(result).isEqualTo("he 1 is 1 a 1");
    }

    @Test
    public void should_return_string_given_two_duplicated_words() {
        Words words = new Words("he he");
        String result = words.statistics();
        assertThat(result).isEqualTo("he 2");
    }

    @Test
    public void should_return_string_given_duplicated_words_need_be_sorted() {
        Words words = new Words("he he is is is");
        String result = words.statistics();
        assertThat(result).isEqualTo("is 3 he 2");
    }

    @Test
    public void should_return_string_given_more_space() {
        Words words = new Words("    he he     is is is a    ");
        String result = words.statistics();
        assertThat(result).isEqualTo("is 3 he 2 a 1");
    }

    @Test
    public void should_return_word_list_given_word_array() {
        String[] wordArray = {"he", "is"};
        Words words = new Words("test");
        List<Word> result = words.group(wordArray);
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getKey()).isEqualTo("he");
        assertThat(result.get(0).getCount()).isEqualTo(1);
    }

    @Test
    public void should_return_word_list_given_word_array_with_duplicated_element() {
        String[] wordArray = {"he", "is", "he"};
        Words words = new Words("test");
        List<Word> result = words.group(wordArray);
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getKey()).isEqualTo("he");
        assertThat(result.get(0).getCount()).isEqualTo(2);
    }
}
