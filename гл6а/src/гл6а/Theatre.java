package гл6а;

public class Theatre extends PublicBuilding {

    public String play;
    public String[] afisha = new String[]{"Ludzi na balote", "Romeo and Juliette", "Traviata", "The Tragedy of King Lear"};
    public int time;

    public Theatre() {
       super.open = 10;
       super.close = 22;
       super.setName("some theatre");
       play = "something";
       time  =10;
       super.openhours = true;
    }

    public Theatre(String name, int Time) {
        super.open = 10;
        super.close = 22;
        super.setName(name);
        int i = (int)((Time - 10)/3);
        play = afisha[i];
        time  =Time;
        super.openhours = ((Time - 10 >= 0)&(22 - Time >=0));
    }


    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setTime(int time) {
        this.time = time;
        super.openhours = ((time - 10 >= 0)&(22 - time >=0));
    }

    public int getTime() {
        return time;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    public String getPlay() {
        return play;
    }



    @Override
    public void setAdress(String adress) {
        super.Adress = adress;
    }

    @Override
    public String getAdress() {
        return super.Adress;
    }


    @Override
    public void setSquare(double square) {
        super.Square =square;
    }

    @Override
    public double getSquare() {
        return super.Square;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Theatre " + Name + " located at "+ Adress);
        if (openhours) {
            s.append(" is open now till 10 pm. ");
            s.append(super.HoldAnEvent(play));
        }
        else s.append(" is closed now till 10 am. The square of this " + getCategory()+ " is "+ Square+" square meters.");
        return s.toString();
    }
}
