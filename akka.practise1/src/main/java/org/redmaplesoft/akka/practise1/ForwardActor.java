package org.redmaplesoft.akka.practise1;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

/**
 * @author Max Yu
 * @version 创建时间：2018/11/9 15:52
 */
public class ForwardActor extends UntypedAbstractActor {
    private ActorRef target = getContext().actorOf(Props.create(TargetActor.class),"targetActor");

    @Override
    public void onReceive(Object message) throws Throwable {
        System.out.println("Forward Actor receive: " + message + ", sender: " + getSender());
        target.forward(message,getContext());
    }
}
