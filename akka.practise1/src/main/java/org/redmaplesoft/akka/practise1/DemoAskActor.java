package org.redmaplesoft.akka.practise1;

import akka.actor.UntypedAbstractActor;

/**
 * @author Max Yu
 * @version 创建时间：2018/11/9 15:10
 * 2.4 发送-接收消息
 */
public class DemoAskActor extends UntypedAbstractActor
{

    @Override
    public void onReceive(Object message) throws Throwable {
        System.out.println("发送者是: " + getSender());
        // 发送者是接收者自己
        getSender().tell("hello " + message, getSelf());

    }
}
