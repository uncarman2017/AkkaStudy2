package org.redmaplesoft.akka.practise1.ch23;

//import akka.actor.UntypedActor;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import org.redmaplesoft.akka.practise1.CommonMsg;

/**
 * @author Max Yu
 * @version 创建时间：2018/11/9 14:12
 * UntypedActor: 基于经典的Actor模型实现, 能完整表达Akka-Actor的设计思想
 * TypedAbstractorActor:
 */
public class DemoActor extends UntypedActor
{
    private LoggingAdapter log = Logging.getLogger(this.getContext().system(),this);


    /**
     * 用于接收并处理消息
     * @param message
     * @throws Exception
     */
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            log.info(message.toString());
        } else if (message instanceof CommonMsg) {
            CommonMsg msg = (CommonMsg) message;
            log.info("title={},content={}", msg.getTitle(), msg.getContent());

        } else {
            // 匹配不到相应的消息类型时，推荐使用unhandled进行处理
            unhandled(message);
        }
    }
}
