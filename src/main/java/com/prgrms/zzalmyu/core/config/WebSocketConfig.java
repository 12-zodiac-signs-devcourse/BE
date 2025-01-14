package com.prgrms.zzalmyu.core.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat") // 웹소켓 서버의 엔드포인트
            .setAllowedOrigins("http://localhost:5173", "https://zzalmyu.asia", "https://www.zzalmyu.asia")
            .withSockJS(); // 클라이언트는 다른 origin -> cors 오류 방지
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 해당 경로로 들어오는 것을 구독하는 것으로 정함
        registry.enableSimpleBroker("/sub");

        // @MessageMapping("hello") 라면 경로는 -> pub/hello
        registry.setApplicationDestinationPrefixes("/pub");
    }
}
