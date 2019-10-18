package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 감시
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.List;

public class problem15683 {

    private static int N,M;
    private static int[][] office;
    private static List<Camera> cameraList;
    private static int answer = Integer.MAX_VALUE;

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cameraList = new LinkedList<>();
        office = new int[N][M];

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine(), " ");

            for(int k = 0; k <M; k++){
                office[i][k] = Integer.parseInt(st.nextToken());
                if(office[i][k] > 0 && office[i][k] < 6){
                    cameraList.add(new Camera(i, k , office[i][k]));
                }
            }
        }

        solve(0, office);
        System.out.println(answer);
    }

    static void solve(int depth, int[][] prev){
        int[][] origin = new int[N][M];
        if(depth == cameraList.size()){
            int cnt = 0;

            for(int  r = 0; r<N;r++){
                for(int c = 0 ; c<M;c++){
                    if(prev[r][c] == 0)
                        cnt++;
                }
            }

            answer = answer < cnt ? answer : cnt;
        }
        else{
            Camera now = cameraList.get(depth);
            switch (now.version) {
                case 1:
                    for(int k = 0; k < 4 ; k++){
                        for(int i = 0 ; i<N;i++) {
                            origin[i] = Arrays.copyOf(prev[i], M);
                        }
                        spread(origin, now, k);
                        solve(depth+1, origin);
                    }
                    break;
                case 2:
                    for(int k=0;k<2;k++){
                        for(int i = 0 ; i<N;i++) {
                            origin[i] = Arrays.copyOf(prev[i], M);
                        }
                        spread(origin,now, k);
                        spread(origin,now, k+2);
                        solve(depth+1, origin);
                    }
                    break;

                case 3:
                    for(int k=0 ; k < 4 ;k++){
                        for(int i = 0 ; i<N;i++) {
                            origin[i] = Arrays.copyOf(prev[i], M);
                        }
                        spread(origin, now, k);
                        spread(origin ,now, (k+1)%4);
                        solve(depth+1, origin);
                    }
                    break;
                case 4:

                    for(int k = 0 ; k<4 ;k++){
                        for(int i = 0 ; i<N;i++) {
                            origin[i] = Arrays.copyOf(prev[i], M);
                        }
                        spread(origin, now, k);
                        spread(origin ,now, (k+1)%4);
                        spread(origin ,now, (k+2)%4);
                        solve(depth+1, origin);
                    }
                    break;
                case 5:
                    for(int i = 0 ; i<N;i++)
                        origin[i] = Arrays.copyOf(prev[i], M);
                    spread(origin, now, 0);
                    spread(origin, now, 1);
                    spread(origin, now, 2);
                    spread(origin, now, 3);
                    solve(depth+1, origin);
                    break;
            }

        }
    }

    static void spread(int[][] origin, Camera camera, int direction){
        int r = camera.r;
        int c = camera.c;
        switch (direction){

            case 0:
                for(int i = c; i >=0; i--){
                    if(office[r][i] == 6)
                        break;

                    origin[r][i] = 9;
                }
                break;
            case 1:
                for(int i = r; i >=0; i--){
                    if(office[i][c] == 6)
                        break;

                    origin[i][c] = 9;
                }
                break;
            case 2:
                for(int i = c; i <M; i++){
                    if(office[r][i] == 6)
                        break;

                    origin[r][i] = 9;
                }
                break;
            case 3:
                for(int i = r; i <N; i++){
                    if(office[i][c] == 6)
                        break;

                    origin[i][c] = 9;
                }
                break;
        }

    }
}

class Camera{
    int r;
    int c;
    int version;
    public Camera(int r , int c, int version){
        this.r = r;
        this.c = c;
        this.version = version;
    }
}