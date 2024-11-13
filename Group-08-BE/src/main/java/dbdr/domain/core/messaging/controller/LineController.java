package dbdr.domain.core.messaging.controller;

import dbdr.domain.core.messaging.service.LineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/line")
@RequiredArgsConstructor
public class LineController {
	private final LineService lineMessagingService;

	@PostMapping
	public void lineEvent(@RequestBody String requestBody) {
		lineMessagingService.handleLineEvent(requestBody);
	}
}