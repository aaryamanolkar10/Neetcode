class Solution {
    public boolean hasDuplicate(int[] nums) {
        ArrayList<Integer> hash=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(hash.contains(nums[i])){
                return true;
            }
            else{
                hash.add(nums[i]);
            }
        }
        return false;
    }
}