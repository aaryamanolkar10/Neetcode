class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),result);
        return result;
    }
    private void backtrack(int[] num,int index,List<Integer> current,List<List<Integer>> result){
        result.add(new ArrayList<>(current));
        for(int i=index;i<num.length;i++){
            current.add(num[i]);
            backtrack(num,i+1,current,result);
            current.remove(current.size()-1);
        }

    }
}
