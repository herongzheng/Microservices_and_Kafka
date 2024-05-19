package com.roger.kmsconsumer.db;

import jakarta.persistence.*;

@Entity
@Table(name = "wikimedia_event")
public class WikimediaRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String eventMessage;

    public WikimediaRecord setEventMessage(String eventMessage) {
        this.eventMessage = eventMessage;
        return this;
    }
}
