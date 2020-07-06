package br.com.tokenlab.challenge.validator;

import br.com.tokenlab.challenge.dto.EventDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public abstract class EventValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return EventDTO.class.isAssignableFrom(clazz);
    }

    protected abstract boolean hasInvalidFields(EventDTO eventDTO);

    protected abstract String getInvalidFieldName();

    protected abstract String getErrorMessage();

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.getErrorCount() == 0) {
            EventDTO eventDTO = (EventDTO) target;

            if (hasInvalidFields(eventDTO)) {
                errors.rejectValue(getInvalidFieldName(), null, getErrorMessage());
            }
        }
    }
}
