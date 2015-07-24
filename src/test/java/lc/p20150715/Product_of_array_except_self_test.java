package lc.p20150715;

import org.junit.Assert;
import org.junit.Test;


public class Product_of_array_except_self_test {

    @Test
    public void Product_of_array_except_self() {
        Product_of_array_except_self solution = new Product_of_array_except_self();
        Assert.assertArrayEquals(new int[]{24, 12, 8, 6},
                solution.productExceptSelf(new int[]{1, 2, 3, 4}));
    }
}
