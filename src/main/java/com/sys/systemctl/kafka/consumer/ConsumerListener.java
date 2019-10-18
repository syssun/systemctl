package com.sys.systemctl.kafka.consumer;

import com.sys.systemctl.Utils.CtlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * 消费者监听 topic
 */
@Component
public class ConsumerListener {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    //接受到指令
    @KafkaListener(topics = "lockscreenTopic")
    public void onMessage(String message){
        String str = CtlUtils.lockScreen();// 执行指令 0 1
        System.out.println(message); //发送执行结果
        kafkaTemplate.send("lockscreenTopic_res",str); //发送执行结果
    }

}