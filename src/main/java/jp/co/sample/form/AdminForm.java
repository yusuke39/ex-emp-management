package jp.co.sample.form;

public class AdminForm {

	private String name;
	private String mailAddress;
	private String password;

	public AdminForm(String name, String mailAddress, String password) {
		super();
		this.name = name;
		this.mailAddress = mailAddress;
		this.password = password;
	}

	public AdminForm() {}

	@Override
	public String toString() {
		return "AdminForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
