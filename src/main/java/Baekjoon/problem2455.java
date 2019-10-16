package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 지능형 기차
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2455 {

    private static int[] peoples = new int[4];
    private static int answer = Integer.MIN_VALUE;
    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer.parseInt(st.nextToken());

        int getOff;
        int getOn = Integer.parseInt(st.nextToken());
        peoples[0] = getOn;
        for(int r= 1; r<4;r++){
            st = new StringTokenizer(br.readLine(), " ");
            getOff = Integer.parseInt(st.nextToken());
            getOn = Integer.parseInt(st.nextToken());
            peoples[r] = peoples[r-1] + getOn - getOff;
        }

        for(int people : peoples){
            answer = answer > people ? answer : people;
        }

        System.out.println(answer);
    }
}
