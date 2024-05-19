package com.roger.kmsconsumer;

import com.roger.kmsconsumer.db.EventRepository;
import com.roger.kmsconsumer.db.WikimediaRecord;
import com.roger.kmsconsumer.model.JsonToPOJO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private final EventRepository eventRepository;

    public KafkaConsumer(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @KafkaListener(topics = "wikimedia-recentchange", groupId = "myGroup")
    public void consume(String eventMessage) {
        LOGGER.info("event message received -> " + eventMessage);
        WikimediaRecord wikimediaRecord = JsonToPOJO.toEventInfo(eventMessage);
        eventRepository.save(wikimediaRecord);
    }
}
