package org.redmaplesoft.akka.practise1.ch211;

import akka.actor.UntypedActor;
import akka.pattern.CircuitBreaker;
import scala.Option;
import scala.concurrent.duration.Duration;

import java.util.concurrent.Callable;

public class WorkerActor3 extends UntypedActor {
    private CircuitBreaker breaker;

    @Override
    public void preStart() throws Exception {
        super.preStart();
        this.breaker = new CircuitBreaker(getContext().dispatcher(),
                getContext().system().scheduler(), 5,
                Duration.create(2, "s"),
                Duration.create(1, "min"))
                .onOpen(new Runnable() {
                    public void run() {
                        System.out.println("Actor CircuitBreaker 开启");
                    }
                })
                .onHalfOpen(new Runnable() {
                    public void run() {
                        System.out.println("Actor CircuitBreaker 半开启");
                    }
                })
                .onClose(new Runnable() {
                    public void run() {
                        System.out.println("Actor CircuitBreaker 关闭");
                    }
                });
    }



    @Override
    public void onReceive(Object message) throws Exception {

        if (message instanceof String) {
            final String msg = (String)message;
            if(msg.startsWith("sync")){
                getSender().tell(breaker.callWithSyncCircuitBreaker(
                        new Callable<String>() {

                            public String call() throws Exception {
                                System.out.println("msg:" + msg);
                                Thread.sleep(3000);
                                return msg;
                            }
                        }),getSelf());
            }
        }

    }


}
