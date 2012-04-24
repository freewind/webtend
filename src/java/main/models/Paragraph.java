package models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import webtend.db.ebean.Model;

@Entity
@Table(name = "paragraphs")
public class Paragraph extends BaseModel {

	@Column(columnDefinition = "TEXT")
	private String content;

	@ManyToOne
	private Article article;

	@Column(name = "display_order")
	private long order = System.currentTimeMillis();

	@OneToOne(mappedBy = "paragraph")
	private Note note;

	@OneToMany(mappedBy = "paragraph")
	private List<Comment> comments;

	public static Finder<String, Paragraph> find = new Model.Finder(String.class, Paragraph.class);

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public long getOrder() {
		return order;
	}

	public void setOrder(long order) {
		this.order = order;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
