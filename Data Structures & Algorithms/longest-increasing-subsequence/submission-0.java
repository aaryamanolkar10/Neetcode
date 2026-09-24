class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];

        Arrays.fill(dp,1);
        //main pointer
        for(int i=1;i<nums.length;i++){

            //second pointer
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                    }
                }
            }
        }

        //storing max value
        int max=0;
        //finding the max length of subsequence
        for(int i=0;i<dp.length;i++){
            if(dp[i]>max) max=dp[i];
        }
        return max;
    }
}
