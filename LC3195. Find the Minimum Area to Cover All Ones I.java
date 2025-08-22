class Solution {
    public int minimumArea(int[][] grid) {
        int n=grid.length;
        int minRow=Integer.MAX_VALUE;
        int minCol=Integer.MAX_VALUE;
        int maxRow=Integer.MIN_VALUE;
        int maxCol=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    minRow=Math.min(i,minRow);
                    minCol=Math.min(j,minCol);
                    maxCol=Math.max(j,maxCol);
                    maxRow=Math.max(i,maxRow);
                }
            }
        }
        return (maxRow-minRow +1)*(maxCol-minCol+1);
        
    }
}
