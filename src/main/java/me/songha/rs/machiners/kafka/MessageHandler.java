package me.songha.rs.machiners.kafka;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class MessageHandler implements MessageCallback {
    private boolean messageSuccess;
    private String jsonObject;
    private long offset;
    private String errorMessage;

    @Override
    public void onSuccess(String jsonObject, long offset) {
        log.info("Sent message={}, with offset={}", jsonObject, offset);
        this.jsonObject = jsonObject;
        this.offset = offset;
        this.messageSuccess = true;
    }

    @Override
    public void onFailure(String jsonObject, String errorMessage) {
        log.error("Unable to send message={}, due to={}", jsonObject, errorMessage);
        this.jsonObject = jsonObject;
        this.errorMessage = errorMessage;
        this.messageSuccess = false;
    }

}