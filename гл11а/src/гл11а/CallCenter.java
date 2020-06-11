package гл11а;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class CallCenter {

    private final static int NUMBER_TRYING = 2;
    List<Operator> operators = new ArrayList<Operator>();
    private final Semaphore mutex = new Semaphore(1);;



    public CallCenter(List<Operator> operators) {
        this.operators.addAll(operators);
    }

    public CallCenter() {
    }

    public  Operator tryCall(Client client, int waitingTime) {
        int numberTrying = 0;

        boolean success = false;
        while (!success) {

            for (Operator operator : operators) {
                if (searchFreeOperator(operator, client)) {
                    return operator;
                }
            }
            if (!success) {
                try {
                    numberTrying++;
                    if (checkCountTrying(numberTrying, waitingTime, client)) {
                        return null;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void endCall(Operator operator) {
        operator.setClient(null);
        operators.add(operator);
        mutex.release();
    }

    private  boolean checkCountTrying(int numberTrying,
                                                  int waitingTime, Client client) throws InterruptedException {
        if (numberTrying == NUMBER_TRYING) {
            System.out.println("client "+
                    client.getId()+" is being put down");
            mutex.acquire();

            return true;

        } else {
            System.out.println("client "+
                    client.getId()+" needs to wait for an operator");
            mutex.acquire();

        }
        return false;

    }

    private boolean searchFreeOperator(Operator operator, Client client) {
        if (operator.getClient() == null) {
            operator.setClient(client);
            operators.remove(operator);
            return true;
        }
        return false;
    }
}
