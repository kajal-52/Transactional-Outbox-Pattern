package com.spring.orderpoller.service;

import com.spring.orderpoller.entity.Outbox;
import com.spring.orderpoller.publisher.Publisher;
import com.spring.orderpoller.repository.OutboxRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableScheduling
@Slf4j
public class OrderPollerService {

    @Autowired
    OutboxRepository outboxRepository;

    @Autowired
    Publisher publisher;

    @Scheduled(fixedRate = 60000)
    public void pollMessageAndPublished(){
        //fetch unprocessed records
        List<Outbox> outboxList =  outboxRepository.findByProcessed(false);
        log.info(outboxList.size()+" unprocessed records ");
        //process each record
        for (Outbox outbox: outboxList){
            try {
                publisher.publish(String.valueOf(outbox));
                // set processed to true to mark processed
                outbox.setProcessed(true);
                outboxRepository.save(outbox);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
