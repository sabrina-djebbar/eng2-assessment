package york.eng2.video.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.micronaut.serde.annotation.Serdeable;

@Entity
@Serdeable
public class Video {

	@Id
	@GeneratedValue
	Long id;

	@Column(nullable = false)
	String title;

	@Column(nullable = false)
	String tag;

	@Column(nullable = false)
	Integer likes;

	@Column(nullable = false)
	Integer dislikes;

	@Column(nullable = false)
	Integer views;

	@Column(nullable = false)
	Integer userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes() {
		likes++;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Integer getDislikes() {
		return dislikes;
	}

	public void setDislikes() {
		dislikes++;
	}

	public void setDislikes(Integer dislikes) {
		this.dislikes = dislikes;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews() {
		views++;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
