class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,target,new ArrayList<>(),result);
        return result;
    }
    private void backtrack(int[] candidates,int start,int target,List<Integer> list,List<List<Integer>> result){
        if(target<0) return;

        if(target==0){
            result.add(new ArrayList<>(list));
        }
        for(int i=start;i<candidates.length;i++){

            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }
            if(target-candidates[i]<0){
                break;
            }

            list.add(candidates[i]);

            backtrack(candidates,i+1,target-candidates[i],list,result);

            list.remove(list.size()-1);
        }
    }
}
