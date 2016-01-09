package akka.sample.messages.akka;

import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.sample.messages.hash.CalculateFactorial;
import scala.collection.mutable.ArraySeq;

import java.math.BigInteger;

public class Worker extends UntypedActor {

    @Override
    public void onReceive(Object message) {
        if (message instanceof Work) {
            BigInteger bigInt = new CalculateFactorial().calculate();
            getSender().tell(new Result(bigInt), getSelf());
        } else
            unhandled(message);
    }

    public static Props createWorker() {
        return Props.create(Worker.class, new ArraySeq<Object>(0));
    }
}
