package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem17825 {

    static int answer;
    static int[] dice, selected;
    static Space[] player = new Space[4];
    static Space start = new Space(0);

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        dice = new int[10];
        selected = new int[10];
        for (int i = 0; i < dice.length; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }
        initMap();
        selected[0] = 0;
        permutation(1);
        System.out.println(answer);
    }

    static void permutation(int depth) {
        if (depth == dice.length) {
            Arrays.fill(player, start);
            answer = Math.max(answer, solve());
            for (int i = 0; i < 4; i++) {
                player[i].isEmpty = true;
            }
            return;
        }

        for (int i = 0; i < player.length; i++) {
            selected[depth] = i;
            permutation(depth + 1);
        }
    }

    static int solve() {
        int ret = 0;
        Arrays.fill(player, start);
        for (int i = 0; i < dice.length; i++) {
            Space n = player[selected[i]];
            n.isEmpty = true;
            for(int j = 0 ; j < dice[i]; j++) {
                if ( j == 0 && n.before !=null) {
                    n = n.before;
                } else {
                    n = n.after;
                }
            }
            player[selected[i]] = n;
            if( !n.isEmpty && !n.isEnd) {
                return 0;
            } else {
                n.isEmpty = false;
                ret += n.value;
            }
        }
        return ret;
    }

    static void initMap() {
        Space n = start;
        n.isEnd = true;
        for (int i = 1; i < 21; i++) { // 가장자리 라인
            n = n.add(i << 1);
        }
        Space last = n;
        last.after = new Space(0);
        last.after.isEnd = true;
        last.after.after = last.after;

        ///////////////////////////
        n = start.of(5); // 5번째일때 꺾이는 라인

        n.before = new Space(13);
        n = n.before;

        n = n.add(16);
        n = n.add(19);
        n = n.add(25);
        Space center = n;

        n = n.add(30);
        n = n.add(35);
        n.after = last;

        ///////////////////////////
        n = start.of(10); // 10번째일때 꺾이는 라인

        n.before = new Space(22);
        n = n.before;

        n = n.add(24);
        n.after = center;

        ///////////////////////////
        n = start.of(15); // 15번째일때 꺾이는 라인
        n.before = new Space(28);
        n = n.before;
        n = n.add(27);
        n = n.add(26);
        n.after = center;
    }

    static class Space {
        int value;
        boolean isEmpty, isEnd;
        Space before, after;

        public Space(int value) {
            this.value = value;
            this.isEmpty = true;
            this.isEnd = false;
            before = null;
            after = null;
        }

        public Space add(int number) {
            Space temp = new Space(number);
            temp.isEmpty = true;
            this.after = temp;
            return temp;
        }

        public Space of(int number) {
            Space n = start;
            for (int i = 0; i < number; i++) {
                n = n.after;
            }
            return n;
        }
    }
}

