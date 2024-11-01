package dbdr.domain.careworker.entity;

import dbdr.domain.careworker.dto.request.CareworkerRequestDTO;
import dbdr.domain.core.base.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import java.time.LocalTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@Table(name = "careworkers")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE careworkers SET is_active = false WHERE id = ?")
@SQLRestriction("is_active = true")
public class Careworker extends BaseEntity {

    @Column(unique = true)
    private String loginId;

    private String loginPassword;

    @Column(nullable = false)
    @Pattern(regexp = "010\\d{8}")
    private String phone;

    @Column(nullable = false, length = 50)
    private String name;

    @Column
    private Long institutionId;

    @Column(nullable = true)
    private String lineUserId;

    @Column(nullable = true)
    private LocalTime alertTime;

    @Column(unique = true)
    private String email;

    @Builder
    public Careworker(Long institutionId, String name, String email, String phone) {
        this.institutionId = institutionId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.alertTime = LocalTime.of(17, 0); // 오후 5시로 초기화
    }

    public void updateCareworker(CareworkerRequestDTO careworkerDTO) {
        //this.institutionId = careworkerDTO.getInstitutionId();
        this.name = careworkerDTO.getName();
        this.email = careworkerDTO.getEmail();
        this.phone = careworkerDTO.getPhone();
    }

    public void updateLineUserId(String lineUserId) {
        this.lineUserId = lineUserId;
    }

    public void updateAlertTime(LocalTime alertTime) {
        this.alertTime = alertTime;
    }
}
