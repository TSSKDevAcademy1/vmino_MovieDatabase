package sk.tsystems.akademia.MovieDatabase.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class Review {

	// ----------------------------------------- Variables

	@Id
	@GeneratedValue
	private long id;

	private Date dateTimeOfCreation;

	@ManyToOne
	private VideoArt reviewed;

	private int rating;

	@Column(length = 5000)
	private String text;

	// ----------------------------------------- Constructors

	public Review() {
	}

	public Review(int rating, String text) {
		super();
		this.rating = rating;
		this.text = text;
	}

	// ----------------------------------------- Getters / Setters / Adders

	public Date getDateTimeOfCreation() {
		return dateTimeOfCreation;
	}

	@PrePersist
	public void setDateTimeOfCreation() {
		this.dateTimeOfCreation = new Date();
	}

	public VideoArt getReviewed() {
		return reviewed;
	}

	public void setReviewed(VideoArt videoArt) {
		this.reviewed = videoArt;
		videoArt.addReviewFromReview(this);
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getId() {
		return id;
	}

	// ----------------------------------------- toString method

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [id=");
		builder.append(id);
		builder.append(", ");
		if (dateTimeOfCreation != null) {
			builder.append("dateTimeOfCreation=");
			builder.append(dateTimeOfCreation);
			builder.append(", ");
		}
		if (reviewed != null) {
			builder.append("reviewed=");
			builder.append(reviewed);
			builder.append(", ");
		}
		builder.append("rating=");
		builder.append(rating);
		builder.append(", ");
		if (text != null) {
			builder.append("text=");
			builder.append(text);
		}
		builder.append("]");
		return builder.toString();
	}
}
