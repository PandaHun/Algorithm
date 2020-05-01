package SWExpertAcademy;

import java.io.*;

public class problem4366 {

    static String binary, trie;
    static int[] two, three;
    static int answer;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            binary = br.readLine();
            trie = br.readLine();
            two = new int[binary.length()];
            three = new int[trie.length()];
            answer = 0;
            for (int i = 0; i < two.length; i++) {
                two[i] = binary.charAt(i) - '0';
            }
            for (int i = 0; i < three.length; i++) {
                three[i] = trie.charAt(i) - '0';
            }
            solve();
            bw.write("#" + tc + " " + answer +"\n");
        }
        bw.flush();
    }

    static void solve() {
        int[] convertBinary = binaryToRight();
        int[][] convertTrie = trieToRight();
        for (int i = 0; i < convertBinary.length; i++) {
            for (int j = 0; j < 2; j++ ) {
                for (int k = 0; k < three.length; k++) {
                    if(convertBinary[i] == convertTrie[k][j]) {
                        answer = convertBinary[i];
                        return;
                    }
                }
            }
        }
    }

    static int[] binaryToRight() {
        int[] res = new int[two.length];
        for (int i = 0; i < two.length; i++) {
            int t = two[i];
            if (two[i] == 0) {
                two[i] = 1;
            } else {
                two[i] = 0;
            }
            res[i] = toDecimal(two, 2);
            two[i] = t;
        }
        return res;
    }

    static int[][] trieToRight() {
        int[][] res = new int[three.length][2];
        for (int i = 0; i < three.length; i++) {
            int t = three[i];
            for (int j = 0; j < 2; j++) {
                if (three[i] == 0) {
                    three[i] = 1;
                } else if (three[i] == 1) {
                    three[i] = 2;
                } else {
                    three[i] = 0;
                }
                res[i][j] = toDecimal(three, 3);
            }
            three[i] = t;
        }
        return res;
    }


    static int toDecimal(int[] value, int flag) {
        int res = 0;
        for(int i = 0 ; i < value.length; i++) {
            res += (int) Math.pow(flag, value.length - 1 - i) * value[i];
        }
        return res;
    }
}
