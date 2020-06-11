package гл2_с;
import java.util.Scanner;
import java.util.Date;
import java.util.Random;
public class Program {
	public static void main(String[] args) { /**method main*/
		Random random = new Random();
		Scanner in = new Scanner(System.in);
	System.out.print("Input a number of rows and cols: "); int num = in.nextInt();
	
int arr[][]= new int [num][num];

for (int i=0; i<num; i++)
{
	int nums[]= new int[num];
	for (int j=0; j<num; j++) 
	nums[j]=random.nextInt(2*num + 1)-num;
		arr[i]=nums;	
	}
System.out.print("Initial matrix: \n");
for (int i=0; i<num; i++)
	for (int j=0; j<num; j++)
		{
		if (j==num-1) System.out.printf("%d \n", arr[i][j]);
		else	System.out.printf("%d ", arr[i][j]);}


int S[]=new int [num];
for (int i=0;i<num; i++) S[i]=0;
for (int i=0; i<num; i++)
	for (int j=0; j<num; j++) {
		S[i]+=arr[i][j];
}
int n0[] = new int [num];
for (int i=0; i<num; i++) n0[i]=0;
for (int i=0; i<num; i++)
	for (int j=0; j<num; j++)
	{if (arr[i][j]>0)
		{n0[i]=j;
		S[i]-=arr[i][j]; 
	break;}
	else S[i]-=arr[i][j];
		}

for (int i=0; i<num; i++)
	for (int j=n0[i]+1; j<num; j++)
	{if (arr[i][j]>0)
		{for (int l=j; l<num; l++)
		S[i]-=arr[i][l]; 
	break;}
	else continue;
		}


int St=0;
for (int i=0; i<num; i++) {St+=S[i];}
System.out.printf("Obtained sum: %d \n", St);

Date date = new Date();
System.out.println("\nMaya Yozhikova\n");

System.out.println("\nSat Mar 7 13:00:00 MSK 2020\n");

System.out.println(date.toString());


in.close(); }
}
