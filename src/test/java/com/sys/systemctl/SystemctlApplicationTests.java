package com.sys.systemctl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemctlApplicationTests {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    @Test
    public void contextLoads() {
        kafkaTemplate.send("lockscreenTopic","1");
    }

}
