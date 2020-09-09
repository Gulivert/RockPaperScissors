package com.rockpaperscissors.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ggmartin.paperrockscissors.client.ApiClient;
import com.ggmartin.paperrockscissors.client.api.GameControllerApi;

@Configuration
public class WebConfiguration {

    @Value("${const.serverPath}")
    private String path;
    
    @Bean
	public GameControllerApi getGameControllerApi() {
		ApiClient client = new ApiClient();
		client.setBasePath(path);
		GameControllerApi gameControllerApi = new GameControllerApi(client);
		return gameControllerApi;
	}
}
