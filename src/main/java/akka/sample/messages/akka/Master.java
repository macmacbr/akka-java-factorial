package akka.sample.messages.akka;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.sample.messages.time.Time;
import scala.collection.mutable.ArraySeq;
import com.typesafe.config.ConfigFactory;

import java.util.ArrayList;

public class Master extends UntypedActor {

    private long messages = ConfigFactory.load().getInt("factorial.number");
    private ActorRef workerRouter;
    private final Time time = new Time();
    private ArrayList list = new ArrayList();

    public Master() {
        workerRouter = null; // create an actor here.
    }

    @Override
    public void onReceive(Object message) {
        //Need to treat messages here
        unhandled(message);
    }

    private void processMessages() {
        //Need to send messages over.
    }

    private void end() {
        time.end();
        System.out.println("Time elapsed: " + time.elapsedTimeMilliseconds() + " ms");
        //need to terminate the actor system.
    }

    public static Props createMaster() {
        // create actorRef of type Master  and pass empty array to constructor -> new ArraySeq<Object>(0)
        return null;
    }
}
