package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import webtend.db.ebean.Model;

@Entity
@Table(name = "configs")
public class Config extends BaseModel {

	@Column(columnDefinition = "TEXT")
	private String code;

	@Column(columnDefinition = "TEXT")
	private String value;

	public static final Finder<String, Config> find = new Model.Finder(String.class, Config.class);

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
