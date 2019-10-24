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
    public void lockscreenTopic(String message){
        try{
            if(message !=null && message.equals("open")){
                String str = CtlUtils.lockScreen();// 执行指令 0 1
                kafkaTemplate.send("lockscreenTopicRes",str); //发送执行结果
            }else{
                kafkaTemplate.send("lockscreenTopicRes","0"); //发送执行结果
            }
        }catch (Exception e){
            kafkaTemplate.send("lockscreenTopicRes","0"); //发送执行结果
        }
    }
    //接受到指令
    @KafkaListener(topics = "unlockscreenTopic")
    public void unlockscreenTopic(String message){
        try{
            if(message !=null && message.equals("open")){
                String str = CtlUtils.unlockScreen();// 执行指令 0 1
                kafkaTemplate.send("unlockscreenTopicRes",str); //发送执行结果
            }else{
                kafkaTemplate.send("unlockscreenTopicRes","0"); //发送执行结果
            }
        }catch (Exception e){
            kafkaTemplate.send("unlockscreenTopicRes","0"); //发送执行结果
        }
    }
    //接受到指令
    @KafkaListener(topics = "calcTopic")
    public void calcTopic(String message){
        try{
            if(message !=null && message.equals("open")){
                String str = CtlUtils.calc();// 执行指令 0 1
                kafkaTemplate.send("calcTopicRes",str); //发送执行结果
            }else{
                kafkaTemplate.send("calcTopicRes","0"); //发送执行结果
            }
        }catch (Exception e){
            kafkaTemplate.send("calcTopicRes","0"); //发送执行结果
        }
    }
    //接受到指令
    @KafkaListener(topics = "shutdownTopic")
    public void shutdownTopic(String message){
        try{
            if(message !=null && message.equals("open")){
                String str = CtlUtils.shutdown();// 执行指令 0 1
                kafkaTemplate.send("shutdownTopicRes",str); //发送执行结果
            }else{
                kafkaTemplate.send("shutdownTopicRes","0"); //发送执行结果
            }
        }catch (Exception e){
            kafkaTemplate.send("shutdownTopicRes","0"); //发送执行结果
        }
    }
    //接受到指令
    @KafkaListener(topics = "shutdowntenTopic")
    public void shutdowntenTopic(String message){
        try{
            if(message !=null && message.equals("open")){
                String str = CtlUtils.shutdownten();// 执行指令 0 1
                kafkaTemplate.send("shutdowntenTopicRes",str); //发送执行结果
            }else{
                kafkaTemplate.send("shutdowntenTopicRes","0"); //发送执行结果
            }
        }catch (Exception e){
            kafkaTemplate.send("shutdowntenTopicRes","0"); //发送执行结果
        }
    }
    //接受到指令
    @KafkaListener(topics = "shutdownnowTopic")
    public void shutdownnowTopic(String message){
        try{
            if(message !=null && message.equals("open")){
                String str = CtlUtils.shutdown();// 执行指令 0 1
                kafkaTemplate.send("shutdownnowTopicRes",str); //发送执行结果
            }else{
                kafkaTemplate.send("shutdownnowTopicRes","0"); //发送执行结果
            }
        }catch (Exception e){
            kafkaTemplate.send("shutdownnowTopicRes","0"); //发送执行结果
        }
    }
    //接受到指令
    @KafkaListener(topics = "canceshutdowTopic")
    public void canceshutdowTopic(String message){
        try{
            if(message !=null && message.equals("open")){
                String str = CtlUtils.canceshutdown();// 执行指令 0 1
                kafkaTemplate.send("canceshutdowTopicRes",str); //发送执行结果
            }else{
                kafkaTemplate.send("canceshutdowTopicRes","0"); //发送执行结果
            }
        }catch (Exception e){
            kafkaTemplate.send("canceshutdowTopicRes","0"); //发送执行结果
        }
    }
    //接受到指令
    @KafkaListener(topics = "taskmgrTopic")
    public void taskmgrTopic(String message){
        try{
            if(message !=null && message.equals("open")){
                String str = CtlUtils.taskmgr();// 执行指令 0 1
                kafkaTemplate.send("taskmgrTopicRes",str); //发送执行结果
            }else{
                kafkaTemplate.send("taskmgrTopicRes","0"); //发送执行结果
            }
        }catch (Exception e){
            kafkaTemplate.send("taskmgrTopicRes","0"); //发送执行结果
        }
    }
    //接受到指令
    @KafkaListener(topics = "openqqTopic")
    public void openqqTopic(String message){
        try{
            if(message !=null && message.equals("open")){
                String str = CtlUtils.openqq();// 执行指令 0 1
                kafkaTemplate.send("openqqTopicRes",str); //发送执行结果
            }else{
                kafkaTemplate.send("openqqTopicRes","0"); //发送执行结果
            }
        }catch (Exception e){
            kafkaTemplate.send("openqqTopicRes","0"); //发送执行结果
        }
    }


    //接受到指令
    @KafkaListener(topics = "closeqqTopic")
    public void closeqqTopic(String message){
        try{
            if(message !=null && message.equals("open")){
                String str = CtlUtils.closeqq();// 执行指令 0 1
                kafkaTemplate.send("closeqqTopicRes",str); //发送执行结果
            }else{
                kafkaTemplate.send("closeqqTopicRes","0"); //发送执行结果
            }
        }catch (Exception e){
            kafkaTemplate.send("closeqqTopicRes","0"); //发送执行结果
        }
    }
    //接受到指令
    @KafkaListener(topics = "openwechatTopic")
    public void openwechatTopic(String message){
        try{
            if(message !=null && message.equals("open")){
                String str = CtlUtils.openwechat();// 执行指令 0 1
                kafkaTemplate.send("openwechatTopicRes",str); //发送执行结果
            }else{
                kafkaTemplate.send("openwechatTopicRes","0"); //发送执行结果
            }
        }catch (Exception e){
            kafkaTemplate.send("openwechatTopicRes","0"); //发送执行结果
        }
    }
    //接受到指令
    @KafkaListener(topics = "closewechatTopic")
    public void closewechatTopic(String message){
        try{
            if(message !=null && message.equals("open")){
                String str = CtlUtils.closeWechat();// 执行指令 0 1
                kafkaTemplate.send("closewechatTopicRes",str); //发送执行结果
            }else{
                kafkaTemplate.send("closewechatTopicRes","0"); //发送执行结果
            }
        }catch (Exception e){
            kafkaTemplate.send("closewechatTopicRes","0"); //发送执行结果
        }
    }
    //接受到指令
    @KafkaListener(topics = "seleepTopic")
    public void seleepTopic(String message){
        try{
            if(message !=null && message.equals("open")){
                String str = CtlUtils.seleep();// 执行指令 0 1
                kafkaTemplate.send("seleepTopicRes",str); //发送执行结果
            }else{
                kafkaTemplate.send("seleepTopicRes","0"); //发送执行结果
            }
        }catch (Exception e){
            kafkaTemplate.send("seleepTopicRes","0"); //发送执行结果
        }
    }
    //接受到指令
    @KafkaListener(topics = "autoctlTopic")
    public void autoctlTopic(String message){
        try{
            if(message !=null && message.equals("open")){
                String str = CtlUtils.autoctl("");// 执行指令 0 1
                kafkaTemplate.send("autoctlTopicRes",str); //发送执行结果
            }else{
                kafkaTemplate.send("autoctlTopicRes","0"); //发送执行结果
            }
        }catch (Exception e){
            kafkaTemplate.send("autoctlTopicRes","0"); //发送执行结果
        }
    }


}