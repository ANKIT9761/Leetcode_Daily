// link- https://leetcode.com/problems/arithmetic-slices-ii-subsequence/description/

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        ArrayList<HashMap<Integer, Integer>> list = new ArrayList();
        int ans=0;
        for(int i=0; i<nums.length; i++){
            HashMap<Integer, Integer> currmap = new HashMap();
            for(int j=0; j<i; j++){
                HashMap<Integer, Integer> prevmap = list.get(j);
                long differ = (long)nums[i]-(long)nums[j];
                if(differ<=Integer.MIN_VALUE || differ>=Integer.MAX_VALUE){
                    continue;
                }
                if(currmap.containsKey((int)differ)){
                    currmap.put((int)differ, currmap.get((int)differ)+1);
                }
                else{
                    currmap.put((int)differ, 1);
                }
                if(prevmap.containsKey((int)differ)){
                    ans+=prevmap.get((int)differ);
                    currmap.put((int)differ, prevmap.get((int)differ)+currmap.get((int)differ));
                }

            }
            list.add(currmap);
        }
        return ans;
    }
}
