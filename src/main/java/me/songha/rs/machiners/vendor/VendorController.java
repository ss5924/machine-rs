package me.songha.rs.machiners.vendor;

import lombok.RequiredArgsConstructor;
import me.songha.rs.machiners.kafka.VendorProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/vendor")
public class VendorController {
    private final VendorService vendorService;
    private final VendorProducer vendorProducer;

    @GetMapping(value = "/id/{id}")
    public VendorDto getVendor(@PathVariable Long id) {
        return vendorService.getVendor(id);
    }

    @PostMapping(value = "/kafka")
    public ResponseEntity<String> saveVendor(@RequestBody VendorDto vendorDto) {
        try {
            vendorProducer.send(vendorDto);
            return ResponseEntity.ok("Message sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to send message");
        }
    }
}
