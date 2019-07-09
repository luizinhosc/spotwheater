package spotwheater.controller;

import spotwheater.exception.DifferentAccountsException;
import spotwheater.exception.EmptyCollectionException;
import spotwheater.exception.DefaultExceptionAttributes;
import spotwheater.exception.ExceptionAttributes;
import spotwheater.exception.MoreThanOneAccountClientException;
import spotwheater.exception.MoreThanOneAccountOwnershipException;
import spotwheater.exception.NoAccountOwnershipException;
import spotwheater.exception.NotEmptyCollectionException;
import spotwheater.exception.NotFoundException;
import spotwheater.exception.NotUniqueException;
import spotwheater.exception.ValidationException;
import spotwheater.validation.ValidationUtil;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(DifferentAccountsException.class)
    public ResponseEntity<Map<String, Object>> handleDifferentAccountsException(Exception exception, HttpServletRequest request) {
        ExceptionAttributes exceptionAttributes = new DefaultExceptionAttributes();

        Map<String, Object> responseBody = exceptionAttributes.getExceptionAttributes(exception.getMessage(), exception, request, HttpStatus.UNPROCESSABLE_ENTITY);

        return new ResponseEntity<>(responseBody, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    @ExceptionHandler(EmptyCollectionException.class)
    public ResponseEntity<Map<String, Object>> handleEmptyCollectionException(Exception exception, HttpServletRequest request) {
        ExceptionAttributes exceptionAttributes = new DefaultExceptionAttributes();

        Map<String, Object> responseBody = exceptionAttributes.getExceptionAttributes(exception.getMessage(), exception, request, HttpStatus.UNPROCESSABLE_ENTITY);

        return new ResponseEntity<>(responseBody, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception exception, HttpServletRequest request) {
        ExceptionAttributes exceptionAttributes = new DefaultExceptionAttributes();

        Map<String, Object> responseBody = exceptionAttributes.getExceptionAttributes(messageSource.getMessage("generalInternalServerError", null, null), exception, request, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handleHttpMessageNotReadableException(Exception exception, HttpServletRequest request) {
        ExceptionAttributes exceptionAttributes = new DefaultExceptionAttributes();

        Map<String, Object> responseBody = exceptionAttributes.getExceptionAttributes(messageSource.getMessage("generalBadRequest", null, null), exception, request, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }    
    
    @ExceptionHandler(MoreThanOneAccountClientException.class)
    public ResponseEntity<Map<String, Object>> handleMoreThanOneAccountClientException(Exception exception, HttpServletRequest request) {
        ExceptionAttributes exceptionAttributes = new DefaultExceptionAttributes();

        Map<String, Object> responseBody = exceptionAttributes.getExceptionAttributes(exception.getMessage(), exception, request, HttpStatus.UNPROCESSABLE_ENTITY);

        return new ResponseEntity<>(responseBody, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    @ExceptionHandler(MoreThanOneAccountOwnershipException.class)
    public ResponseEntity<Map<String, Object>> handleMoreThanOneAccountOwnershipException(Exception exception, HttpServletRequest request) {
        ExceptionAttributes exceptionAttributes = new DefaultExceptionAttributes();

        Map<String, Object> responseBody = exceptionAttributes.getExceptionAttributes(exception.getMessage(), exception, request, HttpStatus.UNPROCESSABLE_ENTITY);

        return new ResponseEntity<>(responseBody, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    @ExceptionHandler(NoAccountOwnershipException.class)
    public ResponseEntity<Map<String, Object>> handleNoAccountOwnershipException(Exception exception, HttpServletRequest request) {
        ExceptionAttributes exceptionAttributes = new DefaultExceptionAttributes();

        Map<String, Object> responseBody = exceptionAttributes.getExceptionAttributes(exception.getMessage(), exception, request, HttpStatus.UNPROCESSABLE_ENTITY);

        return new ResponseEntity<>(responseBody, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    @ExceptionHandler(NotEmptyCollectionException.class)
    public ResponseEntity<Map<String, Object>> handleNotEmptyCollectionException(Exception exception, HttpServletRequest request) {
        ExceptionAttributes exceptionAttributes = new DefaultExceptionAttributes();

        Map<String, Object> responseBody = exceptionAttributes.getExceptionAttributes(exception.getMessage(), exception, request, HttpStatus.UNPROCESSABLE_ENTITY);

        return new ResponseEntity<>(responseBody, HttpStatus.UNPROCESSABLE_ENTITY);
    }    

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFoundException(Exception exception, HttpServletRequest request) {
        ExceptionAttributes exceptionAttributes = new DefaultExceptionAttributes();

        Map<String, Object> responseBody = exceptionAttributes.getExceptionAttributes(exception.getMessage(), exception, request, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }    
    
    @ExceptionHandler(NotUniqueException.class)
    public ResponseEntity<Map<String, Object>> handleCampoUniqueException(Exception exception, HttpServletRequest request) {
        ExceptionAttributes exceptionAttributes = new DefaultExceptionAttributes();

        Map<String, Object> responseBody = exceptionAttributes.getExceptionAttributes(exception.getMessage(), exception, request, HttpStatus.UNPROCESSABLE_ENTITY);

        return new ResponseEntity<>(responseBody, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(Exception exception, HttpServletRequest request) {
        ExceptionAttributes exceptionAttributes = new DefaultExceptionAttributes();

        Map<String, Object> responseBody = exceptionAttributes.getExceptionAttributes(ValidationUtil.errorsList, exception, request, HttpStatus.UNPROCESSABLE_ENTITY);

        return new ResponseEntity<>(responseBody, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
