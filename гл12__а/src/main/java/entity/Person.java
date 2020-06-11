package entity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Person {
    private String name;
    private Date birthDate;

    public Person(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Person() {
        this("noname", new Date());
    }

    public String getName() {
        return name;
    }

    public String getSQLDate() {
        LocalDate localDate = this.birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return new StringBuilder()
                .append(localDate.getYear())
                .append("-")
                .append(localDate.getMonthValue())
                .append("-")
                .append(localDate.getDayOfMonth()).toString();
    }

    @Override
    public String toString() {
        return
                "name: " + name  +
                        ", birthDate: " + birthDate.toString() ;
    }
}
