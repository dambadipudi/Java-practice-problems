import java.util.*;

class MatrixManipulation {

 /** Given a matrix of n*n size, the task is to print its elements in diagonally pattern.
   *  Input : mat[3][3] = {{1, 2, 3},
   *                       {4, 5, 6},
	 *                       {7, 8, 9}}
   *   Output : 1 2 4 7 5 3 6 8 9.
   *   Explanation: We start from 1 
   *   Then from upward to downward diagonally i.e. 2 and 4
   *   Then from downward to upward diagonally i.e 7,5,3 
   *   Then from up to down diagonally i.e  6, 8 
   *   Then down to up i.e. end at 9.
   *
   *   Input : mat[4][4] =  {{1,  2,  3,  10},
   *                   {4,  5,  6,  11},
   *                   {7,  8,  9,  12},
   *                   {13, 14, 15, 16}}
   *   Output:  1 2 4 7 5 3 10 6 8 13 14 9 11 12 15 16 .
   *
   **/
    public void printMatrixDiagonally(int matrix[][]) {
      int N = matrix.length;
      //Create another list of length is (2*N - 1) that contains another ArrayDeque (that can act as a stack and queue)
      List<ArrayDeque<Integer>> diagonalList = new ArrayList<ArrayDeque<Integer>>();

      for(int diagRow = 0; diagRow < (2*N - 1); diagRow ++) {
        diagonalList.add(new ArrayDeque<Integer>());	
      }

      for(int row = 0; row < matrix.length ; row ++) {
        for(int column = 0; column < matrix[row].length; column ++) {
          int diagIndex = row + column;
          if(diagIndex % 2 == 0) { //Add as a stack
            diagonalList.get(diagIndex).addFirst(matrix[row][column]);
          }
          else { //Add as a queue
            diagonalList.get(diagIndex).addLast(matrix[row][column]);
          }
        }	
      }

      for(int diagRow = 0; diagRow < (2*N - 1); diagRow ++) {
        for(Integer dequeElem : diagonalList.get(diagRow)) {
          System.out.println(dequeElem + " ");
        }
      }
    }
  }

public class Matrix {
	public static void main(String args[]) throws Exception {
		int matrix[][] = {{1,2,3,10},
                                  {4,5,6,11},
				  {7,8,9,12},
			 	  {13,14,15,16}}; //Array of arrays
		(new MatrixManipulation ()).printMatrixDiagonally(matrix);
	}
}
