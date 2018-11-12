package org.redmaplesoft.akka.practise1;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * 2.7 Actor行为切换
 */
public class App6 {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("sys");
        ActorRef ref = system.actorOf(Props.create(SimpleDemoActor.class), "simpleDemoActor");
        ref.tell("1", ActorRef.noSender());
        ref.tell(new Emp("张三", 10000), ActorRef.noSender());
        ref.tell(new Emp("李四", 20000), ActorRef.noSender());
        ref.tell("end", ActorRef.noSender());
        ref.tell("2", ActorRef.noSender());
        ref.tell(new Emp("王五", 10000), ActorRef.noSender());
        ref.tell(new Emp("赵六", 20000), ActorRef.noSender());
        ref.tell("become3", ActorRef.noSender());
        ref.tell(new Emp("鬼脚七", 200000), ActorRef.noSender());
        ref.tell("end", ActorRef.noSender());
        system.terminate();

    }
}
