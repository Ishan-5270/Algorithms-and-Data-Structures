package Leetcode;

import java.util.LinkedList;
import java.util.Queue;



public class RecentCounter {
    /*
     * We need to now think about the cases that can be considered -> 
     */
    /*
     * O(N) - populating the queues takes O(N) time and and while loop will give each eligible senator 
     * a chance to vote which would take another O(N) time 
     * O(N) Storing the index in the queue takes O(N) space and since it is only decreasing it will take O(N) spcae at most
     */
    public String predictPartyVictory(String senate) {
        Queue<Integer> queuer = new LinkedList<>();
        Queue<Integer> queued = new LinkedList<>();
        int n = senate.length();

        // now we need to traverse through the string 
        for (int i = 0; i < n; i++) {
           if (senate.charAt(i) == 'R'){
               // add to the respective queue 
               queuer.add(i);
           } else {
               queued.add(i);
           }
       }

           // now that the values are added we need to figure out what to do next 
           while(!queuer.isEmpty() && !queued.isEmpty()){
               // should not be or 
               int rTurn = queuer.poll();
               int dTurn = queued.poll();
               if (rTurn > dTurn){
                   // then we need to add r back and till gets removed 
                   queued.add(dTurn + n);
               } else {
                   queuer.add(rTurn + n);
               }
           }

           if (!queued.isEmpty()){
               return "Dire";
           } else {
               return "Radiant";
           }
         
    }
}
