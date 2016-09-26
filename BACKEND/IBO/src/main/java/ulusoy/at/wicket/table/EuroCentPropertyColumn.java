package ulusoy.at.wicket.table;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;



public class EuroCentPropertyColumn<T> extends AbstractColumn<T, String> {

    private static final long serialVersionUID = 1L;

    private final String property;

    public EuroCentPropertyColumn(final String property) {
        super(null);
        this.property = property;
    }

    @Override
    public void populateItem(final Item<ICellPopulator<T>> cellItem, final String componentId, final IModel<T> rowModel) {
        cellItem.add(new EuroCentLabel(componentId, new PropertyModel<Long>(rowModel, this.property)));
    }

}
