package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem1527 {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] gold = {4, 7};

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        for(int i = 0; !q.isEmpty(); i++) {
            int qSize = q.size();
            for(int j = 0; j < qSize ;j++) {
                int number = q.poll();

                for(int k = 0; k < 2; k++) {
                    int next = (int)(number + (gold[k] * Math.pow(10, i)));
                    if( A <= next && next <= B) {
                        answer++;
                    }
                    if(next <=B) {
                        q.add(next);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
