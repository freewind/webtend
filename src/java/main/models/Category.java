package models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import webtend.db.ebean.Model;

@Entity
@Table(name = "categories")
public class Category extends BaseModel {

	@Column(columnDefinition = "TEXT")
	private String alias;

	@Column(columnDefinition = "TEXT")
	private String name;

	@Column(name = "display_order")
	private long order = System.currentTimeMillis();

	private boolean show = true;

	@OneToMany(mappedBy = "category")
	private List<Article> articles;

	public static final Finder<String, Category> find = new Model.Finder(String.class, Category.class);

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getOrder() {
		return order;
	}

	public void setOrder(long order) {
		this.order = order;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
