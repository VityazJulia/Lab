package гл2а;
/**
* Class {@code Program} is the root of the class hierarchy.
* Every class has {@code Program} as a superclass. All objects,
* including arrays, implement the methods of this class.
 *
* @author Maya Yozhikova
* @see java.lang.Class
* @since JDK1.0
 */
import java.util.Scanner;
import java.util.Date;
public class Program {
	/** start of the program */
	public static void main(String[] args) { Scanner in = new Scanner(System.in); /**method main*/
	
	System.out.print("Input a number of numbers: "); int num = in.nextInt(); /**inputting value of the field num */
	System.out.print("Input the highest number of digits: "); int numd = in.nextInt(); /**inputting value of the field numd */
	int nums[] = new int[num];  /** field nums @value array of numbers   */
	
	int k[]= new int [numd];  /** field k @value array of powers of 10  */
	int n[][]= new int [num][numd]; /** field n @value array of numbers each of them being an array of digits */
	int nout[]=new int[numd];  /** field nout @value */
	int k1=10; /** field k1 @value 10 */
	int numd1[]= new int [num]; /**field numd1 @value */
for (int i=0; i<num; i++) numd1[i]=0;
	for (int i=1; i<=numd; i++)
		{
		k[i-1]=k1;
		k1*=10;
		}  /** operation of filling k[] with powers of ten */
	System.out.printf("Input numbers: ");	
	for (int i = 0; i < num; i++)
	nums[i]= in.nextInt();  /**operation of filling an array nums with numbers  */
	for (int i = 0; i < num; i++)
		for (int j=0; j<numd;j++)
		{numd1[i]++;
		if(nums[i]%k[j]==nums[i] ) {
			n[i][j]=nums[i]%k[j];
			break;
		}  
		else 	n[i][j]=nums[i]%k[j];
		}
	/**operation of transforming array nums[] into an array n[][] */
	for (int i = 0; i < num; i++) nout[i]=n[0][i]; /** filling an array nout[] with elements */
	int kk[]=new int [numd]; 
	for (int i=0;i<numd;i++) kk[i]=0;
	for (int i = 0; i < num; i++)
		for (int j=0; j<numd1[i]-1;j++)
		if (n[i][j]!=n[i][j+1]) kk[i]++;
			
	int max;
	int nn;
	nn=0;
	max=kk[0]; int k0=numd1[0];
	for (int i=0;i<numd;i++) if (kk[i]>max) {max=kk[i]; nn=i;  k0=numd1[i];}
	System.out.printf("Number with a highest number of different digits is ");
	
	
	System.out.printf(" %d ", n[nn][k0-1]);	
	Date date = new Date();
	System.out.println("\nMaya Yozhikova\n");
	System.out.println("\nSat Feb 29 13:00 MSK 2020\n");
	// ¬ывод текущей даты и времени с использованием toString()
	System.out.println(date.toString());
	 in.close(); }
}


