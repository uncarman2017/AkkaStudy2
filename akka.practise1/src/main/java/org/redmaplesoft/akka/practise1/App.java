package org.redmaplesoft.akka.practise1;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;


/**
 * @author Max Yu
 * @version 创建时间：2018/11/9 14:24
 * 2.3 创建一个Actor
 * 2.4 发送-接收消息
 */
public class App {
    public static void main(String[] args) {

        // 参数为ActorSystem的名字，可以不传。通过ActorSystem创建的是一个顶级的Actor(/user路径下)
        ActorSystem system = ActorSystem.create("sys");
        // 创建方法一，指定Actor的class
        // 参数分别是构造器和Actor的名字，名字可以不传。同一个ActorSystem下的Actor名字必须唯一
        ActorRef actorRef = system.actorOf(Props.create(DemoActor.class), "demoActor");
        // 创建方法二，指定一个Actor工厂，实现akka.japi.Creator接口，重写其create方法
        ActorRef actorRef2 = system.actorOf(PropsDemoActor.createProps(), "propsDemoActor");


        actorRef.tell("Hello DemoActor", ActorRef.noSender());
        CommonMsg msg = new CommonMsg("test1", "Hello DemoActor");
        actorRef.tell(msg, ActorRef.noSender());
        actorRef2.tell("Hello PropsDemoActor", ActorRef.noSender());


    }
}
