package org.redmaplesoft.akka.practise1;

import akka.actor.UntypedActor;

/**
 * @author Max Yu
 * @version 创建时间：2018/11/9 15:51
 */
public class TargetActor extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println("Target Actor receive: " + message + ", sender=" + getSender());
    }
}
