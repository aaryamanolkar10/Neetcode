class Solution {
    public List<Integer> partitionLabels(String str) {
        List<Integer> partitions=new ArrayList<>();

        for(int i=0;i<str.length();){
            
            int start=i;
            int end=str.lastIndexOf(str.charAt(start));

            for(int s=start+1;s<=end;s++){
                int lastIndexOfNextChar=str.lastIndexOf(str.charAt(s));

                if(lastIndexOfNextChar > end){
                    end=lastIndexOfNextChar;
                }
            }
            partitions.add(end-start+1);
            i=end+1;
        }
        return partitions;
    }
}
