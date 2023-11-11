package york.eng2.video.dto;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class VideoDTO {
	private String title;
	private String[] tags;
	private String userId;
	private Integer likes = 0;
	private Integer dislikes = 0;
	private Integer views = 0;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes() {
		likes++;
	}

	public Integer getDislikes() {
		return dislikes;
	}

	public void setDislikes() {
		dislikes++;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews() {
		views++;
	}
}
