package org.redmaplesoft.akka.practise1;

import akka.actor.Actor;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Creator;

/**
 * @author Max Yu
 * @version 创建时间：2018/11/9 14:35
 */
public class PropsDemoActor extends UntypedAbstractActor {
    private LoggingAdapter log = Logging.getLogger(this.getContext().system(), this);


    /**
     * 用于接收并处理消息
     *
     * @param message
     * @throws Exception
     */
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            log.info(message.toString());
        } else {
            // 匹配不到相应的消息类型时，推荐使用unhandled进行处理
            unhandled(message);
        }
    }


    public static Props createProps() {
        return Props.create(new Creator<PropsDemoActor>() {

            @Override
            public PropsDemoActor create() throws Exception {
                return new PropsDemoActor();
            }
        });
    }


}
