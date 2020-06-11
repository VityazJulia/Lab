package гл4а;

public class Country extends Region {
    public int numberr;
    public City Capital;
    public Region[] Regions = new Region[numberr + 5];

    public Country() {
    }

    public Country(String name, City capitalCity, int numberr, Region[] regions) {
        super(name, capitalCity);
        this.numberr = numberr;
        Regions = regions;
    }

    public City getCapital() {
        return Capital;
    }

    public void setNumberr(int numberr) {
        this.numberr = numberr;
    }

    public void setCapital(City capital) {
        Capital = capital;
    }

    public void setRegions(Region[] regions) {
        Regions = regions;
    }

    public int getNumberr() {
        return numberr;
    }

    public void getRegionCenters(){
        for(int i=0; i<numberr; i++)
            System.out.println(Regions[i].getCapitalCity());
    }

    @Override
    public double CalculateSquare() {
        double S=0;
        for(int i=0; i<numberr; i++)
            S += Regions[i].CalculateSquare();
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
        Country country = (Country) obj;
        return !(name != null ? !name.equals(country.name) : country.name != null);
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", CapitalCity='" + CapitalCity + '\'' +
                ", square=" + square +
                '}';
    }
}
