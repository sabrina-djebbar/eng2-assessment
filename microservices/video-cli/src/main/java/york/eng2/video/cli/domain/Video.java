package york.eng2.video.cli.domain;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class Video {

	Long id;

	String title;

	String[] tags;

	Integer likes = 0;

	Integer dislikes = 0;

	Integer views = 0;

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
