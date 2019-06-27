import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem1240 {
    public static void main(String[] args) throws NumberFormatException, IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());

        for (int testCase =1; testCase <=T; testCase++){
            System.out.println("In Case: " + testCase);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            boolean isFind = false;
            ArrayList<Integer> a = new ArrayList<>();
            for (int i=0; i<height; i++){
                String tempRow = br.readLine();
                for (int j = width-1; j>=0; j--){
                    if (!isFind && tempRow.charAt(j)=='1'){
                        int value = 0;
                        switch (tempRow.substring(j-6, j)){
                            case "0001101" : value = 0; break;
                            case "0011001" : value = 1; break;
                            case "0010011" : value= 2; break;
                            case "0111101" : value= 3; break;
                            case "0100011" : value= 4; break;
                            case "0110001" : value= 5; break;
                            case "0101111" : value= 6; break;
                            case "0111011" : value= 7; break;
                            case "0110111" : value= 8; break;
                            case "0001011" : value= 9; break;
                            default : value = -1;
                        }
                        a.add(value);
                        j-=6;
                    }

                }
            }
            int result = 0;
            int answer =0;
            int clearAnswer =0;
            if(!a.isEmpty()){
                for(int i=0;i<a.size() ; i++){
                    if (i%2==0)
                        result +=a.get(i)*3;
                    else
                        result +=a.get(i);
                    answer +=a.get(i);
                }
                if( result%10==0){
                    clearAnswer = answer;
                }
            }
            System.out.println("#" + testCase +" " + clearAnswer);
        }
    }
}
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int z = 1; z <= T; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            boolean flag = false;
            boolean flag2 = true;
            char[] arr = new char[M];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M && flag2; j++) {
                    if (line.charAt(j) == '1') {
                        flag = true;
                    }
                    if (flag) {
                        arr[j] = line.charAt(j);
                        cnt++;
                    }
                }
                if (cnt > M * 2) {
                    flag = false;
                    flag2 = false;
                }
            }

            int idx = 0;
            for (int i = M - 1; i >= 0; i--) {
                if (arr[i] == '1') {
                    idx = i;
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]);
            }
            String line = sb.toString();
            ArrayList<Integer> lst = new ArrayList<Integer>();
            for (int i = 8; i >= 1; i--) {
                String tmp = line.substring(idx - i * 7 + 1, idx - (i - 1) * 7 + 1);
                switch (tmp) {
                case "0001101":
                    lst.add(0);
                    break;
                case "0011001":
                    lst.add(1);
                    break;
                case "0010011":
                    lst.add(2);
                    break;
                case "0111101":
                    lst.add(3);
                    break;
                case "0100011":
                    lst.add(4);
                    break;
                case "0110001":
                    lst.add(5);
                    break;
                case "0101111":
                    lst.add(6);
                    break;
                case "0111011":
                    lst.add(7);
                    break;
                case "0110111":
                    lst.add(8);
                    break;
                case "0001011":
                    lst.add(9);
                    break;

                }
            }

            int odd = 0;
            int even = 0;
            int sum = 0;
            for (int i = 0; i < lst.size(); i++) {

                sum += lst.get(i);
                if (i == lst.size() - 1)
                    break;
                if ((i + 1) % 2 == 0) {
                    even += lst.get(i);
                } else {
                    odd += lst.get(i);
                }
            }
            boolean isValid = false;

            if ((even + odd * 3 + lst.get(7)) % 10 == 0) {
                isValid = true;
            }

            if (isValid) {
                System.out.println("#" + z + " " + sum);
            } else {
                System.out.println("#" + z + " 0");
            }

        }

    }

}
*/
