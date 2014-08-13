package jp.tuyano.framework.action;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Results({
	@Result(location="/page1.jsp"),
	@Result(name="input",location="/page1.jsp"),
})
public class Page1Action extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String field1;
		public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}

	@Validations(
		requiredStrings = {
			@RequiredStringValidator(type = ValidatorType.SIMPLE,
				fieldName = "field1",
				message = "入力してください。")
		},
		stringLengthFields = {
			@StringLengthFieldValidator(type = ValidatorType.SIMPLE,
				trim = true, minLength="3" ,
				maxLength = "10",
				fieldName = "field1",
				message = "3文字以上10文字以内で入力ください。")
		}
	)

	public String execute() throws Exception {
		this.addActionMessage("入力された値：" + this.getField1());
		return SUCCESS;
	}

	public String secondAction() throws Exception {
		this.addActionMessage("2番目のアクションが実行されました。");
		return SUCCESS;
	}
}