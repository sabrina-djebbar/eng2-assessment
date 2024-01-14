package york.eng2.video.cli.domain;

import java.util.Set;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class Hashtag {

	private Long id;

	private String name;

	private Set<Video> taggedVideos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Video> getTaggedVideos() {
		return taggedVideos;
	}

	public void setTaggedVideos(Video video) {
		this.taggedVideos.add(video);
	}

	@Override
	public String toString() {
		return "Hashtag = " + id + ", name= " + name;
	}
}
