package com.roger.kmsconsumer.db;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "wikimedia_event")
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikimediaRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonProperty("id")
    private long eventId ;
    @Column(columnDefinition = "TEXT")
    private String comment;
    private String user;
    @JsonProperty("notify_url")
    private String notifyUrl;

    public WikimediaRecord setEventId(long eventId) {
        this.eventId = eventId;
        return this;
    }

    public WikimediaRecord setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public WikimediaRecord setUser(String user) {
        this.user = user;
        return this;
    }

    public WikimediaRecord setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }
}
