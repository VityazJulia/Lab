import java.util.Scanner;
public class Program {
	public static void main(String[] args) { Scanner in = new Scanner(System.in);
	System.out.print("Input a number of numbers: "); int num = in.nextInt();
	
	int nums[] = new int[num];
	
	for (int i = 0; i < num; i++)
	nums[i]= in.nextInt();
	System.out.printf("Numbers divisibe by 5 and 7: ");
	for (int i = 0; i < num; i++)
	if (nums[i]%5==0&&nums[i]%7==0)
		System.out.printf("%d ", nums[i]); 
	
	 in.close(); }
}
