package me.songha.rs.machiners.vendor;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/vendor")
public class VendorController {

    private final VendorService vendorService;

    @GetMapping(value = "/id/{id}")
    public VendorDto getVendor(@PathVariable Long id) {
        return vendorService.getVendor(id);
    }

}
