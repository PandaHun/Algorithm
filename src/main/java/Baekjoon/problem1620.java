/*
 *  @Author: Pandahun
 *  @Content: 나는야 포켓몬 마스터 이다솜
 */

package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class problem1620 {

    public static void main( String[] args ) throws IOException, NumberFormatException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> poketmon = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String number = (i + 1) + "";
            String monster = br.readLine();
            poketmon.put(monster, number);
            poketmon.put(number, monster);
        }
        for (int i = 0; i < M; i++) {
            sb.append(poketmon.get(br.readLine())+"\n");
        }

        System.out.print(sb.toString());
    }
}
