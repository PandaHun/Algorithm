package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 신입사원
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class problem1946 {

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int TestCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TestCase; tc++) {
            int number = Integer.parseInt(br.readLine());
            List<Applicant> applicants = new ArrayList<>();
            for (int i = 0; i < number; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int paper = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                applicants.add(new Applicant(paper, interview));
            }
            Collections.sort(applicants);

            int answer = number;
            int interview = applicants.get(0).intrerviewScore;
            for (int i = 1; i < number; i++) {
                int currents = applicants.get(i).intrerviewScore;
                if (interview < currents) {
                    answer--;
                }
                if (currents < interview) {
                    interview = currents;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}

class Applicant implements Comparable<Applicant> {
    int paperScore;
    int intrerviewScore;

    public Applicant( int paperScore, int intrerviewScore ) {
        this.paperScore = paperScore;
        this.intrerviewScore = intrerviewScore;
    }

    @Override
    public int compareTo( Applicant o1 ) {
        return this.paperScore > o1.paperScore ? 1 : -1;
    }
}