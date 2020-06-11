package гл6а;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String theatreName;
        System.out.print("Input the theatre name: ");
        theatreName = in.next();
        int kotoryChas;
        System.out.print("Input the current time (hour): ");
        kotoryChas = in.nextInt();
        Theatre YankiKupaly = new Theatre(theatreName, kotoryChas);
        System.out.print("Input the theatre adress: ");
        String adress = in.next();
        YankiKupaly.setAdress(adress);





        System.out.print(YankiKupaly.toString());
    }
}
