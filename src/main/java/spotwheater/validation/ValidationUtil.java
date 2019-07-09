package spotwheater.validation;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import spotwheater.exception.ValidationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidationUtil {

    public static List<String> errorsList;

    public static List handleValidationErrors(BindingResult bindingResult) throws ValidationException {
        errorsList = new ArrayList();

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        for (FieldError error: fieldErrors) {
            errorsList.add(error.getDefaultMessage());
        }

        Collections.sort(errorsList);

        throw new ValidationException();
    }

    public static void handleValidationErrors(List<FieldError> fieldErrors) throws ValidationException {
        errorsList = new ArrayList();

        for (FieldError error: fieldErrors) {
            errorsList.add(error.getDefaultMessage());
        }

        Collections.sort(errorsList);

        throw new ValidationException();
    }
}
