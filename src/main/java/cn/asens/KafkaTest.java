package cn.asens;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

/**
 * @author Asens
 * create 2019-01-17 16:29
 **/
@RestController
public class KafkaTest {
    public static Logger logger = LoggerFactory.getLogger(Application.class);

    @Resource
    private KafkaTemplate<String, String> template;

    @RequestMapping("/")
    public Object index() throws Exception{
        template.send("myTopic", "foo1");
        return "success";
    }



    @KafkaListener(topics = "myTopic")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        logger.info(cr.toString());
    }


}
