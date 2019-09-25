package Programmers;
/*
https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
 */
public class TargetNumber {
    static int length;
    static int answer;

    public static void main( String[] args ) {
        int[] numbers = {1,1,1,1,1};
        int taget = 3;
        System.out.println(solution(numbers, taget));
    }
    public static int solution(int[] numbers, int target) {
        answer = 0;
        length = numbers.length;
        solve(numbers, 0, numbers[0], target);
        solve(numbers, 0, -1*numbers[0], target);
        return answer;
    }
    static void solve(int[] numbers, int depth, int sum, int target){
        if (depth ==length-1){
            if(sum == target) {
                answer++;
            }
            return ;
        }

        solve(numbers, depth+1, sum + numbers[depth+1], target );
        solve(numbers, depth+1, sum - numbers[depth+1], target );
    }
}