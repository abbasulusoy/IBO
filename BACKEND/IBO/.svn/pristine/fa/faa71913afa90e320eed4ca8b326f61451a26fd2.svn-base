package ulusoy.at.wicket.validation;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

public class MaximumStringLengthValidator implements IValidator<String>{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final int max;

	public MaximumStringLengthValidator (int max)
	{
		this.max=max;
	}
	@Override
	public void validate(IValidatable<String> validatable) {
		if(validatable.getValue().length()>max)
		{
			ValidationError error=new ValidationError();
			error.addKey(getClass().getSimpleName() +"."+"max.plz");
			error.setVariable("max", max);
			validatable.error(error);
		}

	}


}
