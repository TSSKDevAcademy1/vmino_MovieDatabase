package sk.tsystems.akademia.MovieDatabase.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movie extends VideoArt {

	// ----------------------------------------- Variables

	@Temporal(TemporalType.DATE)
	private Date publicationDate;

	private int length;

	// ----------------------------------------- Constructors

	public Movie() {
	}

	public Movie(String name, int yearOfPublication, Date publicationDate, int length) {
		super(name, yearOfPublication);
		this.publicationDate = publicationDate;
		this.length = length;
	}

	// ----------------------------------------- Getters / Setters / Adders

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	// ----------------------------------------- toString method

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Movie [");
		if (publicationDate != null) {
			builder.append("publicationDate=");
			builder.append(publicationDate);
			builder.append(", ");
		}
		builder.append("length=");
		builder.append(length);
		builder.append("]");
		return builder.toString();
	}

}
