public class PathsinMaze {

    public static int countpaths(int i, int j, int n, int m){

        if (i >= n || i >= m){
            return 0; 
        }

        if (i == n-1 && j == m-1) {
            return 1; 
        }
        //move down
        int downpath = countpaths(i+1, j, n, m); 

        // move right 
        int rightpath = countpaths(i, j+1, n, m);

        return downpath + rightpath; 

    }

    public static void main(String[] args) {
        int n = 3; 
        int m = 3; 
        int totalPaths = countpaths(0, 0, n, m); 
        System.out.println(totalPaths);

    }
}
