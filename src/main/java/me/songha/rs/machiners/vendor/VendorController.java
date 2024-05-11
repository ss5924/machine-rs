package me.songha.rs.machiners.vendor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import me.songha.rs.machiners.error.ErrorResponse;
import me.songha.rs.machiners.product.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/vendor")
public class VendorController {
    private final VendorService vendorService;
    private final VendorProducer vendorProducer;

    @Operation(summary = "Vendor 조회", description = "id로 Vendor를 조회한다.", operationId = "getVendor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = VendorDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Product Not Found", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
    @GetMapping(value = "/id/{id}")
    public VendorDto getVendor(@PathVariable Long id) {
        return vendorService.getVendor(id);
    }

    @Operation(summary = "Vendor 저장", description = "Vendor 정보를 저장한다.", operationId = "saveVendor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = ProductDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Request", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
    @PostMapping
    public ResponseEntity<String> saveVendor(@RequestBody VendorDto vendorDto) {
        try {
            vendorProducer.send(vendorDto);
            return ResponseEntity.ok("Message sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to send message");
        }
    }
}
