package idv.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class getRedisDataConfig {

    @Value("${configA}")
    private String configA;
    @Value("${configB}")
    private String configB;
    @Value("${angus001}")
    private String angus001;


    public String getConfigA() {
        return configA;
    }

    public void setConfigA(String configA) {
        this.configA = configA;
    }

    public String getConfigB() {
        return configB;
    }

    public void setConfigB(String configB) {
        this.configB = configB;
    }

	public String getAngus001() {
		return angus001;
	}

	public void setAngus001(String angus001) {
		this.angus001 = angus001;
	}
    
}
