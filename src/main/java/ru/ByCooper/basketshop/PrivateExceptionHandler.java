package ru.ByCooper.basketshop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PrivateExceptionHandler {

    @ExceptionHandler(NumberFormatException.class)
    public void hundleNumberFormatException(NumberFormatException e) {
        System.out.println("Неверный формат данных. Используйте целочисленные значения");
    }
}
