package lc.p20150718;

import lc.p20150718.BasicCalculator.Tokenizer;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicCalculatorTest {
    @Test
    public void tockenizerTest() {
        String expression = " 3  +(4+5 /3 )-8*5 ";
        Tokenizer tokenizer = new Tokenizer(expression);
        String token = null;
        String result = "";
        while ((token = tokenizer.nextToken()) != null) {
            result += token;
        }
        assertThat(result, Matchers.equalTo(expression.replaceAll(" ", "")));
    }

    @Test
    public void tockenizerPushBack() {
        String expression = " 3  +4+5 /(3 -8*5 ) ";
        Tokenizer tokenizer = new Tokenizer(expression);
        tokenizer.nextToken();
        tokenizer.nextToken();
        String tocken = tokenizer.nextToken();
        tokenizer.pushBack();
        String previousToken = tokenizer.nextToken();
        assertThat(tocken, Matchers.equalTo("4"));
        assertThat(previousToken, Matchers.equalTo("4"));
    }

    @Test
    public void expression1() {
        BasicCalculator basicCalculator = new BasicCalculator();
        assertThat(basicCalculator.calculate("1 + 1"), Matchers.equalTo(2));
        assertThat(basicCalculator.calculate(" 2-1 + 2 "), Matchers.equalTo(3));
        assertThat(basicCalculator.calculate("(1+(4+5+2)-3)+(6+8)"), Matchers.equalTo(23));
    }

}