package york.eng2.video.cli.domain;

import java.util.Set;
import java.util.stream.Collectors;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class Video {

	private Long id;

	private String title;

	private Set<Hashtag> hashtags;

	private Set<User> likes;

	private Set<User> dislikes;

	private Set<User> viewers;

	private User user;

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

	public Set<Hashtag> getHashtags() {
		return hashtags;
	}

	public void setHashtags(Hashtag tag) {
		System.out.printf("set tags ", tag);
		this.hashtags.add(tag);
	}

	public String formatStringTags() {
		return hashtags.stream().map(Hashtag::getName).collect(Collectors.joining(","));
	}

	public Set<User> getLikes() {
		return likes;
	}

	public void setLikes(User user) {
		this.likes.add(user);
	}

	public Set<User> getDislikes() {
		return dislikes;
	}

	public void setDislikes(User user) {
		this.dislikes.add(user);
	}

	public Set<User> getViewers() {
		return viewers;
	}

	public void setViewers(User viewer) {
		this.viewers.add(viewer);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Video = " + id + ", title=" + title + ", tags= [" + (hashtags == null ? "no tags" : formatStringTags())
				+ "], likes = " + (likes == null ? "0" : likes.size()) + ", dislikes = "
				+ (dislikes == null ? "0" : dislikes.size()) + ", views = " + (viewers == null ? "0" : viewers.size())
				+ ", user = " + user.getUsername();
	}
}
