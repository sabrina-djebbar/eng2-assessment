package york.eng2.subscription.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micronaut.serde.annotation.Serdeable;

@Entity
@Serdeable
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String username;

	@JsonIgnore
	@ManyToMany(mappedBy = "views")
	private Set<Video> viewedVideos = new HashSet<>();

	@JsonIgnore
	@ManyToMany(mappedBy = "subscribers")
	private Set<Hashtag> subscribedTo = new HashSet<>();;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Hashtag> getSubscribedTo() {
		return subscribedTo;
	}

	public void subscribedToHashtag(Hashtag tag) {
		this.subscribedTo.add(tag);
	}

	public void unsubscribedToHashtag(Hashtag tag) {
		this.subscribedTo.remove(tag);
	}

	public Set<Video> getViewedVideos() {
		return viewedVideos;
	}

	public void setViewedVideos(Video video) {
		this.viewedVideos.add(video);
	}
}
