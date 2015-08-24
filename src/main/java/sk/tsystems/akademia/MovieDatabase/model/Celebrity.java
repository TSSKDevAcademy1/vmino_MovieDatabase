package sk.tsystems.akademia.MovieDatabase.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Celebrity {

	// ----------------------------------------- Variables

	@Id
	@GeneratedValue
	private long id;

	private String surname;

	private String firstName;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Column(length = 3000)
	private String biography;

	@ManyToMany(mappedBy="directors", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<VideoArt> directed = new ArrayList<>();

	@ManyToMany(mappedBy="actors", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<VideoArt> actedAt = new ArrayList<>();

	// ----------------------------------------- Constructors

	public Celebrity() {
	}

	public Celebrity(String surname, String firstName, Date dateOfBirth, String biography) {
		super();
		this.surname = surname;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.biography = biography;
	}

	// ----------------------------------------- Getters / Setters / Adders

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public List<VideoArt> getDirected() {
		return directed;
	}

	public void addDirected(VideoArt videoArt) {
		this.directed.add(videoArt);
		videoArt.addDirectorFromCelebrity(this);
	}
	
	public void addDirectedFromVideoArt(VideoArt videoArt) {
		this.directed.add(videoArt);
	}

	public List<VideoArt> getActedAt() {
		return actedAt;
	}

	public void addActedAt(VideoArt videoArt) {
		this.actedAt.add(videoArt);
		videoArt.addActorFromCelebrity(this);
	}
	
	public void addActedAtFromVideoArt(VideoArt videoArt) {
		this.actedAt.add(videoArt);
	}

	public long getId() {
		return id;
	}

	// ----------------------------------------- toString method
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Celebrity [id=");
		builder.append(id);
		builder.append(", ");
		if (surname != null) {
			builder.append("surname=");
			builder.append(surname);
			builder.append(", ");
		}
		if (firstName != null) {
			builder.append("firstName=");
			builder.append(firstName);
			builder.append(", ");
		}
		if (dateOfBirth != null) {
			builder.append("dateOfBirth=");
			builder.append(dateOfBirth);
			builder.append(", ");
		}
		if (biography != null) {
			builder.append("biography=");
			builder.append(biography);
			builder.append(", ");
		}
		if (directed != null) {
			builder.append("directed=");
			builder.append(directed);
			builder.append(", ");
		}
		if (actedAt != null) {
			builder.append("actedAt=");
			builder.append(actedAt);
		}
		builder.append("]");
		return builder.toString();
	}

}
