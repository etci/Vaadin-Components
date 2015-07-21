package tr.biz.vardar.vaadin.ui;

import org.tepi.filtertable.FilterTable;

import com.vaadin.data.util.BeanItemContainer;

import tr.biz.vardar.vaadin.model.User;
import tr.biz.vardar.vaadin.service.UserService;

public class FilterCustomTable extends FilterTable {

	private BeanItemContainer<User> container;

	public FilterCustomTable() {
		setWidth("100%");
		setHeight("100%");
		setFilterBarVisible(true);
		setSelectable(true);
		initContainer();
		fillTable();
		addValueChangeListener(event -> {
		});
	}

	private void initContainer() {
		container = new BeanItemContainer<User>(User.class);
		setContainerDataSource(container);
	}

	public void fillTable() {
		container.removeAllItems();
		container.addAll(UserService.getUserList());
		resetFilters();
	}

	public void deleteSelectedItem() {
		removeItem(getSelectedUser());
	}

	public User getSelectedUser() {
		return (User) getValue();
	}


}
