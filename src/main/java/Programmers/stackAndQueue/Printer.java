package Programmers.stackAndQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Printer {

    public static void main(String[] args) {
        int[] prior = {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution(prior, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> priorityQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int task : priorities)
            priorityQ.add(task);

        while(!priorityQ.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                if(priorities[i] == priorityQ.peek()) {
                    if(i == location) return answer;
                    priorityQ.poll();
                    answer++;
                }
            }
        }
        return answer;
    }
}
