package org.redmaplesoft.akka.practise1;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * @author Max Yu
 * @version 创建时间：2018/11/9 16:40
 * 2.5 查找一个Actor
 */
public class App4 {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("sys");
        ActorRef actorRef = system.actorOf(Props.create(LookupActor.class), "lookupActor");
        actorRef.tell("find", actorRef);

    }
}
