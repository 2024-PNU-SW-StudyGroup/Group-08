package dbdr.domain.core.alarm.repository;

import dbdr.domain.core.alarm.entity.Alarm;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {
	Optional<Alarm> findByPhone(String phone);

	Optional<Alarm> findByPhoneAndAlertTime(String phone, LocalDateTime alertTime);
}
