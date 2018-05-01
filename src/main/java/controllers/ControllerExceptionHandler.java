package controllers;

import exceptions.InfoNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(InfoNotFoundException.class)
    public String InfoNotFoundHandler(InfoNotFoundException e, Model model){
        model.addAttribute("id", e.getId());
        return "infoNotFound";
    }
}