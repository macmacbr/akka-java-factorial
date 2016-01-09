package akka.sample.messages;

import akka.sample.messages.hash.CalculateFactorial;
import akka.sample.messages.time.Time;
import com.typesafe.config.ConfigFactory;

import java.util.ArrayList;

public class JavaWay {

    private final long messages = ConfigFactory.load().getInt("factorial.number");
    ArrayList list = new ArrayList();
    Time time = new Time();

    public static void main(String[] array) {
        new JavaWay().run();
    }

    private void run() {
        time.start();
        calculateFactorial();
        time.end();
        printElapsedTime(time);
    }

    private void calculateFactorial() {
        for (int i = 0; i < messages; i++) {
            list.add(new CalculateFactorial().calculate());
        }
    }

    private void printElapsedTime(Time time) {
        System.out.println("Time Elapsed: " + time.elapsedTimeMilliseconds());
    }
}
