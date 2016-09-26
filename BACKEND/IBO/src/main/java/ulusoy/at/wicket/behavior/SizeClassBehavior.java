package ulusoy.at.wicket.behavior;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class SizeClassBehavior extends AttributeModifier {

	private static final long serialVersionUID = 1L;

    public SizeClassBehavior(final IModel<Integer> sizeModel) {
        super("class", new Model<String>() {
            private static final long serialVersionUID = 1L;

            @Override
            public String getObject() {
                return "input_" + Integer.toString(sizeModel.getObject());
            }
        });
    }
}
