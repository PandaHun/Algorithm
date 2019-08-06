package Baekjoon;

import java.io.*;
import java.util.*;
public class problem14890 {
    static int N, L;
    static int[][] map;
    static int answer;

    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        answer =0;
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0;i<N;i++){
            if( solve(map[i]))
                answer++;
            int[] temp = new int[N];
            for(int j=0;j<N;j++){
                temp[j] = map[j][i];
            }
            if( solve(temp))
                answer ++;
        }
        System.out.println(answer);

    }
    static boolean solve(int[] arr){
        int idx = 0;
        boolean[] visited = new boolean[N];

        while(true) {
            // 끝까지 도달.
            if(idx == N-1) break;

            // 내려가는 경사로인 경우
            if(arr[idx+1] == arr[idx] - 1) {
                if(idx + L >= N ) return false;

                for (int i = idx+1; i <= idx+L; i++) {
                    visited[i] = true;
                    if(arr[i] != arr[idx] -1)
                        return false;
                }
                idx += L;
            }
            // 올라가는 경사로인 경우
            else if(arr[idx+1] == arr[idx] + 1) {
                if( idx - (L-1) < 0 ) return false;

                for (int i = idx-(L-1); i <= idx; i++) {
                    if(visited[i] || arr[i] != arr[idx])
                        return false;
                }
                idx++;
            }
            // 평지인 경우
            else if(arr[idx] == arr[idx+1]) {
                idx++;
            }
            // 높이 차이가 2 이상인 경우, 못지나감.
            else {
                return false;
            }
        }
        return true;
    }
}
