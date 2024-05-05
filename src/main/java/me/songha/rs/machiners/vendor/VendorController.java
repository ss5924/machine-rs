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
        vendorProducer.send(vendorDto);
        return ResponseEntity.ok("Vendor request sent to Kafka!");
    }

}
