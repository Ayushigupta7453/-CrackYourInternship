/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> l;
    int idx;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.l = new ArrayList<>();
        for(NestedInteger item:nestedList){
            if(item.isInteger()){
                this.l.add(item.getInteger());
            }
            else{
                this.l.addAll(flat(item.getList()));
            }
        }
        this.idx =0;
    }
    private List<Integer> flat(List<NestedInteger> nestedList) {
        List<Integer> answer = new ArrayList<Integer>();
        for(NestedInteger item : nestedList){
            if(item.isInteger()){
                answer.add(item.getInteger());
            }
            
            else{
                answer.addAll(flat(item.getList()));
            }
        }

        return answer;
    }
    @Override
    public Integer next() {
        return l.get(this.idx++);
    }

    @Override
    public boolean hasNext() {
        return this.idx<this.l.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
