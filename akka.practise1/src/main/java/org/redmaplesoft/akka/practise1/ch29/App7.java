package org.redmaplesoft.akka.practise1.ch29;

import akka.actor.*;

/**
 * 2.9 停掉一个Actor
 */
public class App7 {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("sys");
        ActorRef ar = system.actorOf(Props.create(WorkerActor.class), "workerActor1");
        system.stop(ar);

        ActorRef ar2 = system.actorOf(Props.create(WorkerActor.class), "workerActor2");
        ar2.tell(PoisonPill.getInstance(),ActorRef.noSender());

        ActorRef ar3 = system.actorOf(Props.create(WorkerActor.class), "workerActor3");
        ar3.tell(Kill.getInstance(),ActorRef.noSender());
        system.terminate();
    }
}
