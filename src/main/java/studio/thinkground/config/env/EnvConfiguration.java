package studio.thinkground.config.env;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import studio.thinkground.config.ProfileManager;


@Component
public class EnvConfiguration {

    private final Logger LOGGER = LoggerFactory.getLogger(ProfileManager.class);

    @Value("${studio.thinkground.loading.message}")
    private String message;

    @Value("${studio.thinkground.loading.message}")
    private String activeMode;

    @Bean
    @Profile("dev")
    public String getMessage(){
        LOGGER.info("env profile : " + message);
        return activeMode;
    };
}
