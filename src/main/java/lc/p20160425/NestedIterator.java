package lc.p20160425;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a nested list of integers, implement an iterator to flatten it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Example 1:
 Given the list [[1,1],2,[1,1]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

 Example 2:
 Given the list [1,[4,[6]]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 */

interface NestedInteger {

  // @return true if this NestedInteger holds a single integer, rather than a nested list.
  public boolean isInteger();

  // @return the single integer that this NestedInteger holds, if it holds a single integer
  // Return null if this NestedInteger holds a nested list
  public Integer getInteger();

  // @return the nested list that this NestedInteger holds, if it holds a nested list
  // Return null if this NestedInteger holds a single integer
  public List<NestedInteger> getList();
}


public class NestedIterator implements Iterator<Integer> {

  private Deque<Iterator<NestedInteger>> nestedListIterStack = new LinkedList<>();
  private Integer next = null;

  public NestedIterator(List<NestedInteger> nestedList) {
    this.nestedListIterStack.push(nestedList.iterator());
  }

  @Override
  public Integer next() {
    if (next == null) {
      getNext();
    }
    if (next != null) {
      Integer retValue = next;
      next = null;
      return retValue;
    }
    return next;
  }

  @Override
  public boolean hasNext() {
    getNext();
    return next != null;
  }

  private void getNext() {
    if (nestedListIterStack.isEmpty()) {
      return;
    }
    Iterator<NestedInteger> iter = nestedListIterStack.pop();
    if (iter.hasNext()) {
      NestedInteger nested = iter.next();
      nestedListIterStack.push(iter);
      if (nested.isInteger()) {
        next = nested.getInteger();
        return;
      } else {
        nestedListIterStack.push(nested.getList().iterator());
        getNext();
      }
    } else {
      getNext();
    }
  }
}
