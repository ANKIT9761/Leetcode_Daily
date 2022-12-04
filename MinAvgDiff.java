// link- https://leetcode.com/problems/minimum-average-difference/description/

class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n=nums.length;
    
        if(n==1)return 0;
        long right=0,left=0;
    
        int ans=0;
        long mina=100001;
        for(Integer i:nums){right+=i;}

        for(int i=0; i<n; i++){
            left+=nums[i];
            right-=nums[i];
            long avl=left/(i+1);
            long avr=0;
            if(i!=n-1){
                avr=right/(n-1-i);
            }
            if(Math.abs(avl-avr)<mina)
            {
            mina=Math.abs(avl-avr);
            ans=i;
            }
        }
    
        return ans;
    }
}
