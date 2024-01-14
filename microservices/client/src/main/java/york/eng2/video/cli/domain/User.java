package york.eng2.video.cli.domain;

import java.util.HashSet;
import java.util.Set;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class User {
	private Long id;

	private String username;

	private Set<Video> likedVideos = new HashSet<>();

	private Set<Video> dislikedVideos = new HashSet<>();

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

	@Override
	public String toString() {
		return "id =" + id + ", username=" + username;
	}
}
