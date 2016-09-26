package ulusoy.at.wicket.component;
import java.util.Arrays;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.IModel;


public class ArtikelArtDropDownChoice extends DropDownChoice<String> {

    private static final long serialVersionUID = 1L;

    public ArtikelArtDropDownChoice(final String id, final IModel<String> choiceModel) {
        super(id, choiceModel, Arrays.asList("Bunt","Kilo","Kiste","Sackerl","Stück"));
    }
    public ArtikelArtDropDownChoice(String id)
    {
    	this(id,null);
    }
}
