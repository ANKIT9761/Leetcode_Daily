// link- https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/

class Solution {
    private class Job{
       private int startTime;
       private int endTime;
       private int profit;
       public Job(int st,int et,int p){
           this.startTime  = st;
           this.endTime = et;
           this.profit = p;
       } 
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
      List<Job>jobs = new ArrayList<>();
       for(int i = 0;i<startTime.length;i++){
           jobs.add(new Job(startTime[i],endTime[i],profit[i]));
       } 
     Collections.sort(jobs,(a,b) -> (a.endTime - b.endTime));
        TreeMap<Integer,Integer>map = new TreeMap<>();
        int ans = 0;
        for(Job currjob : jobs){
            Integer entryTillStartTime = map.floorKey(currjob.startTime);
            int maxProfitTillStartTime = entryTillStartTime == null ? 0 :map.get(entryTillStartTime);
            ans = Math.max(ans,maxProfitTillStartTime + currjob.profit);
            map.put(currjob.endTime,ans);
        }
        return ans;
    }
}

// Second Approach
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        //sort the jobs by ending times
        Job[] jobs = new Job[startTime.length];
        for(int i=0; i<startTime.length; i++){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs);
        
        int[] dp = new int[jobs.length];
        dp[0] = jobs[0].p;
        for(int i=1; i<jobs.length; i++){
            // take max of incl jobs[i] and not incl jobs[i];
            dp[i] = dp[i-1];
            for(int j=i-1; j>=0; j--){
                if(jobs[i].s>=jobs[j].e){          // find latest job which doesn't overlap
                    dp[i] = Math.max(dp[i], dp[j]+jobs[i].p);
                    break;
                }
                dp[i] = Math.max(dp[i], jobs[i].p); // case when jobs[i] overlaps with all 0,i-1
            }
        }
        return dp[dp.length-1];
        
    }
    public class Job implements Comparable<Job>{
        int s;
        int e;
        int p;
        public Job(int s, int e, int p){
            this.s = s;
            this.e = e;
            this.p = p;
        }
        public int compareTo(Job that){
            return this.e<that.e ? -1 : 1;
        }
        public String toString(){
            return s+","+e;
        }
    }
}
