package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 모든 순열
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem10974 {

    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int [N];
        int[] out = new int [N];
        boolean[] visit = new boolean[N];
        for(int i = 0; i <N;i++){
            array[i] = i+1;
        }

        permutation(array, out, visit,0, N, N);
    }

    static void permutation(int[] array, int[] out, boolean[] visit, int cnt, int n, int k){

        if(cnt == k){
            print(out);
            return;
        }

        for(int  i = 0; i <n;i++){

            if(!visit[i]){
                visit[i] = true;
                out[cnt] = array[i];
                permutation(array, out, visit, cnt+1, n,k);
                visit[i] = false;
            }
        }


    }

    static void swap(int[] arr, int n, int i){
        int temp = arr[n];
        arr[n] = arr[i];
        arr[i] = temp;
    }

    static void print(int[] array){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < array.length;i++){
            sb.append(array[i]).append(" ");
        }
        sb.append("\n");
        System.out.print(sb.toString());
    }
}
