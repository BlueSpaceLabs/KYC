package org.techdisqus.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.techdisqus.response.AbstractResponse;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequest(BadRequestException ex) {
        log.error("BadRequestException: Error while executing request ", ex);
        return buildResponse(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        log.error("Error while executing request ", ex);
        return buildResponse(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ApiExecutionException.class)
    public ResponseEntity<?> handleApiExecException(MethodArgumentTypeMismatchException ex) {
        log.error("ApiExecutionException: Error while executing request ", ex);
        return buildResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(Exception ex) {
        log.error("Exception: Error while executing request ", ex);
        return buildResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<AbstractResponse> buildResponse(BaseException exception, HttpStatus status) {

        AbstractResponse response = AbstractResponse.builder()
                .errorDetails(exception.getErrorMessage())
                .errorCode(exception.getErrorCode())
                .requestId(exception.getRequest().getRequestId()).build();
        response.setUserData(exception.getRequest().getRequestInformation());


        return new ResponseEntity<>(response, status);
    }

    private ResponseEntity<AbstractResponse> buildResponse(Exception exception, HttpStatus status) {

        AbstractResponse response = AbstractResponse.builder()
                .errorDetails(exception.getMessage())
                .errorCode(exception.getMessage())
                .build();

        return new ResponseEntity<>(response, status);
    }
}
