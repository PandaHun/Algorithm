import java.util.Scanner;

public class problem1936{
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int a = sc.nextInt();
      int b = sc.nextInt();
    	if((a-b)==1 || (a-b)==-2){
        System.out.print("A");
      }
      else
        System.out.print("B");
	}
}
