package ulusoy.at.wicket.table;



import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.convert.IConverter;
import ulusoy.at.wicket.validation.CentsToCurrencyConverter;


public class EuroCentLabel extends Label {

    private static final long serialVersionUID = 1L;

    public EuroCentLabel(final String id, final IModel<Long> model) {
        super(id, model);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <C> IConverter<C> getConverter(final Class<C> type) {
        if (type.equals(Long.class)) {
            return (IConverter<C>) new CentsToCurrencyConverter();
        }
        return super.getConverter(type);
    }

}
