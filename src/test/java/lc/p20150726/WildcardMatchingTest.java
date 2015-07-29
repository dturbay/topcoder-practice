package lc.p20150726;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 7/26/15.
 */
public class WildcardMatchingTest {

    @Test
    public void testIsMatch() throws Exception {
        WildcardMatching wildcardMatching = new WildcardMatching();
        assertThat(wildcardMatching.isMatch("aa", "a"), Matchers.equalTo(false));
        assertThat(wildcardMatching.isMatch("aa", "aa"), Matchers.equalTo(true));
        assertThat(wildcardMatching.isMatch("aaa", "aa"), Matchers.equalTo(false));
        assertThat(wildcardMatching.isMatch("aa", "*"), Matchers.equalTo(true));
        assertThat(wildcardMatching.isMatch("aa", "a*"), Matchers.equalTo(true));
        assertThat(wildcardMatching.isMatch("ab", "?*"), Matchers.equalTo(true));
        assertThat(wildcardMatching.isMatch("aab", "c*a*b"), Matchers.equalTo(false));
    }
}