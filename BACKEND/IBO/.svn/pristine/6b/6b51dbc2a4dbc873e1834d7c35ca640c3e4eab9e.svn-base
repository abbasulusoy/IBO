package ulusoy.at.wicket.validation;



import java.io.Serializable;

import javax.validation.Path;

import ulusoy.at.wicket.entity.Base;



public class ConstraintValidationMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    private String message;
    private Path propertyPath;
    private Class<?> offendingEntityClass;
    private Long offendingEntityId;

    public ConstraintValidationMessage(final String message,
            final Path propertyPath,
            final Base offendingEntity) {
        super();
        this.message = message;
        if (offendingEntity != null) {
            this.offendingEntityClass = offendingEntity.getClass();
            this.offendingEntityId = offendingEntity.getId();
        }
        this.propertyPath = propertyPath;
    }

    public ConstraintValidationMessage(final String message, final Base offendingEntity) {
        this(message, null, offendingEntity);
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

    public Path getPropertyPath() {
        return this.propertyPath;
    }

    public void setPropertyPath(final Path propertyPath) {
        this.propertyPath = propertyPath;
    }

    public Class<?> getOffendingEntityClass() {
        return this.offendingEntityClass;
    }

    public void setOffendingEntityClass(final Class<?> offendingEntityClass) {
        this.offendingEntityClass = offendingEntityClass;
    }



    public Long getOffendingEntityId() {
		return offendingEntityId;
	}

	public void setOffendingEntityId(Long offendingEntityId) {
		this.offendingEntityId = offendingEntityId;
	}

	public boolean isSameEntity(final Object entity) {
        if (entity == null) {
            return false;
        }
        if (!Base.class.isAssignableFrom(entity.getClass())) {
            return false;
        }
        if (!entity.getClass().equals(getOffendingEntityClass())) {
            return false;
        }
        final Long id = ((Base) entity).getId();
        if (id == null) {
            return false;
        }
        if (!getOffendingEntityId().equals(id)) {
            return false;
        }
        return true;
    }
}
