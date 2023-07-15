package ru.ByCooper.basketshop;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ServiceBasket {
    String addPosition(List<Integer> position);
    String showBasket() throws JsonProcessingException;

}
