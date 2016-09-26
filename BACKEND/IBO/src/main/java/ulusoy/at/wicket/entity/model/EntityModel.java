package ulusoy.at.wicket.entity.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import ulusoy.at.wicket.entity.Base;

public abstract class EntityModel<T extends Base> extends LoadableDetachableModel<T>  {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private final IModel<Long> idModel;

	public EntityModel(final T entity)
	{
		super(entity);
		this.idModel=Model.of(entity.getId());
		 Injector.get().inject(this);

	}
	public EntityModel(final Long id)
	{
		this.idModel=Model.of(id);
		Injector.get().inject(this);
	}

	public EntityModel(final IModel<Long> entityModel)
	{
		this.idModel=entityModel;
		Injector.get().inject(this);
	}
	@Override
	protected T load() {
		if(this.idModel==null &&this.idModel.getObject()==null)
		{
			return null;
		}
		else
		{
			return getRepository().findOne(idModel.getObject());
		}
	}
	@Override
	public void detach() {
		this.idModel.detach();
		super.detach();
	}
	protected abstract  JpaRepository<T,Long> getRepository();



}
