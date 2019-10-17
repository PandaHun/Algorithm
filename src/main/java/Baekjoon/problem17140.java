package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 이차원 배열과 연산
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem17140 {

    private static int[][] arr, nArr;
    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken())-1;
        int C = Integer.parseInt(st.nextToken())-1;
        int K = Integer.parseInt(st.nextToken());

        arr = new int[3][3];
        for(int i = 0; i <3;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < 3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int second = -1;
        int[] cnt;
        while(second++ <= 100){

            if(second > 100){
                System.out.println(-1);
                return;
            }

            if(R < arr.length && C < arr[0].length && arr[R][C] == K){
                    break;
            }

            int r = arr.length;
            int c = arr[0].length;
            nArr = new int[101][101];

            // R연산
            if(r >= c) {

                int max = Integer.MIN_VALUE;

                for(int i = 0 ; i<r;i++){
                    cnt = new int[101];
                    for(int j = 0 ; j<c;j++){
                        if(arr[i][j] == 0 ) continue;
                        int n = arr[i][j];
                        cnt[n] ++;
                    }

                    List<Numbers> list = new ArrayList<>();

                    for(int j = 1 ; j<cnt.length;j++){
                        if(cnt[j] !=0)
                            list.add(new Numbers(j, cnt[j]));
                    }

                    Collections.sort(list);
                    int index = 0;
                    for(int j=0;j<list.size();j++){
                        nArr[i][index++] = list.get(j).number;
                        nArr[i][index++] = list.get(j).count;
                    }

                    if(max < list.size()*2)
                        max = list.size()*2;
                }
                if(max > 100)
                    max = 100;
                arr = new int[r][max];
                for(int i = 0 ; i<r;i++){
                    for(int j = 0 ; j<max;j++){
                        arr[i][j] = nArr[i][j];
                    }
                }
            }else{
                int max = Integer.MIN_VALUE;

                for(int i = 0 ; i<c;i++){
                    cnt = new int[101];
                    for(int j = 0 ; j<r;j++){
                        if(arr[j][i] == 0 ) continue;
                        int n = arr[j][i];
                        cnt[n] ++;
                    }

                    List<Numbers> list = new ArrayList<>();

                    for(int j = 1 ; j<cnt.length;j++){
                        if(cnt[j] !=0)
                            list.add(new Numbers(j, cnt[j]));
                    }

                    Collections.sort(list);
                    int index = 0;
                    for(int j=0;j<list.size();j++){
                        nArr[index++][i] = list.get(j).number;
                        nArr[index++][i] = list.get(j).count;
                    }

                    if(max < list.size()*2)
                        max = list.size()*2;
                }
                if(max > 100)
                    max = 100;

                arr = new int[max][c];
                for(int i = 0 ; i<arr.length;i++){
                    for(int j = 0 ; j<arr[0].length;j++){
                        arr[i][j] = nArr[i][j];
                    }
                }
            }
        }
        System.out.println(second);
    }


    static class Numbers implements Comparable<Numbers>{
        int number;
        int count;

        public Numbers(int number, int count){
            this.number = number;
            this.count  = count;
        }

        @Override
        public int compareTo(Numbers o){
            if(this.count == o.count)
                return this.number < o.number ? -1: 1;

            return this.count < o.count ? -1 : 1;
        }
    }
}

