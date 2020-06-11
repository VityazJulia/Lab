package гл4а;

public class District {
    public String name;
    public City CapitalCity;
    public double square;


    public class SquareLogicException extends Exception {
        public SquareLogicException() {
        }
        public SquareLogicException(String message, Throwable exception) {
            super(message, exception);
        }
        public SquareLogicException(String message) {
            super(message);
        }
        public SquareLogicException (Throwable exception) {
            super(exception);
        }
    }

    public District() {
    }

    public District(String name, City capitalCity) {
        this.name = name;
        CapitalCity = capitalCity;
    }

    public District(String name, City capitalCity, double square) throws SquareLogicException {
        if(square <= 0) {
            throw new SquareLogicException("square is incorrect");
        }


        this.name = name;
        CapitalCity = capitalCity;
        this.square = square;

    }

    public String getName() {
        return name;
    }

    public City getCapitalCity() {
        return CapitalCity;
    }

    public double getSquare() {
        return square;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapitalCity(City capitalCity) {
        CapitalCity = capitalCity;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                ", CapitalCity='" + CapitalCity + '\'' +
                ", square=" + square +
                '}';
    }

    public double CalculateSquare() {
        return square;
    }
}
