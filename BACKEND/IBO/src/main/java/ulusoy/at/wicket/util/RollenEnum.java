package ulusoy.at.wicket.util;

public enum RollenEnum {
	USER(WicketApplicationConstants.ROLE_USER),ADMIN(WicketApplicationConstants.ROLE_ADMIN),LIFERANT(WicketApplicationConstants.ROLE_LIEFERANT),
	LESER(WicketApplicationConstants.ROLE_READONLY),BUCHALTUNG(WicketApplicationConstants.ROLE_BUCHHALTUNG),KUNDE(WicketApplicationConstants.ROLE_KUNDE);

	RollenEnum(String name)
	{
		this.name=name;
	}

	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
