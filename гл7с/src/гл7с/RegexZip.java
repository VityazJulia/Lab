package гл7с;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexZip {


        public static void main(String... args) {
            Scanner in = new Scanner(System.in);
            System.out.print("Input the text: ");
            String str = in.nextLine();
            System.out.println(zip(str));
            in.close();
        }

        private static String zip(String data) {
            String result = "";

            Pattern pattern = Pattern.compile("(.)\\1*");

            Matcher matcher = pattern.matcher(data);

            while (matcher.find()) {
                result += matcher.group(1);
                int length = matcher.group().length();
                if (length > 1)
                    result += length;
            }
            return result;
        }


}
