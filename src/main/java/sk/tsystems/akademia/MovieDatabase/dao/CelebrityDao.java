package sk.tsystems.akademia.MovieDatabase.dao;

import java.util.Date;

import sk.tsystems.akademia.MovieDatabase.JPAHelper;
import sk.tsystems.akademia.MovieDatabase.model.Celebrity;

public class CelebrityDao extends AbstractDao {

	public static Celebrity find(long id) {
		return JPAHelper.getEntityManager().find(Celebrity.class, id);
	}

	public static void createCelebrity(String firstName, String surname, Date dateOfBirth, String biography) {
		Celebrity celebrity = new Celebrity(surname, firstName, dateOfBirth, biography);
		CelebrityDao.save(celebrity);
	}

}
