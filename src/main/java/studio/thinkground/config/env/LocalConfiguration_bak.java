package studio.thinkground.config.env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/*@Profile("local")
@Configuration*/
public class LocalConfiguration_bak implements EnvConfiguration_bak{
    @Value("${studio.thinkground.loading.message}")
    private String message;

    @Override
    @Bean
    public String getMessage(){
        return message;
    }

}
