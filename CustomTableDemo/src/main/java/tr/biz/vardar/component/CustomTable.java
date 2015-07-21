
package tr.biz.vardar.component;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.tepi.filtertable.FilterTable;

import com.vaadin.data.Item;

/**
 * The intention of this table is to use persistent objects as container items.
 * It also shortens the operations of default Vaadin table
 * @author KUTAY
 */
@SuppressWarnings("serial")
public class CustomTable<T> extends FilterTable {

	private PropertyHolder[] properties;
	private final Class<T> type;

	public CustomTable(Class<T> type) {
		super();
		this.type = type;
	}

	public void updateRow(T t) throws UnsupportedOperationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Object id = t.getClass().getMethod("getId").invoke(t, null);
		Item item = null;
		if(id == null || getItem(id) == null) {
			item = addItem(id);
		}
		else {
			item = getItem(id);
		}
		System.out.println("Id: " + id);
		System.out.println("item: " + item);
		setItemPropertyValues(item, t, properties);
	}

	/**
	 * @param PropertyHolder[]
	 * @return
	 */
	public CustomTable<T> withProperties(PropertyHolder[] properties) {
		this.properties = properties;
		if(properties != null && properties.length > 0) {
			List<Object> visibleProperties = new ArrayList<Object>();
			for(PropertyHolder propertyHolder : properties) {
				addContainerProperty(propertyHolder.getPropertyId(), propertyHolder.getType(), propertyHolder.getDefaultValue());
				setColumnHeader(propertyHolder.getPropertyId(), propertyHolder.getCaption());
				if(propertyHolder.isVisible()) {
					visibleProperties.add(propertyHolder.getPropertyId());
				}
			}
			setVisibleColumns(visibleProperties.toArray());
		}
		return this;
	}

	public CustomTable<T> filterBarVisible(boolean flag) {
		setFilterBarVisible(flag);
		return this;
	}

	public CustomTable<T> selectable(boolean flag) {
		setSelectable(flag);
		return this;
	}

	public void fill(Collection<T> collection) {
		if(collection != null && collection.size() > 0 && properties != null) {
			removeAllItems();
			for(T t : collection) {
				try {
					Item item = addItem(t.getClass().getMethod("getId").invoke(t, null));
					setItemPropertyValues(item, t, properties);
				} catch (UnsupportedOperationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
			}
			if(isFilterBarVisible()) {
				resetFilters();
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void setItemPropertyValues(Item item, T t, PropertyHolder[] properties) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		for(PropertyHolder propertyHolder : properties) {
			Object value = decodeGetters(t, propertyHolder.getGetterMethod());
			item.getItemProperty(propertyHolder.getPropertyId()).setValue(value != null ? value : propertyHolder.getDefaultValue());
			//						t.getClass().getMethod(propertyHolder.getGetterMethod()).invoke(t, null)
		}
	}
	private Object decodeGetters(T entity, String methodName) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if(methodName.contains(".")) {
			String tempMethodName = methodName.substring(0, methodName.indexOf("."));
			methodName = methodName.substring(methodName.indexOf(".") + 1);
			Object object = entity.getClass().getMethod(tempMethodName).invoke(entity, null);
			return decodeInnerGetters(object, methodName);
		}
		return entity.getClass().getMethod(methodName).invoke(entity, null);
	}

	private Object decodeInnerGetters(Object object, String methodName) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String tempMethodName = null;
		System.out.println("Method name: " + methodName);
		if(object == null)
			return object;
		while(methodName.contains(".")) {
			tempMethodName = methodName.substring(0, methodName.indexOf("."));
			System.out.println("Temp method name: " + tempMethodName);
			object = object.getClass().getMethod(tempMethodName).invoke(object, null);
			if(object == null)
				return object;
			methodName = methodName.substring(methodName.indexOf(".") + 1);
		}
		return object.getClass().getMethod(methodName).invoke(object, null);
	}

	@SuppressWarnings("unchecked")
	public T getSelectedEntity() {
		T t = null;
		Object id = getValue();
		if(id != null) {
			PropertyHolder mainEntityHolder = getMainEntityHolder();
			if(mainEntityHolder != null) {
				Item item = getItem(id);
				t = (T) item.getItemProperty(mainEntityHolder.getPropertyId()).getValue();
			}
		}
		return t;
	}

	private PropertyHolder getMainEntityHolder() {
		for(PropertyHolder holder : properties) {
			if(holder.getType().equals(type))
				return holder;
		}
		return null;
	}
}
