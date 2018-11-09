package org.redmaplesoft.akka.practise1;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * @author Max Yu
 * @version 创建时间：2018/11/9 16:02
 * 2.4 发送-接收消息
 * 转发消息Demo
 */
public class App3 {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("sys");
        ActorRef actorRef = system.actorOf(Props.create(ForwardActor.class), "forwardActor");
        actorRef.tell("Max's visit", actorRef);

    }
}
