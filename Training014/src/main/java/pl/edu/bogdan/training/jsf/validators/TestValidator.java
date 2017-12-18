package pl.edu.bogdan.training.jsf.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("pl.edu.bogdan.training.jsf.validators.TestValidator")
public class TestValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		FacesMessage msg = new FacesMessage("ERROR");
		throw new ValidatorException(msg);
		
	}

}
