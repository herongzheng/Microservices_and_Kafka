package com.roger.kms;

import com.launchdarkly.eventsource.background.BackgroundEventSource;
import com.launchdarkly.eventsource.EventSource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaInfoProducer {
    private KafkaTemplate<String, String> kafkaTemplate;
    public WikimediaInfoProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {
        String topic = "wikimedia-recentchange";
        // to get real-time stream data from wikimedia pushed to our backend,
        // use background event source which use asynchronous push model
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder eventSourcebuilder = new EventSource.Builder(URI.create(url));
        BackgroundEventSource.Builder builder = new BackgroundEventSource.Builder(
                new WikipediaInfoHandler(kafkaTemplate, topic), eventSourcebuilder);
        BackgroundEventSource backgroundEventSource = builder.build();
        try (backgroundEventSource) {
            backgroundEventSource.start();
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
