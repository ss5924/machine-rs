package me.songha.rs.machiners.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.songha.rs.machiners.vendor.VendorDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Slf4j
@RequiredArgsConstructor
@Component
public class VendorProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value(value = "${spring.kafka.template.default-topic}")
    private String TOPIC;

    public void send(VendorDto vendorDto) {

        try {
            String jsonObject = objectMapper.writeValueAsString(vendorDto);

            CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC, jsonObject);

            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    log.info("Sent message=[{}], with offset=[{}]", jsonObject, result.getRecordMetadata().offset());
                } else {
                    log.error("Unable to send message={}, due to : {}", jsonObject, ex.getMessage());
                }
            });
        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();
        }
    }
}

