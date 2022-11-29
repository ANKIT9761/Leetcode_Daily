// link- https://leetcode.com/problems/insert-delete-getrandom-o1/description/

class RandomizedSet {
    Set<Integer> h;
    public RandomizedSet() {
        h=new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(!h.contains(val)){
            h.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(h.contains(val)){
            h.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        List<Integer> list=new ArrayList<>(h);
        int r=(int)(Math.random()*h.size());
        return list.get(r);
    }
}
