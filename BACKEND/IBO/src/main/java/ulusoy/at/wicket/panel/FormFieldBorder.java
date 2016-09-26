package ulusoy.at.wicket.panel;


import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.model.IModel;

public class FormFieldBorder extends Border {

    private static final long serialVersionUID = 1L;

    public FormFieldBorder(final String id, final IModel<String> labelModel) {
        super(id);
        final WebMarkupContainer borderContainer = new WebMarkupContainer("borderContainer");
        borderContainer.add(new Label("label", labelModel));
       
       
        addToBorder(borderContainer);
    }

    public boolean isRequired() {
        return false;
    }

    public boolean isInfoVisible() {
        return false;
    }
}
