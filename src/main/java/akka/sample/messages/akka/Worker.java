package akka.sample.messages.akka;

import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.sample.messages.hash.CalculateFactorial;
import scala.collection.mutable.ArraySeq;

import java.math.BigInteger;

public class Worker extends UntypedActor {

    @Override
    public void onReceive(Object message) {
        //receive the message to start the work and trigger the work to be done.
        //reply with a message that work is done (and the value).
        unhandled(message);
    }

    public static Props createWorker() {
        //create an actorRef of Worker with empty array
        return null;
    }
}
