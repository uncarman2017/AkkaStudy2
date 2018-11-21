package org.redmaplesoft.akka.practise1.ch29;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class WorkerActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(),this);

    @Override
    public void onReceive(Object message) throws Exception {
        log.info("收到消息: " + message);
    }

    @Override
    public void postStop() throws Exception {
        log.info("Worker postStop");
    }
}
