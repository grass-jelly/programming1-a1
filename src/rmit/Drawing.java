package rmit;

import rmit.decorator.Decorator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Drawing implements Decorator{

    //List<Customer> customers = new ArrayList<>();

    String jackpot;

    public String getJackpot() {
        return jackpot;
    }

    public void setJackpot(String jackpot) {
        this.jackpot = jackpot;

        // inform all subscribers
        for (Customer obs : customers) {
            obs.getNotified(this);
        }
    }

    public int[] generate() {
        int[] numSet = new int[6];
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            numSet[i] = random.nextInt(46);
        }
        Arrays.sort(numSet);

        setJackpot(Arrays.toString(numSet));
        return numSet;
    }

    public int trigger1(int[] jackpot, int triggerNo) {
        int[] numSet;
        int cnt = 0;
        do {
           numSet = generate();
           System.out.println("Trigger #" + triggerNo
                   + ". Jackpot: " + Arrays.toString(jackpot)
                   + ". Generated: " + Arrays.toString(numSet));
           cnt++;
        } while (!Arrays.equals(jackpot, numSet));
        System.out.println("Number of times before matching: " + cnt);
        return cnt;
    }

    public int trigger5(int[] jackpot) {
        int[] numTimes = new int[5];
        int sum=0;
        for (int i = 1; i <= 5; i++) {
            numTimes[i - 1] = trigger1(jackpot, i);
            sum += numTimes[i-1];
        }

        System.out.println("Number of times before matching: " );
        for (int i = 1; i <= 5; i++) {
            System.out.println("Trigger #" + i + ": " + numTimes[i-1]);
        }

        int avg = sum/5;
        System.out.println("Average number of times one needs to buy to become a winner: " + avg);
        return avg;
    }

}
