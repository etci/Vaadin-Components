package tr.biz.vardar;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import tr.biz.vardar.vaadin.service.UserService;
import tr.biz.vardar.vaadin.ui.FilterCustomTable;

@Title("Demo")
@Theme("valo")
@Widgetset("tr.biz.vardar.VaadinWidgetSet")
@SpringUI(path="demo")
public class VaadinUI extends UI {


	@Override
	protected void init(VaadinRequest request) {
		UserService.createDemoService();
		//    	setContent(new CustomTable());
		VerticalLayout layout = new VerticalLayout();
		Button deleteButton = new Button("Delete");
		final FilterCustomTable customTable = new FilterCustomTable();
		layout.addComponent(deleteButton);
		layout.addComponent(customTable);
		deleteButton.addClickListener(event -> customTable.deleteSelectedItem());
		setContent(layout);
	}

	/*  Deployed as a Servlet or Portlet.
	 *
	 *  You can specify additional servlet parameters like the URI and UI
	 *  class name and turn on production mode when you have finished developing the application.
	 */



}
