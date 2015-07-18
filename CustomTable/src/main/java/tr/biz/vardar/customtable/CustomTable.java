
package tr.biz.vardar.customtable;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.tepi.filtertable.FilterTable;

import com.vaadin.data.Item;

/**
 * @author KUTAY
 */
@SuppressWarnings("serial")
public class CustomTable<T> extends FilterTable {

	private PropertyHolder[] properties;

	public CustomTable() {
		super();
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
			for(T t : collection) {
				try {
					Item item = addItem(t.getClass().getMethod("getId").invoke(t, null));
					for(PropertyHolder propertyHolder : properties) {
						item.getItemProperty(propertyHolder.getPropertyId()).setValue(t.getClass().getMethod(propertyHolder.getGetterMethod()).invoke(t, null));
					}
				} catch (UnsupportedOperationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
