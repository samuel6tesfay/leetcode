package leetcode.BinarySearch;

public class Search2DMatrix {

    public static void main(String[] args) {
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        int[][] matrix = {{1},{3},{5}};
        System.out.println(search2DMatrix.searchMatrix(matrix,5));
    }
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length,cols=matrix[0].length;

        int top=0,bottom=rows-1;

        while (top<=bottom){
            int row = (top+bottom)/2;
            if(target>matrix[row][cols-1]){
                top = row + 1;
            } else if (target<matrix[row][0]) {
                bottom = row - 1;
            }else {
                break;
            }
        }
        if (top>bottom){
            return false;
        }
        int row = (top+bottom)/2;
        int i=0,j=cols-1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] < target) i = mid + 1;
            else j = mid - 1;
        }
        return false;
    }
}
