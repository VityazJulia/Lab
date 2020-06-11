package гл4а;

public class City {
    public String name;

    public City(){
    }

    public City(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  name ;
    }
}

