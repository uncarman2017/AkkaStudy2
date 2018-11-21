package org.redmaplesoft.akka.practise1.ch210;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import java.io.IOException;

/**
 * 2.10 监督与容错处理
 */

public class App9 {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("sys");
        ActorRef workerActor = system.actorOf(Props.create(WorkerActor2.class), "workerActor2");
        workerActor.tell(new IOException(), ActorRef.noSender());
        System.out.println("===================================================");
        workerActor.tell("getvalue", ActorRef.noSender());
        system.terminate();
    }
}
