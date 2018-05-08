package rmit.decorator;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeDrawingDecorator implements Decorator {
    Decorator decorator;

    public TimeDrawingDecorator(Decorator decorator) {
        this.decorator = decorator;
    }

    @Override
    public int[] generate() {
        int[] jackpot = decorator.generate();
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println("Timestamp: "+timeStamp);
        return jackpot;
    }
}
