package Programmers;

public class Carpet {
    class Solution {
        public int[] solution(int brown, int red) {
            int[] answer = new int[2];
            int sum = brown + red;
            for(int i=3;i<=sum;i++){
                int tmp = sum / i;
                if( (tmp-2) *(i-2) == red ){
                    answer[0] = i;
                    answer[1] = tmp;
                }

            }
            return answer;
        }
    }
}
