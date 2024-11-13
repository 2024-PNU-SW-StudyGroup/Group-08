package dbdr.domain.recipient.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecipientResponse {
    private Long id;
    private String name;
    private LocalDate birth;
    private String gender;
    private String careLevel;
    private String careNumber;
    private LocalDate startDate;
    private String institution;
    private Long institutionNumber;
    private Long institutionId;
    private Long careworkerId;
    private Long guardianId;
}
