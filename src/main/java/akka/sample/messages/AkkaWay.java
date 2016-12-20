package akka.sample.messages;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.sample.messages.akka.Calculate;
import akka.sample.messages.akka.Master;

public class AkkaWay {

    public static void main(String[] args) {
        new AkkaWay().run();
    }

    private void run() {
        ActorSystem system = ActorSystem.create("CalcSystem");
        ActorRef master = system.actorOf(Master.createMaster(), "master");

        //send Calculate message to master. hint: can use "noSender()" as we don't care about any final result.
        master.tell(new Calculate(), ActorRef.noSender());
    }
}
/*
      -> admin
root -> user -> master -> router -> Worker x 8
*/

