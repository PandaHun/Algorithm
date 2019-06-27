import java.util.Scanner;

public class problem2019{
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
      int x =1;
      for(int i=0; i<=n;i++){
          if(i==0){
            System.out.print(x +" ");
          }
          else{
            x = x*2;
            System.out.print(x +" ");
          }
      }
	}
}
