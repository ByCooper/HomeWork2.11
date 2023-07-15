package ru.ByCooper.basketshop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
@Service
@SessionScope
public class ServiceBasketImpl implements ServiceBasket{
    @Value("${valueFromConfigurationFileStart}")
    private String stringStart;

    @Value("${valueFromConfigurationFileStop}")
    private String stringStop;

    private final List<Integer> basket = new ArrayList<>();

    @PostConstruct
    public void setup() {
        System.out.println(stringStart);
    }

    @PreDestroy
    public void destroy() {
        System.out.println(stringStop);
    }

    @Override
    public String addPosition(List<Integer> position) {
        basket.addAll(position);
        return "Добавлены в корзину следующие значения" + position;
    }

    @Override
    public String showBasket() throws JsonProcessingException {
        if (basket.isEmpty()) {
            return "Корзина пуста";
        }
        return objectMapper.writeValueAsString(basket);
    }

    private final ObjectMapper objectMapper;

    public ServiceBasketImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
