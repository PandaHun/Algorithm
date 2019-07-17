import java.util.*;
import java.io.*;

public class SDS_Level1 {
    /*Declare Line*/
    static int T;
    static int N;
    static int K;
    public static void main(String[] args) throws NumberFormatException, IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        int[] answer = new int[T];

        for (int i=1;i<=T ;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int[] card = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                card[j] = Integer.parseInt(st.nextToken());
            }
            int[] count = new int[K+1];
            for (int j=0;j<N;j++){
                for (int x=0;x<=K; x++){
                    if (card[j] == x) {
                        count[x]++;
                        break;
                    }
                }
            }

            if (count[0] == 0){
                Arrays.sort(count);
                answer[i-1] = count[count.length-1];
            }
            else if (count[0] == N && K !=1){
                answer[i-1] = N-K+1;
            }
            else if (count[0] ==N && K == 1){
                answer[i-1] = N;
            }
            Stack<Integer> stack = new Stack<>();
        }


        /*Output Line*/
        for (int i=1;i<=T;i++){
            System.out.println("#" + i +" "+answer[i-1]);
        }
    }
}
