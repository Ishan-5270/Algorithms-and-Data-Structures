package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public void helper(char[][] board, List<List<String>> allboards, int col){

        if (col == board.length){
            saveBoards(board, allboards);
            return; 
        }
        for (int row = 0; row < board.length; row++) {
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                helper(board, allboards, col+1);
                board[row][col] = '.'; 
            }
        }
    }
    
    private void saveBoards(char[][] board, List<List<String>> allboards) {
        String row = "";
        List<String> newboard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            row = "";
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q'){
                    row += 'Q';
                }
                else {
                    row += '.'; 
                }
            }
            newboard.add(row);
        }

        allboards.add(newboard);

    }

    private boolean isSafe(int row, int col, char[][] board) {
        // horizontal 
        for (int j = 0; j < board.length; j++) {
            if(board[row][j]=='Q'){
                return false; 
            }
        }

        // vertical 
         for (int i = 0; i < board[0].length; i++) {
            if(board[i][col]=='Q'){
                return false; 
            }
        }

        // upper left 
        int r =  row; 
        for(int c = col; c>=0 && r>=0; c--, r--){
            if(board[r][c]=='Q'){
                return false; 
            }
        } 

        // upper right
        r =  row; 
        for(int c = col; c<board.length && r>=0; c++, r--){
            if(board[r][c]=='Q'){
                return false; 
            }
        } 

        //lower left
        r =  row; 
        for(int c = col; r<board.length && c>=0; c--, r++){
            if(board[r][c]=='Q'){
                return false; 
            }
        }

        //lower right
        r =  row; 
        for(int c = col; r<board.length && c<board.length; c++, r++){
            if(board[r][c]=='Q'){
                return false; 
            }
        }

        return true; 
    }

    public List<List<String>> solveNQuene(int n){
        List<List<String>> allboards = new ArrayList<>();
        char[][] board = new char[n][n];

        helper(board, allboards, 0);
        return allboards; 
    }
}
