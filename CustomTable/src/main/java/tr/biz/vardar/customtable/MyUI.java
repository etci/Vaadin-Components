package tr.biz.vardar.customtable;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@Theme("mytheme")
@Widgetset("tr.biz.vardar.customtable.MyAppWidgetset")
public class MyUI extends UI {

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		CustomTable<User> userTable = new CustomTable<User>()
				.filterBarVisible(true)
				.selectable(true)
				.withProperties(new PropertyHolder[] {
						new PropertyHolder("object", User.class, "", null, "get", false),
						new PropertyHolder("username", String.class, "Kullanıcı Adı", "", "getUsername", true),
						new PropertyHolder("name", String.class, "Adı", "", "getName", true),
						new PropertyHolder("surname", String.class, "Soyadı", "", "getSurname", true),
						new PropertyHolder("ssn", String.class, "TC Kimlik No", "", "getSsn", true),
						new PropertyHolder("description", String.class, "Açıklama", "", "getDescription", true)
				});
		userTable.fill(DemoDataGenerator.generate());
		layout.addComponent(userTable);

	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
