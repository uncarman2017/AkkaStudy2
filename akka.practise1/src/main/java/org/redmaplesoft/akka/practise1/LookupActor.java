package org.redmaplesoft.akka.practise1;

import akka.actor.ActorIdentity;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.Identify;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * @author Max Yu
 * @version 创建时间：2018/11/9 16:26
 */
public class LookupActor extends UntypedActor {
    private ActorRef target = getContext().actorOf(Props.create(TargetActor.class), "targetActor");


    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            if ("find".equals(message)) {
                ActorSelection as = getContext().actorSelection("targetActor");
                as.tell(new Identify("A001"), getSelf());
            }
        } else if (message instanceof ActorIdentity) {
            ActorIdentity ai = (ActorIdentity) message;
            if (ai.correlationId().equals("A001")) {
                ActorRef ref = ai.getRef();
                if (ref != null) {
                    System.out.println("ActorIdentity: " + ai.correlationId() + "" + ref);
                    ref.tell("hello target", getSelf());
                }
            }
        } else

        {
            unhandled(message);
        }
   }


}
