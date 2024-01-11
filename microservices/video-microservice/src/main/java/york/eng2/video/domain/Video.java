package york.eng2.video.domain;

import java.util.HashSet;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import io.micronaut.serde.annotation.Serdeable;

@Entity
@Serdeable
public class Video {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String title;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "video_hashtag")
	private Set<Hashtag> hashtags;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "video_user_likes")
	private Set<User> likes;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "video_user_dislikes")
	private Set<User> dislikes;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "video_user_views")
	private Set<User> viewers;

	@ManyToOne(fetch = FetchType.LAZY)
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

	public Set<Hashtag> getHashtags() {
		return hashtags;
	}

	public void setHashtags(Hashtag tag) {
		if (this.hashtags == null) {
			this.hashtags = new HashSet<>();
		}
		this.hashtags.add(tag);
	}

	public Set<User> getLikes() {
		return likes;
	}

	public void setLikes(User user) {
		if (this.likes == null) {
			this.likes = new HashSet<User>();
		}
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

}
