package me.songha.rs.machiners.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.songha.rs.machiners.vendor.VendorDto;
import me.songha.rs.machiners.vendor.VendorService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class VendorConsumer {
    private final ObjectMapper objectMapper;
    private final VendorService vendorService;

    @KafkaListener(topics = "rs-topic", groupId = "rs-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(ConsumerRecord<String, String> record) {
        try {
            VendorDto vendorDto = objectMapper.readValue(record.value(), VendorDto.class);
            VendorDto result = vendorService.save(vendorDto);
            log.info("VendorConsumer.consume result->{}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}