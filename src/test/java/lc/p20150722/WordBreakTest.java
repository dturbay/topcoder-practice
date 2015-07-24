package lc.p20150722;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 7/23/15.
 */
public class WordBreakTest {

    @Test
    public void testWordBreak() throws Exception {
        WordBreak wordBreak = new WordBreak();
        assertThat(wordBreak.wordBreak("leetcode", Stream.of("leet", "code").collect(Collectors.toSet())),
                Matchers.equalTo(true));
        assertThat(wordBreak.wordBreak("ab", Stream.of("a", "b").collect(Collectors.toSet())),
                Matchers.equalTo(true));
    }
}
