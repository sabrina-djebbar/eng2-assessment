package york.eng2.video.domain;

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
	@ManyToMany(mappedBy = "likes")
	private Set<Video> likedVideos = new HashSet<>();

	@JsonIgnore
	@ManyToMany(mappedBy = "dislikes")
	private Set<Video> dislikedVideos = new HashSet<>();

	@JsonIgnore
	@ManyToMany(mappedBy = "viewers")
	private Set<Video> viewedVideos = new HashSet<>();

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
