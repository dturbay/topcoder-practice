package lc.p20160425;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import org.hamcrest.Matchers;
import static org.junit.Assert.assertThat;

class NestedIntegerImpl implements NestedInteger {

  private boolean isInteger;
  private Integer intVal;
  private List<NestedInteger> listVal;

  public NestedIntegerImpl(Integer integer) {
    this.isInteger = true;
    this.intVal = integer;
  }

  public NestedIntegerImpl(List<NestedInteger> list) {
    this.isInteger = false;
    this.listVal = list;
  }

  @Override
  public boolean isInteger() {
    return this.isInteger;
  }

  @Override
  public Integer getInteger() {
    return intVal;
  }

  @Override
  public List<NestedInteger> getList() {
    return listVal;
  }
}

public class NestedIteratorTest {

  @Test
  public void test1() {
    List<NestedInteger> nestedIntegers = new ArrayList<>();
    List<NestedInteger> subList = new ArrayList<>();
    subList.add(new NestedIntegerImpl(1));
    subList.add(new NestedIntegerImpl(1));
    nestedIntegers.add(new NestedIntegerImpl(subList));
    nestedIntegers.add(new NestedIntegerImpl(2));
    nestedIntegers.add(new NestedIntegerImpl(subList));

    NestedIterator iter = new NestedIterator(nestedIntegers);
    List<Integer> result = new ArrayList<>();
    while (iter.hasNext()) {
      result.add(iter.next());
    }
    assertThat(result, Matchers.contains(1, 1, 2, 1, 1));
  }

  @Test
  public void test2() {
    List<NestedInteger> nestedIntegers = new ArrayList<>();
    nestedIntegers.add(new NestedIntegerImpl(1));

    List<NestedInteger> firstSubList = new ArrayList<>();
    firstSubList.add(new NestedIntegerImpl(4));

    List<NestedInteger> secondSubList = new ArrayList<>();
    secondSubList.add(new NestedIntegerImpl(6));

    firstSubList.add(new NestedIntegerImpl(secondSubList));
    nestedIntegers.add(new NestedIntegerImpl(firstSubList));

    NestedIterator iter = new NestedIterator(nestedIntegers);
    List<Integer> result = new ArrayList<>();
    while (iter.hasNext()) {
      result.add(iter.next());
    }
    assertThat(result, Matchers.contains(1, 4, 6));
  }
}
