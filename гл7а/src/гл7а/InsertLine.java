package гл7а;
import java.util.Scanner;
public class InsertLine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k;
        StringBuffer s = new StringBuffer();
        String str, substr;

        System.out.print("Input the text: ");
        str = in.nextLine();
        System.out.print("Input the line to insert: ");
        substr = in.nextLine();
        s.append(str);
        System.out.print("Input the position: ");
        k = in.nextInt();
        String S1 = s.substring(0, k);
        String S2 = s.substring(k, s.length());


        s.delete(0, s.length());
        s.append(S1 + substr + S2);


        System.out.print(s.toString());
in.close();
    }
}
