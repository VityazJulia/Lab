package гл11а;

public class Client implements Runnable{
    private final static int WAITING_TIME = 100;
    private int id;
    private CallCenter callCenter = new CallCenter();

    public int getId() {
        return id;
    }

    public Client(CallCenter callCenter, int id) {
        this.callCenter = callCenter;
        this.id = id;
    }

    public void run() {
        Operator operator = null;
        try {
            while (operator == null) {
                System.out.println("client "+ this.id + " is trying to call");
                operator = callCenter.tryCall(this, WAITING_TIME);
            }
            System.out.println("client "+this.id+" starts talking with operator "+
                    operator.getId());
            operator.talk();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (operator != null) {
                System.out.println("client "+this.id+" ends talking with operator "+ operator.getId());
                callCenter.endCall(operator);
            }
        }
    }
}
