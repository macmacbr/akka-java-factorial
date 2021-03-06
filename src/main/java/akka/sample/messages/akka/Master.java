package akka.sample.messages.akka;

import akka.actor.ActorRef;
import akka.actor.PoisonPill;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.RoundRobinPool;
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
        workerRouter = this.getContext().actorOf(Worker.createWorker().withRouter(new RoundRobinPool(8)),"workerRouter"); // create an actor here.
    }

    //Master -> workerRouter -> [ Worker x 8 ]

    public void onReceive(Object message) {
        this.onReceive2(message);
    }

    @Override
    public void onReceive2(Object message) {
        if (message instanceof Calculate) {
            time.start();
            processMessages();
            getContext().become(onRecieve1);
        }
        else if (message instanceof Result) {
            list.add(message);
            if (list.size() == messages) {
                end();
            }
        } else {
            unhandled(message);
        }
    }

    public void onReceive1(Object message) {
        if (message instanceof Work) {
            time.start();
            processMessages();
            getContext().become(onReceive2);
        } else {
            unhandled(message);
        }
    }



    private void processMessages() {
        for (int i = 0; i < messages; i++) {
            workerRouter.tell(new Work(), getSelf());
        }
    }

    private void end() {
        time.end();
        System.out.println("Time elapsed: " + time.elapsedTimeMilliseconds() + " ms");
        getContext().system().terminate();
    }

    public static Props createMaster() {
        return Props.create(Master.class, new ArraySeq<Object>(0));
    }
}
