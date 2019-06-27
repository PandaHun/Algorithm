import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class problem1285
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int answer[][] = new int[T][2];
        for(int repeat=0 ; repeat< T; repeat++){
            int N = Integer.parseInt((br.readLine()));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int position[] = new int[N];
            for(int i=0;i<N;i++)
            	position[i] = Math.abs(Integer.parseInt(st.nextToken()));
            Arrays.sort(position);
            int min = position[0];
            int per = 1;
            for(int i=1;i<N;i++){
            	if(min==position[i])
            		per++;
            	else if (position[i]>min)
            		break;
            }
            answer[repeat][0] = min;
            answer[repeat][1] = per;
        }
        for(int i=0;i<T;i++){
        	System.out.println("#"+(i+1)+" "+answer[i][0]+" "+answer[i][1]);
        }
	}
}