/**
 *
 */
package tr.biz.vardar.component;

/**
 * @author KUTAY
 *
 */
public class PropertyHolder {

	private Object propertyId;
	private Class<?> type;
	private String caption;
	private Object defaultValue;
	private String getterMethod;
	private boolean visible;


	/**
	 * @param propertyId
	 * @param type
	 * @param caption
	 * @param defaultValue
	 * @param getterMethod
	 * @param visible
	 */
	public PropertyHolder(Object propertyId, Class<?> type, String caption,
			Object defaultValue, String getterMethod, boolean visible) {
		super();
		this.propertyId = propertyId;
		this.type = type;
		this.caption = caption;
		this.defaultValue = defaultValue;
		this.getterMethod = getterMethod;
		this.visible = visible;
	}

	/**
	 * @param propertyId
	 * @param type
	 * @param caption
	 * @param defaultValue
	 */
	public PropertyHolder(Object propertyId, Class<?> type, String caption,
			Object defaultValue) {
		super();
		this.propertyId = propertyId;
		this.type = type;
		this.caption = caption;
		this.defaultValue = defaultValue;
	}

	/**
	 * @param propertyId
	 * @param type
	 * @param caption
	 * @param defaultValue
	 * @param getterMethod
	 */
	public PropertyHolder(Object propertyId, Class<?> type, String caption,
			Object defaultValue, String getterMethod) {
		super();
		this.propertyId = propertyId;
		this.type = type;
		this.caption = caption;
		this.defaultValue = defaultValue;
		this.getterMethod = getterMethod;
	}



	public Object getPropertyId() {
		return propertyId;
	}

	public Class<?> getType() {
		return type;
	}

	public String getCaption() {
		return caption;
	}

	public Object getDefaultValue() {
		return defaultValue;
	}

	public String getGetterMethod() {
		return getterMethod;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setPropertyId(Object propertyId) {
		this.propertyId = propertyId;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
	}

	public void setGetterMethod(String getterMethod) {
		this.getterMethod = getterMethod;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
