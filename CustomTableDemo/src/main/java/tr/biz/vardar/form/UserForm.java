/**
 *
 */
package tr.biz.vardar.form;

import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.form.AbstractForm;
import org.vaadin.viritin.layouts.MVerticalLayout;

import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;

import tr.biz.vardar.domain.User;

/**
 * @author KUTAY
 *
 */
public class UserForm extends AbstractForm<User> {

	private TextField username = new MTextField("Kullanıcı Adı");
	private TextField name = new MTextField("Adı");
	private TextField surname = new MTextField("Soyadı");
	//	private CheckBox admin = new CheckBox("Admin");
	//	private TypedSelect<Address> address = new TypedSelect<Address>(Address.class);

	/* (non-Javadoc)
	 * @see org.vaadin.viritin.form.AbstractForm#createContent()
	 */
	@Override
	protected Component createContent() {
		return new MVerticalLayout(username, name, surname, getToolbar());
	}

}
