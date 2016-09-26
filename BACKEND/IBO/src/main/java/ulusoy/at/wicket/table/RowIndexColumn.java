package ulusoy.at.wicket.table;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class RowIndexColumn<T> extends AbstractColumn<T, String> {

    private static final long serialVersionUID = 1L;

    public RowIndexColumn() {
        super(null);
    }

    @Override
    public void populateItem(final Item<ICellPopulator<T>> cellItem, final String componentId, final IModel<T> rowModel) {
        final int rowIndex = ((Item<?>) cellItem.getParent().getParent()).getIndex();
        cellItem.add(new Label(componentId, Model.of(rowIndex + 1)));
    }
}
