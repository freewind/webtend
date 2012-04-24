package models;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import webtend.db.ebean.Model;

@Entity
@Table(name = "articles")
public class Article extends BaseModel {

	@Column(columnDefinition = "TEXT")
	private String alias;

	@Column(columnDefinition = "TEXT")
	private String title;

	@ManyToOne
	private Category category;

	private boolean index = false;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();

	@OneToMany(mappedBy = "article")
	private List<Paragraph> paragraphs;

	public static final Finder<String, Article> find = new Model.Finder(String.class, Article.class);

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isIndex() {
		return index;
	}

	public void setIndex(boolean index) {
		this.index = index;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Paragraph> getParagraphs() {
		return paragraphs;
	}

	public void setParagraphs(List<Paragraph> paragraphs) {
		this.paragraphs = paragraphs;
	}

}
