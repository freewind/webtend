package models;

import java.util.UUID;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import webtend.db.ebean.Model;

@MappedSuperclass
public abstract class BaseModel extends Model {

	@Id
	protected String id;

	@PrePersist
	void setUUID() {
		if (id == null) {
			id = UUID.randomUUID().toString().replace("-", "");
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
