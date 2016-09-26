package ulusoy.at.wicket.entity.model;

import org.apache.wicket.model.LoadableDetachableModel;

import ulusoy.at.wicket.WicketApplicationWebSession;

public class AccountLoginFullName extends LoadableDetachableModel<String>{

	private static final long serialVersionUID = 1L;

	@Override
	protected String load() {
		if(WicketApplicationWebSession.get().getUserDetails() !=null)
		{
			return 	WicketApplicationWebSession.get().getUserDetails().getName();
		}
		else
		{
			return "";
		}
	}
}
