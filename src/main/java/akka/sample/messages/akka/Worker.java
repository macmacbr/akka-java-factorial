package akka.sample.messages.akka;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.sample.messages.hash.CalculateFactorial;
import scala.collection.mutable.ArraySeq;

import java.math.BigInteger;

public class Worker extends UntypedActor {

    @Override
    public void onReceive(Object message) {
        if (message instanceof Work) {
            BigInteger res = new CalculateFactorial().calculate();
            getSender().tell(new Result(res), ActorRef.noSender());
        } else {
            unhandled(message);
        }
    }

    public static Props createWorker() {
        return Props.create(Worker.class, new ArraySeq<Object>(0));
    }
}