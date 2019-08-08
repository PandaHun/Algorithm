package SWExpertAcademy;

import java.io.*;
import java.util.*;

public class probelm7733 {

    static int[][] MAP;
    static boolean[][] visited;
    static int day;
    static int cnt;
    static int N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main( String[] args ) throws IOException, NumberFormatException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T;tc++){
            N = Integer.parseInt(br.readLine());
            MAP = new int[N][N];
            int answer = 1;
            int max = 0;
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine() , " ");
                for(int j=0;j<N;j++){
                    MAP[i][j] = Integer.parseInt(st.nextToken());
                    max = MAP[i][j] > max ? MAP[i][j] : max;
                }
            }
            day = 1;
            while(day<=max){
                cnt = 0;
                visited = new boolean[N][N];
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if( MAP[i][j] > day && !visited[i][j]){
                            dfs(i,j);
                            cnt++;
                        }
                    }
                }
                answer = answer > cnt ? answer : cnt;
                day++;
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int y, int x){
        visited[y][x] = true;

        for(int i=0;i<4;i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if( nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                if (MAP[nextY][nextX] == 0)
                    continue;

                if (!visited[nextY][nextX] && MAP[nextY][nextX] > day)
                    dfs(nextY, nextX);
            }
        }
    }
}
