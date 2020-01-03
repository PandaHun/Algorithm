package Programmers.stackAndQueue;

public class Top {

    public static void main(String[] args) {
        int[] heights = {6, 9, 5, 7, 4};
        int[] answer = solution(heights);
        for(int i : answer) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        answer[0] = 0;
        for(int i = 1; i < answer.length; i++) {
            for( int j = i-1 ; j>=0; j--) {
                if (heights[j] > heights[i]) {
                    answer[i] = j+1;
                    break;
                }
            }
        }
        return answer;
    }
}
