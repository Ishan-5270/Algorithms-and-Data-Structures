package Leetcode;

public class ReorderRoutes {
    public int minReorder(int n, int[][] connections) {
        /*
         * We can perform a dfs traveral here as well
         */

         int length = connections.length;
         boolean visit[] = new boolean[length];
         int reorder = 0; 
         for (int i = 0; i < length; i++) {
            if (!visit[i]){
                dfs(connections, visit, reorder);
            }
         }


    }

    private void dfs(int[][] connections, boolean[] visit, int reorder) {
        visit[reorder] = true;
        // now we traverse through the edges of 0
    }
}
