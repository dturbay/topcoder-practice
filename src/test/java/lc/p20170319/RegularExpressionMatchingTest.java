package lc.p20170319;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 3/19/17.
 */
public class RegularExpressionMatchingTest {

    @Test
    public void isMatchTest1() {
        assertThat(new RegularExpressionMatching().isMatch("aa","a"), Matchers.is(false));
    }

    @Test
    public void isMatchTest2() {
        assertThat(new RegularExpressionMatching().isMatch("aa","aa"), Matchers.is(true));
    }

    @Test
    public void isMatchTest3() {
        assertThat(new RegularExpressionMatching().isMatch("aaa","aa"), Matchers.is(false));
    }

    @Test
    public void isMatchTest4() {
        assertThat(new RegularExpressionMatching().isMatch("aa", "a*"), Matchers.is(true));
    }

    @Test
    public void isMatchTest5() {
        assertThat(new RegularExpressionMatching().isMatch("aa", ".*"), Matchers.is(true));
    }

    @Test
    public void isMatchTest6() {
        assertThat(new RegularExpressionMatching().isMatch("ab", ".*"), Matchers.is(true));
    }

    @Test
    public void isMatchTest7() {
        assertThat(new RegularExpressionMatching().isMatch("aab", "c*a*b"), Matchers.is(true));
    }

    @Test
    public void isMatchTest8() {
        assertThat(new RegularExpressionMatching().isMatch("abcd", "d*"), Matchers.is(false));
    }

    @Test
    public void isMatchTest9() {
        assertThat(new RegularExpressionMatching().isMatch("a", "ab*"), Matchers.is(true));
    }

    @Test
    public void isMatchTest10() {
        assertThat(new RegularExpressionMatching().isMatch("aaa", "ab*a*c*a"), Matchers.is(true));
    }

    @Test
    public void isMatchTest11() {
        assertThat(new RegularExpressionMatching().isMatch("a", ".*..a*"), Matchers.is(false));
    }

    @Test
    public void isMatchTest12() {
        assertThat(new RegularExpressionMatching().isMatch("aabcbcbcaccbcaabc", ".*a*aa*.*b*.c*.*a*"), Matchers.is(true));
    }
}