class Solution {
    List<String> result=new ArrayList<>();
    String[] mapping=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)return result;
        dfs(0,digits,new StringBuilder());
        return result;
    }
    private void dfs(int length,String digits,StringBuilder temp){
        if(length==digits.length()){
            result.add(temp.toString());
            return;
        }
        char ch=digits.charAt(length);
        String str=mapping[ch-'0'];
        for(char c:str.toCharArray()){
            temp.append(c);
            dfs(length+1,digits,temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
