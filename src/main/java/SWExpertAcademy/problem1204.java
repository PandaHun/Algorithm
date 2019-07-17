import java.util.*;
import java.io.*;
public class problem1204{
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++){
		    br.readLine();
		    int[] score = new int[101];
		    int answer = 0;
		    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		    while(st.hasMoreTokens()){
		        int num = Integer.parseInt(st.nextToken());
		        score[num]++;
            }
		    for (int j=0;j<101;j++){
		        if ( score[answer] <= score[j])
		            answer = j;
            }

		    System.out.println("#"+ i+ " "+ answer);
        }
    }
}
