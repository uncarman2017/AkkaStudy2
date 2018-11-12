package org.redmaplesoft.akka.practise1;

import akka.actor.*;
import akka.japi.Function;
import scala.concurrent.duration.Duration;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 2.10 监督与容错处理
 */
public class SupervisorActor extends UntypedActor {
    private SupervisorStrategy strategy = new OneForOneStrategy(3, Duration.create("1 minute"),
            new Function<Throwable, SupervisorStrategy.Directive>() {
                public SupervisorStrategy.Directive apply(Throwable t) {
                    if (t instanceof IOException) {
                        System.out.println("===============IOException==================");
                        return SupervisorStrategy.resume();
                    } else if (t instanceof IndexOutOfBoundsException) {
                        System.out.println("===============IndexOutOfBoundsException==================");
                        return SupervisorStrategy.restart();
                    } else if (t instanceof SQLException) {
                        System.out.println("=============SQLException======================");
                        return SupervisorStrategy.stop();
                    } else {
                        System.out.println("================escalate=========================");
                        return SupervisorStrategy.escalate();
                    }

                }

            });


    @Override
    public void preStart() throws Exception {
        // 创建子Actor
        ActorRef workerActor = getContext().actorOf(Props.create(WorkerActor2.class), "workActor2");

        // 监控生命周期
        getContext().watch(workerActor);
    }


    @Override
    public SupervisorStrategy supervisorStrategy() {
        return strategy;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Terminated) {
            Terminated ter = (Terminated) message;
            System.out.println(ter.getActor() + "已经终止");
        } else {
            System.out.println("stateCount=" + message);
        }
    }
}
