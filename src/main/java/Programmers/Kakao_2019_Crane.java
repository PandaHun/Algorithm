package Programmers;

import java.util.Stack;

public class Kakao_2019_Crane {

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> dolls = new Stack<>();
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    int t = board[i][move - 1];
                    board[i][move - 1] = 0;
                    if (!dolls.isEmpty() && dolls.peek() == t) {
                        dolls.pop();
                        answer += 2;
                    } else {
                        dolls.push(t);
                    }
                    break;
                }
            }
        }
        return answer;
    }
}
