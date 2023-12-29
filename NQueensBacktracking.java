import java.util.Scanner;

public class NQueensBacktracking {

    private static boolean isSafe(int[][] board, int row, int col, int N) {
        // checking if the row we are placing is safe
        for (int i = 0; i < N; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // checking if the col we are placing is safe
        for (int i = 0; i < N; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        //checking if the upper-left daigonal is safe
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        //checking if the lower-right diagonal is safe
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // others diagonals need not to check since we are placing from left to right

        return true;
    }

    private static boolean solveNQueensUtil(int[][] board, int col, int N) {
        if (col >= N) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col, N)) {
                board[i][col] = 1;
                if (solveNQueensUtil(board, col + 1, N)) {
                    return true;
                }
                board[i][col] = 0; // Backtrack 
            }
        }
        return false;
    }

    public static boolean solveNQueens(int N) {
        int[][] board = new int[N][N];
        if (!solveNQueensUtil(board, 0, N)) {
            return false;
        }
        displayBoard(board, N);
        return true;
    }

    public static void displayBoard(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int N = scanner.nextInt();
        long startTime = System.nanoTime();
        boolean solutionExists = solveNQueens(N);
        long endTime = System.nanoTime();
        if (!solutionExists) {
            System.out.println("No solution exists for N = " + N);
        }
        double timeElapsed = (endTime - startTime) / 1e6; // Convert nanoseconds to milliseconds
        System.out.println("\nTime complexity: " + timeElapsed + " milliseconds");
        scanner.close();
    }

}
