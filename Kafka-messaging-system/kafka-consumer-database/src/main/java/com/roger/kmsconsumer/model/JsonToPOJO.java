package com.roger.kmsconsumer.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roger.kmsconsumer.db.WikimediaRecord;

public class JsonToPOJO {
    public static WikimediaRecord toEventInfo(String data) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            WikimediaRecord wikimediaRecord = objectMapper.readValue(data, WikimediaRecord.class);
            return wikimediaRecord;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new WikimediaRecord();
    }
}
