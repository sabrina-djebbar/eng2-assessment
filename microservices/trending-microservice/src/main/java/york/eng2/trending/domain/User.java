package york.eng2.trending.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@ManyToMany(mappedBy = "likes", fetch = FetchType.LAZY)
	private Set<Video> likedVideos;

	@JsonIgnore
	@ManyToMany(mappedBy = "dislikes", fetch = FetchType.LAZY)
	private Set<Video> dislikedVideos;

	@JsonIgnore
	@ManyToMany(mappedBy = "viewers", fetch = FetchType.LAZY)
	private Set<Video> viewedVideos;

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

	public Set<Video> getLikedVideos() {
		return likedVideos;
	}

	public void setLikedVideos(Video video) {
		this.likedVideos.add(video);
	}

	public Set<Video> getDislikedVideos() {
		return dislikedVideos;
	}

	public void setDislikedVideos(Video video) {
		this.dislikedVideos.add(video);
	}

	public Set<Video> getViewedVideos() {
		return viewedVideos;
	}

	public void setViewedVideos(Video video) {
		this.viewedVideos.add(video);
	}

}
