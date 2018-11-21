package org.redmaplesoft.akka.practise1.ch24;

import akka.actor.UntypedActor;

/**
 * @author Max Yu
 * @version 创建时间：2018/11/9 15:10
 * 2.4 发送-接收消息
 */
public class DemoAskActor extends UntypedActor
{

    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println("发送者是: " + getSender());
        // 发送者是接收者自己
        getSender().tell("hello " + message, getSelf());

    }
}
