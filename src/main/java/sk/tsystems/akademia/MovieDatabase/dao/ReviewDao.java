package sk.tsystems.akademia.MovieDatabase.dao;

import sk.tsystems.akademia.MovieDatabase.JPAHelper;
import sk.tsystems.akademia.MovieDatabase.model.Review;

public class ReviewDao extends AbstractDao {

	public static Review find(long id) {
		return JPAHelper.getEntityManager().find(Review.class, id);
	}
}
