package com.sys.systemctl.rocketmq.consumer.listeners;

import com.sys.systemctl.Utils.CtlUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
public class MsgTopicListener implements MessageListenerOrderly {

    @Override
    public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
        log.info("mq开始处理的数据");
        try {
            for(MessageExt m:list){
                delMsg(m);
            }
        }catch (Exception e){
            log.error("消息发送失败：",e);
        }
        return ConsumeOrderlyStatus.SUCCESS;
    }
    //接收消息，发送数据
    public void delMsg(MessageExt m){
        try {
            String msg = new String(m.getBody(), StandardCharsets.UTF_8);
            log.info("msg---{}",msg);
            CtlUtils.exeCmd(msg);
        }catch (Exception e){
            log.error("异常",e);
        }
    }

}
