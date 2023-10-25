package york.eng2.video.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Video {

	@Id
	@GeneratedValue
	Long id;

	@Column(nullable = false)
	String title;

	@Column(nullable = false)
	String[] tags;

	@Column(nullable = false)
	Integer likes;

	@Column(nullable = false)
	Integer dislikes;

	@Column(nullable = false)
	Integer views;

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
