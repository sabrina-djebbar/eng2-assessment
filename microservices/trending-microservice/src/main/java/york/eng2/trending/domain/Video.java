package york.eng2.trending.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import io.micronaut.serde.annotation.Serdeable;

@Entity
@Serdeable
public class Video {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String[] tags;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "VideoTags", joinColumns = @JoinColumn(name = "taggedVideos"), inverseJoinColumns = @JoinColumn(name = "hashtags"))
	private Set<Hashtag> hashtags;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "VideoLikes", joinColumns = @JoinColumn(name = "likedVideos"), inverseJoinColumns = @JoinColumn(name = "likes"))
	private Set<User> likes;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "VideoDislikes", joinColumns = @JoinColumn(name = "dislikedVideos"), inverseJoinColumns = @JoinColumn(name = "dislikes"))
	private Set<User> dislikes;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "VideoViewers", joinColumns = @JoinColumn(name = "viewedVideos"), inverseJoinColumns = @JoinColumn(name = "viewers"))
	private Set<User> viewers;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
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

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<User> getViewers() {
		return viewers;
	}

	public void setViewers(User viewer) {
		this.viewers.add(viewer);
	}

	public Set<Hashtag> getHashtags() {
		return hashtags;
	}

	public void setHashtags(Hashtag hashtag) {
		this.hashtags.add(hashtag);
	}

}