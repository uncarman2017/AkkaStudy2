package org.redmaplesoft.akka.practise1;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * 2.7 Actor行为切换
 */
public class App5 {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("sys");
        ActorRef ref = system.actorOf(Props.create(BecomeActor.class),"becomeActor");
        ref.tell("hello",ActorRef.noSender());
        ref.tell("hi",ActorRef.noSender());
        ref.tell("hi",ActorRef.noSender());
        ref.tell("hi",ActorRef.noSender());
        system.terminate();
    }
}
