package ru.algobank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail onValidationError(MethodArgumentNotValidException ex) {
        String detail = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(f -> f.getField() + ": " + f.getDefaultMessage())
                .collect(Collectors.joining("; "));

        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, detail);
        pd.setTitle("Validation failed");
        return pd;

    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ProblemDetail onNotFound(AccountNotFoundException ex) {
        String detail = ex.getMessage();

        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, detail);
        pd.setTitle("Account not found");
        return pd;
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ProblemDetail haveNoMoney(InsufficientFundsException ex) {
        String detail = ex.getMessage();

        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, detail);
        pd.setTitle("Have no money");
        return pd;
    }

}
