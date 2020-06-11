package гл9а;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WorkWithString {
    String[] Data = new String[50];

    String filename;

    RandomAccessFile fio;
    BufferedReader in;

    public WorkWithString() throws UnsupportedEncodingException {
        this.in = new BufferedReader(new InputStreamReader(System.in, "Cp1251"));
    }


    public static String dosmth(String [] arrayWords) throws IOException {
        StringBuffer sb= new StringBuffer();
        for (int i = 0; i < arrayWords.length - 1; i++) {
            if (Character.toLowerCase(arrayWords[i].charAt(arrayWords[i].length() - 1)) == Character.toLowerCase(arrayWords[i + 1].charAt(0))) {
                sb.append(arrayWords[i] + " " + arrayWords[i + 1] + "\n");
            }

        }
        return sb.toString();
    }


    public void textFromfile() throws IOException {
        System.out.println("Введите имя файла:");
        filename = in.readLine();
        fio = new RandomAccessFile(new File(filename), "r");
        String line;
        int i = 0;

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        System.out.println("Информация из исходного файла: ");//вывод информации из файла
        while ((line = reader.readLine()) != null){
            Data[i] = fio.readLine();
            System.out.print(Data[i] + "\n");
            i++;
        }

        fio.close();
        i=0;
        System.out.println("\nВведите имя файла для вывода:");
        String filename1 = in.readLine();
        RandomAccessFile fio1 = new RandomAccessFile(new File(filename1), "rw");
        while(Data[i]!=null){
            String [] arrayWords = new String [100];
            arrayWords = Data[i].split(" ");
                       fio1.writeBytes(dosmth(arrayWords));

            i++;

        }

        System.out.println("Ваш текст сохранен.");
        fio1.close();
    }

    public static void main(String args[]) throws UnsupportedEncodingException, IOException {
        WorkWithString n = new WorkWithString();
        n.textFromfile();
    }

}


