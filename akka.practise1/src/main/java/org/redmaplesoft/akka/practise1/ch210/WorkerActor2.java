package org.redmaplesoft.akka.practise1.ch210;

import akka.actor.UntypedActor;
import scala.Option;

public class WorkerActor2 extends UntypedActor {
    private int stateCount = 1;

    @Override
    public void preStart() throws Exception {
        super.preStart();
        System.out.println("Worker actor preStart");
    }

    @Override
    public void postStop() throws Exception {
        super.postStop();
        System.out.println("Worker actor postStop");
    }

    @Override
    public void preRestart(Throwable reason, Option<Object> message) throws Exception {
        System.out.println("worker actor preRestart begin " + this.stateCount);
        super.preRestart(reason, message);
        System.out.println("worker actor preRestart end " + this.stateCount);
    }

    @Override
    public void postRestart(Throwable reason) throws Exception {
        System.out.println("worker actor postRestart begin " + this.stateCount);
        super.postRestart(reason);
        System.out.println("worker actor postRestart end " + this.stateCount);
    }

    @Override
    public void onReceive(Object message) throws Exception {
        // 模拟计算任务
        this.stateCount++;
        if (message instanceof Exception) {
            throw (Exception) message;
        } else if ("getvalue".equals(message)) {
            getSender().tell(stateCount, getSelf());
        } else {
            unhandled(message);
        }

    }
}
