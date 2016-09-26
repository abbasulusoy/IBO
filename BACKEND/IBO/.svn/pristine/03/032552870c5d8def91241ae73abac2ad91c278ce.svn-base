package ulusoy.at.wicket.pages.bestellung;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;




public abstract class AbtractArtikelListActionColumnPanel<T> extends Panel {

    private static final long serialVersionUID = 1L;

    private final IModel<T> rowModel;

    public AbtractArtikelListActionColumnPanel(final String id, final IModel<T> selectedModel) {
        super(id);
        this.rowModel = selectedModel;
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
