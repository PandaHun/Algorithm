package SWExpertAcademy;

import java.io.*;
import java.util.*;

public class problem7701 {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            Set<String> names = new TreeSet<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.length() != o2.length()) {
                        return o1.length() - o2.length();
                    }
                    return o1.compareTo(o2);
                }
            });
            for(int i = 0 ; i < n; i++ ) {
                names.add(br.readLine());
            }
            bw.write("#"+tc +"\n");
            for(String name : names) {
                bw.write(name +"\n");
            }
        }
        bw.flush();
    }
}
