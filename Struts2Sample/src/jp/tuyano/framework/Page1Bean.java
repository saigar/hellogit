package jp.tuyano.framework;

import com.opensymphony.xwork2.ActionSupport;

public class Page1Bean extends ActionSupport {
	private int field1;
	private String string;
	private String mail;
	private int number;

	public int getField1() {
		return field1;
	}

	public void setField1(int field1) {
		this.field1 = field1;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String execute() throws Exception {
		this.addActionMessage("すべて正常に入力されました。");
		return "page1";
	}
}
