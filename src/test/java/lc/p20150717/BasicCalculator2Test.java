package lc.p20150717;

import lc.p20150717.BasicCalculator2.Tockenizer;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class BasicCalculator2Test {

    @Test
    public void tockenizerTest() {
        String expression = " 3  +4+5 /3 -8*5 ";
        Tockenizer tockenizer = new Tockenizer(expression);
        String tocken = null;
        String result = "";
        while ((tocken = tockenizer.nextToken()) != null) {
            result += tocken;
        }
        assertThat(result, Matchers.equalTo(expression.replaceAll(" ", "")));
    }

    @Test
    public void tockenizerPushBack() {
        String expression = " 3  +4+5 /3 -8*5 ";
        Tockenizer tockenizer = new Tockenizer(expression);
        tockenizer.nextToken();
        tockenizer.nextToken();
        String tocken = tockenizer.nextToken();
        tockenizer.pushBack();
        String previousToken = tockenizer.nextToken();
        assertThat(tocken, Matchers.equalTo("4"));
        assertThat(previousToken, Matchers.equalTo("4"));
    }

    @Test
    public void expression1() {
        BasicCalculator2 basicCalculator2 = new BasicCalculator2();
        assertThat(basicCalculator2.calculate("3+2*2"), Matchers.equalTo(7));
    }
}
