package redditFinal;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class PasswordValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {

        String password = (String) value;

        UIInput confirmComponent = (UIInput) component.getAttributes().get("confirm");
        String confirm = (String) confirmComponent.getSubmittedValue();

        if (password == null || password.isEmpty() || confirm == null || confirm.isEmpty()) {
            return; // Let required="true" do its job.
        }

        if (!password.equals(confirm)) {
            confirmComponent.setValid(false);
            System.out.println("PasswordValidator");
     
            //throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "password not equal"));
//            context.addMessage(null, new FacesMessage("Passwords are not equal."));
//            context.validationFailed();
//            ((UIInput) component).setValid(false);
//            confirmComponent.setValid(false);
//            return;
            throw new ValidatorException(new FacesMessage("Passwords are not equal."));
        }

	}

}