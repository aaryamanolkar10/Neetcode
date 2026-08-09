class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> freq=new HashSet<>();
        for(int num:nums){
            if(freq.contains(num)){
                return num;
            }
            freq.add(num);
        }
        return -1;
    }
}
