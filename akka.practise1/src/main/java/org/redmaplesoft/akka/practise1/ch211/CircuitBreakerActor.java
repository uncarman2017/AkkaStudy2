package org.redmaplesoft.akka.practise1.ch211;

import akka.actor.*;
import akka.japi.Function;
import org.redmaplesoft.akka.practise1.ch29.WorkerActor;
import scala.concurrent.duration.Duration;

/**
 *
 */
public class CircuitBreakerActor extends UntypedActor {
    private ActorRef workerChild;
    private static SupervisorStrategy strategy = new OneForOneStrategy(20, Duration.create("1 minute"),
            new Function<Throwable, SupervisorStrategy.Directive>() {

                public SupervisorStrategy.Directive apply(Throwable t) throws Exception {
                    return SupervisorStrategy.resume();
                }
            });

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return strategy;
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();
        workerChild = getContext().actorOf(Props.create(WorkerActor3.class),"workerActor3");
    }

    @Override
    public void onReceive(Object message) throws Exception {
        workerChild.tell(message,getSelf());
    }
}
