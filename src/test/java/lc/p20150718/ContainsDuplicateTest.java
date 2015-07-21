package lc.p20150718;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainsDuplicateTest {

    @Test
    public void testContainsDuplicate() throws Exception {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        assertThat(containsDuplicate.containsDuplicate(new int[]{1, 2, 3, 4}),
                Matchers.equalTo(false));
    }

    @Test
    public void testContainsDuplicate1() throws Exception {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        assertThat(containsDuplicate.containsDuplicate(new int[]{4, 1, 2, 3, 4}),
                Matchers.equalTo(true));
    }
}