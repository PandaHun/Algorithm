package Programmers;
/*
https://programmers.co.kr/learn/courses/18/lessons/1876
 */
public class DigitSum {
    public int solution(int n) {
        int answer = 0;
        while(n>0){
            answer += n%10;
            n = n/10;
        }
        return answer;
    }

    public static void main(String[] args){
        DigitSum ds = new DigitSum();
        System.out.print(ds.solution(123));
    }
}
