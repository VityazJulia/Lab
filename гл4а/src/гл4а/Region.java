package гл4а;

public class Region extends District {

    public int numberd;
    public District[] Districts = new District[numberd + 10];

    public Region() {
    }

    public Region(String name, City capitalCity) {
        super(name, capitalCity);
    }

    public Region(String name, City capitalCity, int number, District[] districts) {
        super(name, capitalCity);
        this.numberd = number;
        Districts = districts;
    }

    @Override
    public double CalculateSquare() {
        double S=0;
        for(int i=0; i<numberd; i++)
            S += Districts[i].CalculateSquare();
        return S;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Region region = (Region) obj;
        return !(name != null ? !name.equals(region.name) : region.name != null);
    }

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", CapitalCity='" + CapitalCity + '\'' +
                ", square=" + square +
                '}';
    }
}
