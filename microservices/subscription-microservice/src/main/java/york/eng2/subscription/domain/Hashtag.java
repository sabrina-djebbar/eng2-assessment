package york.eng2.subscription.domain;

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
public class Hashtag {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@JsonIgnore
	@ManyToMany
	private Set<User> subscribers;

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

	public Set<User> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(User user) {
		this.subscribers.add(user);
	}
}
