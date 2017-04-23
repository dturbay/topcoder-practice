package lc.p20170324;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class SolutionTest {

    @Test
    public void lengthOfLongestSubstring() throws Exception {
        assertThat(new Solution().lengthOfLongestSubstring("abcabcbb"), Matchers.is(3));
    }

    @Test
    public void lengthOfLongestSubstring1() throws Exception {
        assertThat(new Solution().lengthOfLongestSubstring("bbbbb"), Matchers.is(1));
    }

    @Test
    public void lengthOfLongestSubstring2() throws Exception {
        assertThat(new Solution().lengthOfLongestSubstring("pwwkew"), Matchers.is(3));
    }
}