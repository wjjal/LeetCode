import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class L341FlattenNestedListIterator {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * <p/>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p/>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p/>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return null if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */
    public interface NestedInteger {
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
        LinkedList<Iterator<NestedInteger>> stack = new LinkedList<Iterator<NestedInteger>>();
        Integer current = null;

        public NestedIterator(List<NestedInteger> nestedList) {
            if (nestedList != null) {
                stack.push(nestedList.iterator());
            }
        }

        @Override
        public Integer next() {
            return current;
        }

        @Override
        public boolean hasNext() {
            while(!stack.isEmpty()){
                Iterator<NestedInteger> node = stack.peek();
                if (!node.hasNext()){
                    stack.pop();
                    continue;
                }
                NestedInteger value = node.next();
                if (value.isInteger()){
                    current = value.getInteger();
                    return true;
                }else {
                    stack.push(value.getList().iterator());
                }
            }
            return false;
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
