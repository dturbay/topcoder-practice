package lc.p20150724;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertThat;

/**
 * Created by denysturbai on 7/24/15.
 */
public class WordBreak2Test {

    @Test
    public void testWordBreak() throws Exception {
        WordBreak2 wordBreak2 = new WordBreak2();
        assertThat(wordBreak2.wordBreak("catsanddog",
                        new HashSet<>(Arrays.asList("cat", "cats", "and", "sand", "dog"))),
                Matchers.containsInAnyOrder("cats and dog", "cat sand dog"));
        assertThat(wordBreak2.wordBreak("a",
                        new HashSet<>(Arrays.asList("b"))),
                Matchers.emptyCollectionOf(String.class));
    }
}