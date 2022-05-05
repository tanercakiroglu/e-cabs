package com.example.ecabs.config;

import com.example.ecabs.model.response.WrapperResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.example.ecabs.constant.ErrorCodes.RESOURCE_NOT_FOUND;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;


@ControllerAdvice
@ResponseBody
@Log4j2
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler({ResourceNotFoundException.class, EntityNotFoundException.class})
    @ResponseStatus(value = NOT_FOUND)
    public WrapperResponse resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

        var errorMessages = messageSource.getMessage(RESOURCE_NOT_FOUND, null, request.getLocale());
        log.error("ResourceNotFoundException ", ex);
        return WrapperResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(NOT_FOUND.value())
                .errorMessage(List.of(errorMessages))
                .build();
    }

    @ExceptionHandler(value = {IllegalArgumentException.class, HttpMessageNotReadableException.class})
    @ResponseStatus(value = BAD_REQUEST)
    public WrapperResponse illegalArgumentExceptionErrorHandler(IllegalArgumentException ex, WebRequest request) {
        log.error("IllegalArgumentException ", ex);
        return WrapperResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(BAD_REQUEST.value())
                .errorMessage(List.of(ex.getMessage()))
                .build();
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = BAD_REQUEST)
    protected WrapperResponse handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {

        var errorMessages = ex.getBindingResult().getAllErrors()
                .stream()
                .map(message -> messageSource.getMessage(Objects.requireNonNull(message.getDefaultMessage()), null, request.getLocale()))
                .collect(Collectors.toList());
        log.error("MethodArgumentNotValidException ", ex);
        return WrapperResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(BAD_REQUEST.value())
                .errorMessage(errorMessages)
                .build();
    }


}
