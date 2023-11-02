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
	String[] tags;

	@Column(nullable = false)
	Integer likes = 0;

	@Column(nullable = false)
	Integer dislikes = 0;

	@Column(nullable = false)
	Integer views = 0;

	@Column(nullable = false)
	String userId;

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

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes() {
		this.likes++;
	}

	public Integer getDislikes() {
		return dislikes;
	}

	public void setDislikes() {
		this.dislikes++;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews() {
		this.views++;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
