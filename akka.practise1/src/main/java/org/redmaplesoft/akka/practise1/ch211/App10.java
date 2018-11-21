package org.redmaplesoft.akka.practise1.ch211;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * 2.11 Circuit Breaker(熔断)
 */
public class App10 {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("sys");
        //TODO: 熔断器似乎没有工作
        ActorRef circuitBreakerActor = system.actorOf(Props.create(CircuitBreakerActor.class), "circuitBreakerActor");
        circuitBreakerActor.tell ("sync circuitBreakerActor", ActorRef.noSender());
//        system.terminate();
    }
}
