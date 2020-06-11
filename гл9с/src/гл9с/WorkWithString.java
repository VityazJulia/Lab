package гл9с;

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
        this.in = new BufferedReader(new InputStreamReader(System.in, "Cp1251"));//создание объекта класса BufferedReader с возможностью ввода данных на русском языке(кодировка "Cp1251")
    }


    public static String dosmth(String s) throws IOException {
        BufferedReader in1 = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(s);
        StringBuffer sb= new StringBuffer();
        while(st.hasMoreTokens()){
            String str=st.nextToken();
            if(str.length()>2){sb.append(str.toUpperCase()+" ");
            } else{sb.append(str+" ");}
        }
        return sb.toString();
    }

    public void textFromfile() throws IOException {//метод чтения текста из файла и определение количества гласных, пробелов и общего количества букв
        System.out.println("Введите имя файла:");
        filename = in.readLine();//ввод имени файла, которое следует вводить учитывая расширение, например text.txt
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
        System.out.println("\nВведите имя директории:");
        String dir = in.readLine();
        File dir1 = new File(dir);
        if(dir1.mkdir()) System.out.println("Директория создана. ");
        else System.out.println("ничего не создано");


        System.out.println("\nВведите имя файла для вывода:");

        String filename1 = in.readLine();//ввод имя файла, которое следует вводить учитывая расширение, например text.txt

        RandomAccessFile fio1 = new RandomAccessFile(new File(dir+"/"+filename1), "rw");//создание файла с заданным именем
        while(Data[i]!=null){
            String [] arrayWords = new String [100];
            arrayWords = Data[i].split(" ");
            for (int j = 0; j < arrayWords.length; j++) {
                fio1.writeBytes(dosmth(arrayWords[j]));
            }
            i++;
            fio1.writeBytes("\n");
        }

        System.out.println("Ваш текст сохранен.");
        fio1.close();
    }

    public static void main(String args[]) throws UnsupportedEncodingException, IOException {
        WorkWithString n = new WorkWithString();
        n.textFromfile();
    }

}
