package ulusoy.at.wicket.table;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

import ulusoy.at.wicket.validation.ConstraintValidationMessage;



public class FeedbackColumn<T> extends AbstractColumn<T, String> {

    private static final long serialVersionUID = 1L;

    public FeedbackColumn() {
        super(null);
    }

    @Override
    public void populateItem(final Item<ICellPopulator<T>> cellItem, final String componentId, final IModel<T> rowModel) {
        cellItem.add(new Feedback(componentId, rowModel));
    }

    private class Feedback extends Panel {

        private static final long serialVersionUID = 1L;

        public Feedback(final String id, final IModel<T> rowModel) {
            super(id);
            final WebMarkupContainer link = new WebMarkupContainer("link");
            link.setOutputMarkupId(true);
            add(link);
            link.add(new FeedbackPanel("feedback", new IFeedbackMessageFilter() {

                private static final long serialVersionUID = 1L;

                @Override
                public boolean accept(final FeedbackMessage message) {
                    if (!(message.getMessage() instanceof ConstraintValidationMessage)) {
                        return false;
                    }
                    final ConstraintValidationMessage cvMessage = (ConstraintValidationMessage) message.getMessage();
                    if (cvMessage.isSameEntity(rowModel.getObject())) {
                        message.markRendered();
                        return true;
                    }
                    return false;
                }
            }));
        }
    }

}
