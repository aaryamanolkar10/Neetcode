class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen=new HashSet();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char curr=board[i][j];
                if(curr!='.'){
                    if(!seen.add(curr + "found at row" + i) ||
                    !seen.add(curr + "found at column" + j) ||
                    !seen.add(curr + "found in box" + i/3 + '-' + j/3)
                    )
                    return false;
                }
            }
        }
        return true;
    }
}
