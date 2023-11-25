package york.eng2.video.cli.domain;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class Video {

	Long id;

	String title;

	String[] tags;

	Integer likes;

	Integer dislikes;

	Integer views;

	Long userId;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Video = " + id + ", title=" + title + ", tags= [" + String.join(",", tags) + "], likes = " + likes
				+ ", dislikes = " + dislikes + ", views = " + views + ", user=" + userId;
	}
}
