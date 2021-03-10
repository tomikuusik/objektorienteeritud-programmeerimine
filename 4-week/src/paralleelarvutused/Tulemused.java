package paralleelarvutused;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Tulemused {
    public ArrayBlockingQueue<String> nimedQueue;
    public ArrayBlockingQueue<Object[]> töödeldudQueue;
    private int queueLen;

    public Tulemused(int queueLen) {
        this.nimedQueue = new ArrayBlockingQueue<>(queueLen);
        this.töödeldudQueue = new ArrayBlockingQueue<>(queueLen);
        this.queueLen = queueLen;
    }

    public ArrayBlockingQueue<Object[]> getTöödeldudQueue() {
        return töödeldudQueue;
    }

    public ArrayBlockingQueue<String> getNimedQueue() {
        return nimedQueue;
    }

    public void addNimedQueue(List<String> addList) {
        this.nimedQueue.addAll(addList);
    }

    public void addTöödeldudQueue(Object[] addArray) {
        this.töödeldudQueue.add(addArray);
    }
    public Object[] getBiggest() {
        BigInteger currentBiggest = new BigInteger("0");
        String currentBiggestFile = "";
        for (Object[] iteratorObj : töödeldudQueue) {
            if (currentBiggest.compareTo((BigInteger) iteratorObj[1]) < 0) {
                currentBiggest = (BigInteger) iteratorObj[1];
                currentBiggestFile = (String) iteratorObj[0];
            }
        }
        return new Object[]{currentBiggest,currentBiggestFile};
    }
    public BigInteger getSum() {
        BigInteger sum = new BigInteger("0");
        for (Object[] iterationObj : töödeldudQueue) {
            sum = sum.add((BigInteger) iterationObj[2]);
        }
        return sum;
    }

    public String getSmallestFileName() {
        BigInteger currentSmallestNumber = new BigInteger("0");
        String currentSmallestFilename = "";
        for (Object[] iterationObj : töödeldudQueue) {
            if (currentSmallestFilename.equals("")) {
                currentSmallestFilename = (String) iterationObj[0];
                currentSmallestNumber = (BigInteger) iterationObj[2];
            }
            else if (currentSmallestNumber.compareTo((BigInteger) iterationObj[2]) > 0) {
                currentSmallestFilename = (String) iterationObj[0];
                currentSmallestNumber = (BigInteger) iterationObj[2];
            }
        }
        return currentSmallestFilename;
    }

    public boolean isFinished() {
        if (töödeldudQueue.size() == this.queueLen) {
            return true;
        }
        else {
            return false;
        }
    }
}
