package tr.biz.vardar.vaadin.ui;

import tr.biz.vardar.vaadin.model.User;
import tr.biz.vardar.vaadin.service.UserService;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;

public class CustomTable extends Table {

	private BeanItemContainer<User> container;

	public CustomTable() {
		setWidth("100%");
		setHeight("100%");
		initContainer();
		fillTable();
	}

	private void initContainer() {
		container = new BeanItemContainer<User>(User.class);
		setContainerDataSource(container);
	}

	public void fillTable() {
		container.removeAllItems();
		container.addAll(UserService.getUserList());
	}

}
