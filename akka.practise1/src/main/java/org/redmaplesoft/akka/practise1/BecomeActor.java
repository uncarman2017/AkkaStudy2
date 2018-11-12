package org.redmaplesoft.akka.practise1;

import akka.actor.UntypedActor;
import akka.japi.Procedure;

/**
 * 2.7 Actor行为切换
 */
public class BecomeActor extends UntypedActor
{
    Procedure<Object> procedure = new Procedure<Object>() {
        public void apply(Object message) throws Exception {
            System.out.println("become: " + message);
        }
    };

    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println("接收到消息：" + message);

        getContext().become(procedure);
        System.out.println("---------------------------------------");
    }
}
