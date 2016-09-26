package ulusoy.at.wicket.table;


import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public abstract class AbstractColumnActionsPanel<T> extends Panel {

    private static final long serialVersionUID = 1L;

    private final IModel<T> rowModel;

    public AbstractColumnActionsPanel(final String id, final IModel<T> rowModel) {
        super(id);
        this.rowModel = rowModel;
    }

    protected IModel<T> getRowModel() {
        return this.rowModel;
    }

    @Override
    protected void onDetach() {
        if (this.rowModel != null) {
            this.rowModel.detach();
        }
        super.onDetach();
    }

}
