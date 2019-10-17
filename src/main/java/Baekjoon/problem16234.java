package Baekjoon;

import java.io.*;
import java.util.*;

public class problem16234 {
    static int n, L ,R, ANS;
    static int[][] arr;
    static int[] dx = {0, 0 , -1, 1};
    static int[] dy = {-1, 1, 0 , 0};
    static boolean[] visited;
    static ArrayList<Integer> track;

    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        ANS = -1;
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;
        while(flag){
            visited = new boolean[n * n];
            Queue<Integer> q= new LinkedList<>();
            flag = false;
            ANS++;

            for(int i = 0 ; i<n*n;i++){
                if(visited[i]) {
                    continue;
                }

                track = new ArrayList<>();
                int r = i/n;
                int c = i%n;

                q.add(i);
                visited[i]= true;
                track.add(i);

                int total = arr[r][c];
                int cnt = 1;

                while(!q.isEmpty()){
                    int v = q.poll();
                    r = v/n;
                    c = v%n;

                    for(int j=0;j<4;j++){
                        int nr = r + dy[j];
                        int nc = c + dx[j];

                        if( nr>=0 && nc>=0 && nr<n && nc<n){
                            int next = nr*n + nc;
                            if (visited[next]){
                                continue;
                            }

                            int value = arr[nr][nc];
                            int pivot = arr[r][c];
                            if( L<= Math.abs(value - pivot) && Math.abs(value - pivot) <=R){
                                flag = true;
                                q.add(next);
                                visited[next] = true;
                                track.add(next);
                                total+=arr[nr][nc];
                                cnt++;
                            }
                        }
                    }
                }
                int update =  total/cnt;
                if(track.size()>1){
                    for( int v : track){
                        r = v/n;
                        c = v%n;
                        arr[r][c] = update;
                    }
                }

            }
        }

        System.out.println(ANS);
    }
}
