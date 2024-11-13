package dbdr.domain.core.ocr.repository;

import dbdr.domain.core.ocr.entity.OcrData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcrRepository extends JpaRepository<OcrData, Long> {
	OcrData findByObjectKey(String objectKey);
}
