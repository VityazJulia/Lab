package гл5а;
import java.util.Arrays;
import java.util.Scanner;
public class ZachetnayaBook {
    public static Scanner ob = new Scanner(System.in);
    public info[] info = new info[10];
    public String name;
    public int num;

    public ZachetnayaBook() {
        System.out.print("input the student's name");
        setname(ob.next());
        System.out.print("Input a number of studied semesters: ");
        num = ob.nextInt();
        info[] sessions = new info[10];
        for (int i = 0; i < num; i++)
            info[i] = new info();
    }

    public ZachetnayaBook(int num){

    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }


    public class info {
        int sessiya, zachet, exam, examinationretake, examretake;
        int[] marx = new int[10];

        public info() {
            System.out.print("session №:");
            setNumberOfSession(ob.nextInt());
            System.out.print("number of examinations:");
            setNumberOfExaminations(ob.nextInt());
            System.out.print("number of exams:");
            setNumberOfExams(ob.nextInt());
            System.out.print("number of examination retakes:");
            setExaminationretake(ob.nextInt());
            System.out.print("number of exam retakes:");
            setExamretake(ob.nextInt());
            System.out.print("marks:");
            int[] marks = new int[10];
            for (int i = 0; i < exam; i++)
                marks[i] = ob.nextInt();
            setMarx(marks);
        }

        public int getNumberOfSession() {
            return sessiya;
        }

        public void setNumberOfSession(int number) {
            this.sessiya = number;
        }

        public int getNumberOfExaminations() {
            return zachet;
        }

        public void setNumberOfExaminations(int zachet) {
            this.zachet = zachet;
        }

        public int getNumberOfExams() {
            return exam;
        }

        public void setNumberOfExams(int exam) {
            this.exam = exam;
        }

        public int getExaminationretake() {
            return examinationretake;
        }

        public void setExaminationretake(int examinationretake) {
            this.examinationretake = examinationretake;
        }

        public int getExamretake() {
            return examretake;
        }

        public void setExamretake(int examretake) {
            this.examretake = examretake;
        }

        public int[] getMarx() {
            return marx;
        }

        public void setMarx(int[] marx) {
            this.marx = marx;
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder(" has passed session №" + sessiya +
                    " containing " + zachet +
                    " examinations, " + exam +
                    " exams with " + examinationretake +
                    " examination retakes, " + examretake +
                    " exam retakes, marks ");
            for (int i = 0; i < exam; i++) s.append(marx[i] + " ");
            s.append("\n");
            return s.toString();
        }


    }

    public static class Zachetka {

        public static void Title() {
            System.out.println("Belarusian State University\nZachetnaya knizhka studenta");
        }


    }

    void Deansignature() {

        ZachetnayaBook D = new ZachetnayaBook(0) {
            @Override
            public String toString() {
                String s = "SignedByDean";
               return s;

            }
        };
System.out.println(D.toString());
    }

    static public void main(String[] args) {
        Scanner ob = new Scanner(System.in);

        ZachetnayaBook ct = new ZachetnayaBook();
        ZachetnayaBook.Zachetka.Title();

        System.out.print("A student named " + ct.getname());
        for (int i = 0; i < ct.num; i++)
            System.out.print(ct.info[i].toString());
        ct.Deansignature();
    }
}

