package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 멀티탭 스케쥴링
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class problem1700 {

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] jobs = new int[K];
        for (int i = 0; i < K; i++)
            jobs[i] = Integer.parseInt(st.nextToken());

        List<Integer> consents = new ArrayList<>();

        int answer = 0;
        for (int i = 0; i < K; i++) {
            int current = jobs[i];

            if (consents.contains(current)) {
                continue;
            }
            if (consents.size() < N) {
                consents.add(current);
                continue;
            }

            answer++;

            int farAway = 0, port = 0;

            for(int idx = 0 ; idx<consents.size();idx++){
                int distance = Integer.MAX_VALUE;

                for(int sub = i+1; sub < K; sub++){
                    if(consents.get(idx) == jobs[sub]){
                        distance = sub;
                        break;
                    }
                }
                if(farAway < distance){
                    farAway = distance;
                    port = idx;
                }
            }
            consents.set(port, jobs[i]);
        }
        System.out.println(answer);
    }
}