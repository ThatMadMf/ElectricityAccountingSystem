package org.system.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RowNotFoundException.class)
    public String handleExceptionRowNotFound(Model model) {

        model.addAttribute("success", false);
        return "submission-result";
    }

    @ExceptionHandler(NoRowUpdatedException.class)
    public String handleExceptionNoRowUpdated(Model model) {

        model.addAttribute("success", false);
        return "submission-result";
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleExceptionIntegrityViolation(Model model) {

        model.addAttribute("success", false);
        return "submission-result";
    }
}
