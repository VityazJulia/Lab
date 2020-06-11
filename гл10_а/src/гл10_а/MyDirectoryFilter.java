package гл10_а;

import java.io.File;
import java.io.FileFilter;

public class MyDirectoryFilter implements FileFilter {
    public boolean accept(File file)
    {
        try
        {
            // Сохранение записи. Возврат значения true, для того чтобы
            // объект IFSList добавил файл в список, возвращаемый
            // методу .list().

            return true;
        }

        catch (Exception e)
        {
            return false;
        }
    }


}
