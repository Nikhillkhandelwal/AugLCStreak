class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer>currRow=new ArrayList<>();
            for(int col=0;col<=i;col++){
                if(col==0||col==i){
                    currRow.add(1);
                }
                else{
                    int val=triangle.get(i-1).get(col-1)+triangle.get(i-1).get(col);
                    currRow.add(val);
                }
                
            }
            triangle.add(currRow);
            
        }
        return triangle;
        
        
        
    }
}
