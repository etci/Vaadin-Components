package tr.biz.vardar;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.form.AbstractForm;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import tr.biz.vardar.component.CrudComponent;
import tr.biz.vardar.component.CustomTable;
import tr.biz.vardar.component.PropertyHolder;
import tr.biz.vardar.domain.User;
import tr.biz.vardar.form.UserForm;
import tr.biz.vardar.service.UserService;
import tr.biz.vardar.util.DemoDataGenerator;

@Theme("valo")
@Title("Custom Table")
@Widgetset("tr.biz.vardar.CustomTableWidgetSet")
@SpringUI(path="customTable")
@PreserveOnRefresh
public class CustomTableUI extends UI {

	@Autowired
	private UserService userService;

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		CustomTable<User> userTable = new CustomTable<User>(User.class)
				.filterBarVisible(true)
				.selectable(true)
				.withProperties(new PropertyHolder[] {
						new PropertyHolder("user", User.class, "", null, "get", false),
						new PropertyHolder("postcode", String.class, "Posta Kodu", null, "getAddress.getPostCode", true),
						new PropertyHolder("apartmentNo", String.class, "Apartman No", null, "getAddress.getApartment.getApartmentNo", true),
						new PropertyHolder("apartmentName", String.class, "Apartman Adı", null, "getAddress.getApartment.getApartmentName", true),
						new PropertyHolder("username", String.class, "Kullanıcı Adı", null, "getUsername", true),
						new PropertyHolder("name", String.class, "Adı", "", "getName", true),
						new PropertyHolder("surname", String.class, "Soyadı", "", "getSurname", true),
						new PropertyHolder("ssn", String.class, "TC Kimlik No", "", "getSsn", true),
						new PropertyHolder("description", String.class, "Açıklama", "", "getDescription", true)
				});
		userTable.fill(DemoDataGenerator.generate());
		layout.addComponent(userTable);

		CrudComponent<User> crudComponent = new CrudComponent<User>(User.class, userService) {

			@Override
			public AbstractForm<User> generateForm() {
				return new UserForm();
			}
		}.withTable(userTable);
		layout.addComponent(crudComponent);
	}

}
