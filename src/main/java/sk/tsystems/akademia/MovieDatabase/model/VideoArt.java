package sk.tsystems.akademia.MovieDatabase.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public abstract class VideoArt {

	// ----------------------------------------- Variables

	@Id
	@GeneratedValue
	private long id;

	private String name;

	private int yearOfPublication;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Genre> genres = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "directors")
	private List<Celebrity> directors = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "actors")
	private List<Celebrity> actors = new ArrayList<>();

	@OneToMany(mappedBy = "reviewed")
	private List<Review> reviews = new ArrayList<>();

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> additionalInfo = new ArrayList<>();

	// ----------------------------------------- Constructors

	public VideoArt() {
	}

	public VideoArt(String name, int yearOfPublication) {
		super();
		this.name = name;
		this.yearOfPublication = yearOfPublication;
	}

	// ----------------------------------------- Getters / Setters / Adders

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void addGenre(Genre genre) {
		this.genres.add(genre);
	}

	public List<Celebrity> getDirectors() {
		return directors;
	}

	public void addDirector(Celebrity celebrity) {
		this.directors.add(celebrity);
		celebrity.addDirectedFromVideoArt(this);
	}

	public void addDirectorFromCelebrity(Celebrity celebrity) {
		this.directors.add(celebrity);
	}

	public List<Celebrity> getActors() {
		return actors;
	}

	public void addActor(Celebrity celebrity) {
		this.actors.add(celebrity);
		celebrity.addActedAtFromVideoArt(this);
	}

	public void addActorFromCelebrity(Celebrity celebrity) {
		this.actors.add(celebrity);
	}

	public List<Review> getReview() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
		review.setReviewed(this);
	}

	public void addReviewFromReview(Review review) {
		this.reviews.add(review);
	}

	public List<String> getAdditionalInfo() {
		return additionalInfo;
	}

	public void addAdditionalInfo(String info) {
		this.additionalInfo.add(info);
	}

	public void removeAdditionalInfo(String info) {
		this.additionalInfo.remove(info);
	}

	// ----------------------------------------- toString method

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VideoArt [id=");
		builder.append(id);
		builder.append(", ");
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		builder.append("yearOfPublication=");
		builder.append(yearOfPublication);
		builder.append(", ");
		if (genres != null) {
			builder.append("genres=");
			builder.append(genres);
			builder.append(", ");
		}
		if (directors != null) {
			builder.append("directors=");
			builder.append(directors);
			builder.append(", ");
		}
		if (actors != null) {
			builder.append("actors=");
			builder.append(actors);
			builder.append(", ");
		}
		if (reviews != null) {
			builder.append("reviews=");
			builder.append(reviews);
			builder.append(", ");
		}
		if (additionalInfo != null) {
			builder.append("additionalInfo=");
			builder.append(additionalInfo);
		}
		builder.append("]");
		return builder.toString();
	}

}
