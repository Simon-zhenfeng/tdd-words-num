import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/7/29 09:33
 */
public class WordTest {
    @Test
    public void should_construct_word_object_given_one_word_string() {
        Word word = new Word("hi", 1);
        assertThat(word.getName()).isEqualTo("hi");
        assertThat(word.getCount()).isEqualTo(1);
    }

    @Test
    public void should_add_count() {
        Word word = new Word("hi", 1);
        word.addCount();
        assertThat(word.getCount()).isEqualTo(2);
    }
}
