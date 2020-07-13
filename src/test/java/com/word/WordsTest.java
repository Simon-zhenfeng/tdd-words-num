package com.word;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/7/12 22:07
 */
public class WordsTest {
    @Test
    public void should_return_empty_given_empty_string() {
        assertThat(Words.caculator("")).isEmpty();
    }

    @Test
    public void should_return_word_given_one_word() {
        assertThat(Words.caculator("simon")).isEqualTo("simon 1");
    }

    @Test
    public void should_return_two_format_words_given_two_single_words() {
        assertThat(Words.caculator("simon come")).isEqualTo("simon 1 come 1");
    }

    @Test
    public void should_return_number_muti_given_words_duplicated() {
        assertThat(Words.caculator("simon simon")).isEqualTo("simon 2");
        assertThat(Words.caculator("simon simon come")).isEqualTo("simon 2 come 1");
    }

    @Test
    public void should_return_number_muti_and_sort_given_words_duplicated() {
        assertThat(Words.caculator("hi simon simon")).isEqualTo("simon 2 hi 1");
    }
}
