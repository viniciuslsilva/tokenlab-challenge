package br.com.tokenlab.challenge.validator;

import br.com.tokenlab.challenge.dto.EventDTO;

public class EventDateValidator extends EventValidator {

    @Override
    protected boolean hasInvalidFields(EventDTO eventDTO) {
        return eventDTO.getDateStart().isAfter(eventDTO.getDateEnd());
    }

    @Override
    protected String getInvalidFieldName() {
        return "dateStart";
    }

    @Override
    protected String getErrorMessage() {
        return "The event date start should be before of end date";
    }
}
