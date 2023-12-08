package york.eng2.trending.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.micronaut.serde.annotation.Serdeable;

@Entity
@Serdeable
public class Hashtag {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	/*
	 * @JsonIgnore
	 * 
	 * @ManyToMany(mappedBy = "hashtags", fetch = FetchType.LAZY) private Set<Video>
	 * taggedVideos;
	 */

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

	/*
	 * public Set<Video> getTaggedVideos() { return taggedVideos; }
	 * 
	 * public void setTaggedVideos(Video video) { this.taggedVideos.add(video); }
	 */
}
