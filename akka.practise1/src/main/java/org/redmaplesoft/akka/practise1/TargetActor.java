package org.redmaplesoft.akka.practise1;

import akka.actor.UntypedAbstractActor;

/**
 * @author Max Yu
 * @version 创建时间：2018/11/9 15:51
 */
public class TargetActor extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Throwable {
        System.out.println("Target Actor receive: " + message + ", sender=" + getSender());
    }
}
