package гл10_а;
import java.io.*;
import java.util.*;

class ListFiles extends Object
{
    public static void main(String[] parameters)
    {
        System.out.println( " " );

        String directoryName = "directory";
            try
            {
                File directory = new File(directoryName);
                File[] directoryFiles = directory.listFiles(new MyDirectoryFilter());

                if (directoryFiles == null)
                {
                    System.out.println("Каталог не существует");
                    return;
                }

                else if (directoryFiles.length == 0)
                {
                    System.out.println("Каталог пуст");
                    return;
                }

                for (int i=0; i< directoryFiles.length; i++)
                {
                    System.out.println("\n" + directoryFiles[i].getName());

                    System.out.print("   ");

                    if (directoryFiles[i].isDirectory())
                        System.out.println("");
                    else {
                        Scanner scanner = new Scanner(directoryFiles[i]);
                        while (scanner.hasNext()) {
                            System.out.print("   ");
                            System.out.println(scanner.nextLine());
                        }

                    }
                }
            }

            catch (Exception e)
            {
                System.out.println("Операция над списком не выполнена");
                System.out.println(e);
            }
        }



    }

