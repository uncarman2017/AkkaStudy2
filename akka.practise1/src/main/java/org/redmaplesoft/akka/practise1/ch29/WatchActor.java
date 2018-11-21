package org.redmaplesoft.akka.practise1.ch29;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import org.redmaplesoft.akka.practise1.ch29.WorkerActor;

public class WatchActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    ActorRef child = null;

    @Override
    public void preStart() throws Exception {
        // 创建子Actor
        child = getContext().actorOf(Props.create(WorkerActor.class),"workerActor");
        // 监控child
        getContext().watch(child);
    }

    @Override
    public void postStop() throws Exception {
        log.info("WatchActor postStop");
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof String){
            if(message.equals("stopChild")){
                getContext().stop(child);
            }
        }
        else if(message instanceof Terminated){
            Terminated t= (Terminated) message;
            log.info("监控到" + t.getActor() + "停止了");
        }
        else {
            unhandled(message);
        }
    }
}
