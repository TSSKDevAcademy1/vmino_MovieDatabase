package sk.tsystems.akademia.MovieDatabase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Genre {

	// ----------------------------------------- Variables

	@Id
	@GeneratedValue
	private long id;

	private String name;

	private String description;

	// ----------------------------------------- Constructors

	public Genre() {
	}

	public Genre(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	// ----------------------------------------- Getters / Setters / Adders

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	// ----------------------------------------- toString method

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Genre [id=");
		builder.append(id);
		builder.append(", ");
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (description != null) {
			builder.append("description=");
			builder.append(description);
		}
		builder.append("]");
		return builder.toString();
	}
}
