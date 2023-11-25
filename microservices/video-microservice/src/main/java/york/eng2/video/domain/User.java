package york.eng2.video.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.micronaut.serde.annotation.Serdeable;

@Entity
@Serdeable
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String username;
	/*
	 * @JsonIgnore
	 * 
	 * @ManyToMany(mappedBy = "likes") private Set<Video> likedVideos;
	 * 
	 * 
	 * 
	 * @JsonIgnore
	 * 
	 * @ManyToMany(mappedBy = "dislikes") private Set<Video> dislikedVideos;
	 */

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

	// getLike videos and setLikedVideos
	/*
	 * public Set<Video> getLikedVideos() { return likedVideos; }
	 * 
	 * public void setReadBooks(Set<Video> likedVideos) { this.likedVideos =
	 * likedVideos; }
	 */
}
