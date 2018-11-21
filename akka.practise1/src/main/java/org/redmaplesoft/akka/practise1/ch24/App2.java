package org.redmaplesoft.akka.practise1.ch24;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.dispatch.OnFailure;
import akka.dispatch.OnSuccess;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

/**
 * @author Max Yu
 * @version 创建时间：2018/11/9 15:58
 * 2.4 发送-接收消息
 */
public class App2 {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("sys");
        // ask操作
        ActorRef actorRef3 = system.actorOf(Props.create(DemoAskActor.class), "demoAskActor");
        Timeout timeout = new Timeout(Duration.create(10, "seconds"));
        // Patterns.ask方法异步执行，参数分别是Actor引用，发送的消息，超时时间(秒)
        Future<Object> future = Patterns.ask(actorRef3, "Akka Ask", timeout);
        System.out.println("ask...");
        // ask操作以异步方式返回应答(通过onSuccess事件)
        future.onSuccess(new OnSuccess<Object>() {
            @Override
            public void onSuccess(Object result) throws Throwable {
                System.out.println("收到消息: " + result);
            }
        }, system.dispatcher());
        // ask操作以异步方式触发异常(通过onFailure事件)
        future.onFailure(new OnFailure() {
            @Override
            public void onFailure(Throwable failure) throws Throwable {
                System.out.println("出错了: " + failure.getMessage());
            }
        }, system.dispatcher());

        System.out.println("continue...");
        system.terminate();
    }
}
