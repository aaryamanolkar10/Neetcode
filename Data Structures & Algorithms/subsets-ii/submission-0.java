class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,new ArrayList<>(),result);
        return result;
    }
    private void backtrack(int[] num,int index,List<Integer> current,List<List<Integer>> result){
        if(result.contains(current)) return;
        result.add(new ArrayList<>(current));
        for(int i=index;i<num.length;i++){
            current.add(num[i]);
            backtrack(num,i+1,current,result);
            current.remove(current.size()-1);
        }

    }
}
