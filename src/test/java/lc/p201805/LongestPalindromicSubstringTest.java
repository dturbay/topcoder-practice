package lc.p201805;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class LongestPalindromicSubstringTest {

    @Test
    public void testLongestPalindrome1() {
        assertThat(new LongestPalindromicSubstring().longestPalindrome("babad"),
                anyOf(is("bab"), is("aba")));
    }

    @Test
    public void testLongestPalindrome2() {
        assertThat(new LongestPalindromicSubstring().longestPalindrome("cbbd"), is("bb"));
    }

    @Test
    public void testLongestPalindrome3() {
        assertThat(new LongestPalindromicSubstring().longestPalindrome("ccc"), is("ccc"));
    }
}
