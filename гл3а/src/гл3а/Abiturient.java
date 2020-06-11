package гл3а;
import java.util.Scanner;
import java.io.IOException;
public class Abiturient {
	private String surname;
	private String name;
	private String patronymic;
	private String adress;
	private int num;
	private int marx[] = new int[20];
	public Abiturient() throws IOException 
	{
		surname = "";
		name = "";
		patronymic = "";
		adress = "";
		num = 0;
		marx[0] = 0;
		
	};
	
    public void setSurname(String s) {  surname= s; }
    public void getSurname() {  System.out.println(surname); }
	
    public void setName(String n) { name = n; }
    public void getName() { System.out.println(name); }
   
    public void setPatronymic(String p) {  patronymic = p; }
	public void getPatronymic() { System.out.println(patronymic); }
	
	public void setAdress(String a) {  adress = a; }
    public void getAdress() { System.out.println(adress); }
    
    public void setNumberofSubjects(int num1) { num = num1; }
    public void getNumberofSubjects() { System.out.println(num); }
    
    public void setMarks(int[] m) {for (int i = 0; i < num; i++) marx[i] =m[i]; }
    public void getMarks() {for (int i = 0; i < num; i++) System.out.printf("%d ", marx[i]); }
    
    public void setTun(String s, String n, String p, String a, int num1, int[] m ) {
    	surname= s;
     name= n;
    	 patronymic = p;
    adress= a;
    	num = num1;
    	for (int i = 0; i < num; i++) marx[i] =m[i];
    }
	
    @Override
   
    
    public String toString() {
    	 StringBuilder s = new StringBuilder("\nAbiturient : " + surname + name + patronymic +";" + adress + "\n");
    	 for (int i = 0; i < num; i++) {
    	
    	 s.append(marx[i]+ " ");
    	 }
    	 s.append("\n");
    	 
    	 return s.toString();
    	 }
    
	public void getTun() {
		System.out.print("\n==============================\n");
		System.out.println(surname);
		System.out.println(name);
		System.out.println(patronymic);
		System.out.println(adress);
		for (int i = 0; i < num; i++) System.out.printf("%d ", marx[i]);
		System.out.print("\n==============================\n");
	} ;	
	
	public int sumofpoints() { int sum = 0; for (int i = 0; i <= 2; i++)  sum += marx[i];   return sum; };
	
	public static void listgreatersum(Abiturient spis[], int k, int m) {
		
		for (int i = 0; i < k; i++) {
			if (spis[i].sumofpoints()>=m) {
				System.out.print("==============================\n");
				spis[i].getSurname(); 
				spis[i].getName(); 
				spis[i].getPatronymic();
				spis[i].getAdress();
				System.out.print("\n==============================\n");
			}
		}
		
	};
	
	public void copy(Abiturient a) {
		surname = a.surname;
		name = a.name;
		adress = a.adress;
		num = a.num;
		for(int i = 0; i < num; i++) marx[i] = a.marx[i];
	}
	
	public static void listthebest(Abiturient spis[], int k, int N, int passingpoint) throws IOException {
		
	
		for (int i = 0; i < k; i++)
			for (int j = i; j < k; j++)
				if(spis[i].sumofpoints() < spis[j].sumofpoints()) {Abiturient a1 = new Abiturient();
				a1.copy(spis[i]);
				spis[i].copy(spis[j]);
				spis[j].copy(a1);
				}
		System.out.printf("%d best applicants: \n", N);
		for(int i = 0; i <N; i++)
			spis[i].getTun();
		System.out.printf("Students with semi-passing point: \n");
		for (int i = 0; i < k; i++) if((spis[i].sumofpoints()>=passingpoint-2)&&(spis[i].sumofpoints()<passingpoint)) spis[i].getTun();
	
	};
	
	public static void listtheworst(Abiturient spis[], int k, int negative) {
		for (int i = 0; i < k; i++) if(spis[i].sumofpoints()<=negative) spis[i].getTun();
	}
	
	
	
	public static void main(String[ ] args) throws IOException {
		int negative = 27;
		int passingpoint = 119;
		int n, num1;
		num1=2;
		System.out.print("Exams in 2 subjects. Semi-passing point: 119, negative point: 27.\n");
		String surname, name, patronymic, adress;
		int marx[]= new int[20];
		Scanner in = new Scanner(System.in);
		System.out.print("Input the number of applicants: "); n = in.nextInt();
	    Abiturient A[] = new Abiturient[100];
		for (int i = 0; i < n; i++)
			{A[i] = new Abiturient();
			System.out.print("==============================\n");
			System.out.print("Input the information about the applicant.\n");
			System.out.print("==============================\n");
			System.out.print("Surname: "); surname = in.next();
			System.out.print("Name: "); name = in.next();
			System.out.print("Patronymic: "); patronymic = in.next();
			System.out.print("Adress: "); adress = in.next();
			System.out.print("Marks: "); for (int j = 0; j < num1; j++) marx[j] = in.nextInt();
			A[i].setTun(surname, name, patronymic, adress, num1, marx);
			}
		int m=0;
		while (m == 0) {
			int num;
			System.out.println("..........Choose an option: ...........");
			System.out.println("1) List of applicants with the negative rate");
			System.out.println("2) List of applicants with the rate greater than the set one");
			System.out.println("3) Best applicants and semi-passing applicants");
			System.out.println("4) Exit");
			num = in.nextInt();
			switch (num) {
			case 1: {
				listtheworst(A, n, negative);
				break;
			}
			case 2: {
				int m1;
				System.out.print("Set the sum of points: "); m1 = in.nextInt();
				listgreatersum(A, n,m1);
				break;
			}
			case 3: {
				int m2;
				System.out.print("Set the number of best applicants: "); m2 = in.nextInt();
				listthebest(A, n, m2, passingpoint);
				break;
					}
			case 4: {
				System.exit(0);
				break;
			}
			
			}
		}
		
		
		in.close();
	}
	
	
}
