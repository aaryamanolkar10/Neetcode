class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        helper(nums,result,0);
        return result;
    }
    private void helper(int[] nums,List<List<Integer>> result,int start){
        if(start==nums.length){
            List<Integer> perms=new ArrayList<>();
            for(int  el:nums){
                perms.add(el);
            }
            result.add(perms);
            return;
        }
        for(int i=start;i<nums.length;i++){
            swap(nums,i,start);
            helper(nums,result,start+1);
            swap(nums,i,start);
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
