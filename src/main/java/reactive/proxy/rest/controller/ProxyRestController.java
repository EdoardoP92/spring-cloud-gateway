package reactive.proxy.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
public class ProxyRestController {

	@GetMapping
	public String fallback() {
		return "fallback";
	}
}
