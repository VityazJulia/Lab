package гл4б;

import java.io.FileNotFoundException;
import java.io.InvalidObjectException;

public class RunnerSerialization {
    public static void main(String[] args) throws FileNotFoundException {
        // создание и запись объекта
        Carrot ob = new Carrot( 50);
        System.out.println(ob);
        String file = "output.txt";
        Serializator sz = new Serializator();
        boolean b = sz.serialization(ob, file);
        Carrot.rotten = "gnilayaMorkovka"; // изменение значения static-поля
        // чтение и вывод объекта
        Carrot res = null;
        try {
            res = sz.deserialization(file);
        } catch (InvalidObjectException e) {
            // обработка
            e.printStackTrace();
        }
        System.out.println(res);
    }
}

