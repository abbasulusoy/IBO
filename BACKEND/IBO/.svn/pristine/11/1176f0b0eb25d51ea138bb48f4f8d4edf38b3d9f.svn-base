package ulusoy.at.wicket.table;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

public class PanelColumn<T, S> extends AbstractColumn<T, S> {

    private static final long serialVersionUID = 1L;

    public PanelColumn(final IModel<String> displayModel) {
        super(displayModel);
    }

    @Override
    public void populateItem(final Item<ICellPopulator<T>> cellItem, final String componentId, final IModel<T> rowModel) {
        cellItem.add(getComponent(componentId, rowModel));
    }

    public Component getComponent(final String componentId, final IModel<T> rowModel) {
        return new EmptyPanel(componentId);
    }

}
