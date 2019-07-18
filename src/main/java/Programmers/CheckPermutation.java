package Programmers;
/*
https://programmers.co.kr/learn/courses/18/lessons/1877
 */
import java.util.Arrays;
public class CheckPermutation {
    public boolean solution(int[] arr) {
        boolean answer = true;
        Arrays.sort(arr);
        int cnt = 1;
        for (int i = 0;i<arr.length-1;i++){
            if(arr[i] != i+1 )
                answer =false;
        }

        return answer;
    }

    public static void main(String[] args){
        int[] arr = {4,1,3};
        CheckPermutation cp = new CheckPermutation();
        System.out.print(cp.solution(arr));
    }
}
