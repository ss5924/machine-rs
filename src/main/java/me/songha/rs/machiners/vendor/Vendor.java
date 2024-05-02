package me.songha.rs.machiners.vendor;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "vendor")
public class Vendor implements Serializable {
    @Serial
    private static final long serialVersionUID = 5376360598329370571L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vendorName;
    private String vendorAddress;
    private String vendorFax;
    @CreatedDate
    private LocalDateTime createAt;
    @LastModifiedDate
    private LocalDateTime updateAt;

    public VendorDto toVendorDto() {
        return VendorDto.builder()
                .id(this.id)
                .vendorName(this.vendorName)
                .vendorFax(this.vendorFax)
                .vendorAddress(this.vendorAddress)
                .createAt(this.createAt)
                .updateAt(this.updateAt)
                .build();
    }
}
