package org.redmaplesoft.akka.practise1.ch25;

import akka.actor.ActorNotFound;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.dispatch.OnFailure;
import akka.dispatch.OnSuccess;
import akka.util.Timeout;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

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

        // 第二种方式查找Actor
        ActorSelection as = system.actorSelection("/user/lookupActor/targetActor");
        Timeout timeout = new Timeout(Duration.create(2,"seconds"));
        Future<ActorRef> fu = as.resolveOne(timeout);
        fu.onSuccess(new OnSuccess<ActorRef>() {
            @Override
            public void onSuccess(ActorRef result) throws Exception {
                System.out.println("查找到Actor:" + result);
            }
        },system.dispatcher());

        fu.onFailure(new OnFailure() {
            @Override
            public void onFailure(Throwable failure) throws Exception {
                if(failure instanceof ActorNotFound){
                    System.out.println("没有找到Actor: " + failure.getMessage());
                }
            }
        },system.dispatcher());

        system.terminate();
    }
}
