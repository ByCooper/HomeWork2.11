package ru.ByCooper.basketshop;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class BasketController {
    private final ServiceBasketImpl service;

    public BasketController(ServiceBasketImpl service) {
        this.service = service;
    }

    @GetMapping(path = "/add")
    public String addPosition(@RequestParam("position") List<Integer> position) {
        return service.addPosition(position);
    }

    @GetMapping(path = "/get")
    public String showBasket() throws JsonProcessingException {
        return service.showBasket();
    }
}
