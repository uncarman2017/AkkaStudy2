package org.redmaplesoft.akka.practise1.ch24;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

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
        system.terminate();
    }

    /**
     * @author Max Yu
     * @version 创建时间：2018/11/9 15:52
     */
    public static class ForwardActor extends UntypedActor {
        private ActorRef target = getContext().actorOf(Props.create(TargetActor.class),"targetActor");

        @Override
        public void onReceive(Object message) throws Exception {
            System.out.println("Forward Actor receive: " + message + ", sender: " + getSender());
            target.forward(message,getContext());
        }
    }
}
