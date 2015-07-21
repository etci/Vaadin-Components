/**
 *
 */
package tr.biz.vardar.component;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.vaadin.viritin.form.AbstractForm;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

import tr.biz.vardar.service.Service;

/**
 * @author KUTAY
 *
 */
public abstract class CrudComponent<T> extends VerticalLayout {

	private Button createButton;
	private Button editButton;
	private Button deleteButton;

	private CustomTable<T> table;
	private Service<T> service;
	private Class<T> type;
	private AbstractForm<T> form;

	public CrudComponent(Class<T> type, Service<T> service) {
		this.type = type;
		this.service = service;
		setMargin(true);
		setSpacing(true);
		addComponent(createButtons());
		setModifyingButtonsEnabled(false);
	}

	/**
	 * This method is used to set an externally initialized
	 * {@link CustomTable} as the component's table
	 * @param table
	 * @return
	 */
	public CrudComponent<T> withTable(CustomTable<T> table) {
		this.table = table;
		addComponent(table);
		table.addValueChangeListener(e -> setModifyingButtonsEnabled(e.getProperty().getValue() != null));
		return this;
	}
	/**
	 * The method is used to create table with the provided properties
	 *  An externally initialized table can also be used by calling
	 *	{@link #withTable(CustomTable)} method
	 * @param properties
	 */
	public void initTable(PropertyHolder[] properties) {
		table = new CustomTable<T>(type).filterBarVisible(true).selectable(true).withProperties(properties);
		table.addValueChangeListener(e ->setModifyingButtonsEnabled(e.getProperty().getValue() != null));
		addComponent(table);
	}

	private HorizontalLayout createButtons() {
		createButton = new Button("Create");
		editButton = new Button("Edit");
		deleteButton = new Button("Delete");
		HorizontalLayout buttonLayout = new HorizontalLayout(createButton, editButton, deleteButton);
		buttonLayout.setMargin(true);
		buttonLayout.setSpacing(true);

		createButton.addClickListener(e -> createClicked());
		editButton.addClickListener(e -> editClicked());
		deleteButton.addClickListener(e -> deleteClicked());

		return buttonLayout;
	}

	abstract public AbstractForm<T> generateForm();

	public void setCreateButtonVisible(boolean visible) {
		createButton.setVisible(visible);
	}

	public void setEditButtonVisible(boolean visible) {
		editButton.setVisible(visible);
	}

	public void setDeleteButtonVisible(boolean visible) {
		deleteButton.setVisible(visible);
	}

	public void setCreateButtonEnabled(boolean enabled) {
		createButton.setEnabled(enabled);
	}

	public void setEditButtonEnabled(boolean enabled) {
		editButton.setEnabled(enabled);
	}

	public void setDeleteButtonEnabled(boolean enabled) {
		deleteButton.setEnabled(enabled);
	}

	public void setCreateButtonCaption(String caption) {
		createButton.setCaption(caption);
	}

	public void setEditButtonCaption(String caption) {
		editButton.setCaption(caption);
	}

	public void setDeleteButtonCaption(String caption) {
		deleteButton.setCaption(caption);
	}

	public void fillTable(Collection<T> collection) {
		table.fill(collection);
	}

	private void onSave(T t) {
		service.save(t);
		form.getPopup().close();
		try {
			table.updateRow(t);
		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void onEdit(T t) {
		service.edit(t);
		form.getPopup().close();
		try {
			table.updateRow(t);
		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createClicked() {
		form = generateForm();
		System.out.println(service);
		T t = service.newInstance();
		System.out.println(t);
		form.setEntity(service.newInstance());
		form.setSavedHandler(CrudComponent.this :: onSave);
		form.openInModalPopup();
	}

	private void editClicked() {
		T entity = table.getSelectedEntity();
		System.out.println(entity == null ? "entity null" : "entity null değil");
		System.out.println(entity.getClass().getSimpleName());
		form = generateForm();
		form.setEntity(entity);
		form.setSavedHandler(CrudComponent.this :: onEdit);
		form.openInModalPopup();
	}

	private void deleteClicked() {
		T entity = table.getSelectedEntity();
		if(entity != null) {
			System.out.println("Delete clicked");
			service.delete(table.getSelectedEntity());
		}
	}

	private void setModifyingButtonsEnabled(boolean enabled) {
		setEditButtonEnabled(enabled);
		setDeleteButtonEnabled(enabled);
	}
}
