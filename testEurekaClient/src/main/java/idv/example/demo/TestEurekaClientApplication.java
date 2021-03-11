package idv.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class TestEurekaClientApplication {
	static Logger logger = LoggerFactory.getLogger(TestEurekaClientApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TestEurekaClientApplication.class, args);
		logger.info("「「「「「用戶服務啟動完成.」」」」」");
	}
	@GetMapping(value = "/index")
	public String index() {
	return "this is user index";
	}
}
