package york.eng2.video.cli.dto;

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

	public void likeVideo() {
		likes++;
	}

	public Integer getDislikes() {
		return dislikes;
	}

	public void dislikeVideo() {
		dislikes++;
	}

	public Integer getViews() {
		return views;
	}

	public void watchVideo() {
		views++;
	}

	@Override
	public String toString() {
		return "Video [title= " + title + ", tags= [" + String.join(",", tags) + "], likes = " + likes + ", dislikes = "
				+ dislikes + ", views = " + views + ", user=" + userId + "]";
	}
}
