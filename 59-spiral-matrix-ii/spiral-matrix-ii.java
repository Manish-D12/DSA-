class Solution {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) m[top][j] = num++;     
            top++;
            for (int i = top; i <= bottom; i++) m[i][right] = num++;    
            right--;
            for (int j = right; j >= left; j--) m[bottom][j] = num++;   
            bottom--;
            for (int i = bottom; i >= top; i--) m[i][left] = num++;     
            left++;
        }
        return m;
    }
}