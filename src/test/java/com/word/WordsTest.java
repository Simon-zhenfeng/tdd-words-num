package com.word;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/7/13 09:29
 */
public class WordsTest {
    @Test
    public void should_return_empty_string_given_empty_string() {
        Words words = new Words("");
        assertThat(words.caculate()).isEmpty();
    }

    @Test
    public void should_return_string_given_one_word() {
        Words words = new Words("hi");
        assertThat(words.caculate()).isEqualTo("hi 1");
    }

    @Test
    public void should_return_string_given_different_words() {
        Words words = new Words("he is");
        assertThat(words.caculate()).isEqualTo("he 1\r\nis 1");
    }

    @Test
    public void should_return_string_given_muti_words() {
        Words words = new Words("he he is");
        assertThat(words.caculate()).isEqualTo("he 2\r\nis 1");
    }

    @Test
    public void should_return_string_given_muti_words_by_sorted() {
        Words words = new Words("he he is is it is");
        assertThat(words.caculate()).isEqualTo("is 3\r\nhe 2\r\nit 1");
    }

    @Test
    public void should_return_string_given_muti_spaces() {
        Words words = new Words(" he he is is   it is ");
        assertThat(words.caculate()).isEqualTo("is 3\r\nhe 2\r\nit 1");
    }
}
