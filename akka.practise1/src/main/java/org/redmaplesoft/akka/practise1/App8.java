package org.redmaplesoft.akka.practise1;

import akka.actor.*;

/**
 * 2.9 停掉一个Actor
 */

public class App8 {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("sys");
        ActorRef ar = system.actorOf(Props.create(WatchActor.class), "watchActor1");
         ar.tell("stopChild",ActorRef.noSender());

//        ActorRef ar2 = system.actorOf(Props.create(WorkerActor.class), "watchActor2");
//        system.stop(ar2);

        system.terminate();
    }
}
