package ulusoy.at.wicket.component;
import java.util.Arrays;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.PropertyModel;


public class RolleDropDownChoice extends DropDownChoice<String> {

    private static final long serialVersionUID = 1L;

    public RolleDropDownChoice(final String id, final PropertyModel<Object> propertyModel) {
        super(id, Arrays.asList("USER","ADMIN","KUNDE","LIFERANT","BUCHALTER","LESER"));
    }
    public RolleDropDownChoice(String id)
    {
    	this(id,null);
    }
}
