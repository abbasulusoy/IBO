package ulusoy.at.wicket.panel;


import javax.validation.ConstraintViolationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.feedback.ContainerFeedbackMessageFilter;
import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.model.StringResourceModel;

import ulusoy.at.wicket.behavior.SizeClassBehavior;


public class FormPanel<T> extends Panel {

    private static final long serialVersionUID = 1L;

    private final WebMarkupContainer fieldsContainer;
    private final Form<T> form;
    private static final Log LOGGER = LogFactory.getLog(FormPanel.class);

    public FormPanel(final String id, final IModel<T> model, final IModel<String> submitButtonValueModel) {
        this(id, model, submitButtonValueModel, new ResourceModel("cancel"));
    }

    public FormPanel(final String id,
            final IModel<T> model,
            final IModel<String> submitButtonValueModel,
            final IModel<String> cancelButtonValueModel) {
        super(id);
        this.form = new Form<T>("form", new CompoundPropertyModel<>(model));
        super.add(this.form);

        this.form.add(new FeedbackPanel("feedback", createNewFeedbackMessageFilter()) {

            private static final long serialVersionUID = 1L;

            @Override
            public boolean isVisible() {
                return feedbackIsVisible();
            }
        });

        final Button submitButton = new Button("submitButton", submitButtonValueModel) {
            private static final long serialVersionUID = 1L;

            @Override
            public void onSubmit() {
                try {
                    FormPanel.this.onSubmit(FormPanel.this.form.getModel());
                } catch (final Exception e) {
                        LOGGER.error("FormPanel = Message" +e.getMessage());
                }
            }

            @Override
            public boolean isVisible() {
                return submitIsVisible();
            }
        };
        this.form.add(submitButton);
        this.fieldsContainer = new WebMarkupContainer("fieldsContainer");
        this.form.add(this.fieldsContainer);

        final Button cancelButton = new Button("cancelButton", cancelButtonValueModel) {
            private static final long serialVersionUID = 1L;

            @Override
            public void onSubmit() {
                onCancel();
            }

            @Override
            public boolean isVisible() {
                return cancelIsVisible();
            }
        };
        cancelButton.setDefaultFormProcessing(false);
        this.form.add(cancelButton);
    }

    protected IFeedbackMessageFilter createNewFeedbackMessageFilter() {
        return new ContainerFeedbackMessageFilter(this);
    }

    protected IModel<T> getModel() {
        return this.form.getModel();
    }

    @Override
    public MarkupContainer add(final Component... childs) {
        return this.fieldsContainer.add(childs);
    }

    public final void addWithFormBorder(final String borderId, final String labelKey, final Component component) {
        addWithFormBorder(borderId, labelKey, component, null);
    }

    public final void addWithFormBorder(final String borderId,
            final String labelKey,
            final Component component,
            final Integer inputSize) {
        if (inputSize != null) {
            component.add(new SizeClassBehavior(Model.of(inputSize)));
        }
        add(new FormFieldBorder(borderId, new StringResourceModel(labelKey, this, null)).add(component));
    }

    public void onSubmit(final IModel<T> model) throws ConstraintViolationException {

    }

    public void onCancel() {
    }

    public boolean submitIsVisible() {
        return true;
    }

    public boolean feedbackIsVisible() {
        return true;
    }

    public boolean cancelIsVisible() {
        return true;
    }

}
