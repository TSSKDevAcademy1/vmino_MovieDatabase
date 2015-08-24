package sk.tsystems.akademia.MovieDatabase.dao;

import sk.tsystems.akademia.MovieDatabase.JPAHelper;
import sk.tsystems.akademia.MovieDatabase.model.Genre;

public class GenreDao extends AbstractDao {
	
	public static Genre find(long id) {
		return JPAHelper.getEntityManager().find(Genre.class, id);
	}
	
	public static void createGenre(String name, String description){
		GenreDao.save(new Genre(name, description));
	}
}
