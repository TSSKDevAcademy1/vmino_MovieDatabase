package sk.tsystems.akademia.MovieDatabase.dao;

import java.util.Date;
import java.util.List;

import sk.tsystems.akademia.MovieDatabase.JPAHelper;
import sk.tsystems.akademia.MovieDatabase.model.Celebrity;
import sk.tsystems.akademia.MovieDatabase.model.Genre;
import sk.tsystems.akademia.MovieDatabase.model.Movie;
import sk.tsystems.akademia.MovieDatabase.model.Review;
import sk.tsystems.akademia.MovieDatabase.model.TvSeries;
import sk.tsystems.akademia.MovieDatabase.model.VideoArt;

public class VideoArtDao extends AbstractDao {

	public static VideoArt find(long id) {
		return JPAHelper.getEntityManager().find(VideoArt.class, id);
	}

	public static void createMovie(String name, int yearOfPublication, Date publicationDate, int length) {
		VideoArtDao.save(new Movie(name, yearOfPublication, publicationDate, length));
	}

	public static void createTvSeries(String name, int yearOfPublication, int seriesCount, int episodeCount,
			int startYear, int endYear) {
		VideoArtDao.save(new TvSeries(name, yearOfPublication, seriesCount, episodeCount, startYear, endYear));
	}

	public static void addGenreToVideoArt(VideoArt videoArt, Genre genre) {
		videoArt.addGenre(genre);
	}

	public static void addDirectorToVideoArt(VideoArt videoArt, Celebrity director) {
		videoArt.addDirector(director);
	}

	public static void addActorToVideoArt(VideoArt videoArt, Celebrity actor) {
		videoArt.addActor(actor);
	}

	public static void createReviewToVideoArt(VideoArt videoArt, int rating, String text) {
		Review review = new Review(rating, text);
		videoArt.addReview(review);
	}

	public static void findVideoArtsByYear(int year) {
		List<VideoArt> videoArts = JPAHelper.getEntityManager()
				.createQuery("SELECT v FROM VideoArt v WHERE yearOfPublication = :year", VideoArt.class)
				.setParameter("year", year).getResultList();
		System.out.println("-----------\nResult:\n-----------");
		for (VideoArt v : videoArts) {
			System.out.println(v.getId() + ", " + v.getName() + ", " + v.getYearOfPublication());
		}
	}

	public static void findMoviesByYear(int year) {
		List<Movie> movies = JPAHelper.getEntityManager()
				.createQuery("SELECT m FROM Movie m WHERE yearOfPublication = :year", Movie.class)
				.setParameter("year", year).getResultList();
		System.out.println("-----------\nResult:\n-----------");
		for (Movie m : movies) {
			System.out.println(m.getId() + ", " + m.getName() + ", " + m.getYearOfPublication());
		}
	}

	public static void findVideoArtsByActor(Celebrity celebrity) {
		List<VideoArt> videoArts = JPAHelper.getEntityManager()
				.createQuery("SELECT v FROM VideoArt v JOIN FETCH v.actors ac WHERE ac.id = :celebrity", VideoArt.class)
				.setParameter("celebrity", celebrity.getId()).getResultList();
		System.out.println("-----------\nResult:\n-----------");
		for (VideoArt v : videoArts) {
			System.out.println(v.getId() + ", " + v.getName() + ", " + v.getYearOfPublication());
		}
	}

	public static void findMoviesByActor(Celebrity celebrity) {
		List<Movie> movies = JPAHelper.getEntityManager()
				.createQuery("SELECT m FROM Movie m JOIN FETCH m.actors ac WHERE ac.id = :celebrity", Movie.class)
				.setParameter("celebrity", celebrity.getId()).getResultList();
		System.out.println("-----------\nResult:\n-----------");
		for (Movie m : movies) {
			System.out.println(m.getId() + ", " + m.getName() + ", " + m.getYearOfPublication());
		}
	}

	public static void getTvSeriesCount() {
		List<TvSeries> series = JPAHelper.getEntityManager().createQuery("SELECT tv FROM TvSeries tv", TvSeries.class)
				.getResultList();
		System.out.println("Number of TV Series is: " + series.size());
	}

	public static void getMoviesCount() {
		List<Movie> movies = JPAHelper.getEntityManager().createQuery("SELECT m FROM Movie m", Movie.class)
				.getResultList();
		System.out.println("Number of Movies is: " + movies.size());
	}

	public static void findVideoArtsByGenre(Genre genre) {
		List<VideoArt> videoArts = JPAHelper.getEntityManager()
				.createQuery("SELECT v FROM VideoArt v JOIN FETCH v.genres g WHERE g.id = :genre", VideoArt.class)
				.setParameter("genre", genre.getId()).getResultList();
		System.out.println("-----------\nResult:\n-----------");
		for (VideoArt v : videoArts) {
			System.out.println(v.getId() + ", " + v.getName() + ", " + v.getYearOfPublication());
		}
	}

	public static void findMoviesByRating(int rating) {
		List<Movie> movies = JPAHelper.getEntityManager()
				.createQuery("SELECT m FROM Movie m JOIN FETCH m.reviews r WHERE r.rating >= :rating", Movie.class)
				.setParameter("rating", rating).getResultList();
		System.out.println("-----------\nResult:\n-----------");
		for (Movie m : movies) {
			System.out.println(m.getId() + ", " + m.getName() + ", " + m.getYearOfPublication());
		}
	}

	public static void getMoviesCountByGenre(Genre genre) {
		List<Movie> movies = JPAHelper.getEntityManager()
				.createQuery("SELECT m FROM Movie m JOIN FETCH m.genres g WHERE g.id = :genre", Movie.class)
				.setParameter("genre", genre.getId()).getResultList();
		System.out.println("Number of " + genre.getName() + " Movies is: " + movies.size());
	}

	public static void getBestRatedMovie() {
		Movie best = null;
		int bestRating = 0;
		List<Movie> movies = JPAHelper.getEntityManager().createQuery("SELECT m FROM Movie m", Movie.class)
				.getResultList();
		for (Movie m : movies) {
			int sum = 0;
			int rating = 0;
			List<Review> reviews = m.getReview();
			for (Review r : reviews) {
				sum += r.getRating();
			}
			if (reviews.size() > 0) {
				rating = sum / reviews.size();
			}
			if (rating > bestRating) {
				bestRating = rating;
				best = m;
			}
		}
		System.out.println("Best rated Movie is: " + best.getId() + ", " + best.getName());
	}

	public static void findSuperCelebrity() {
		List<VideoArt> videoArts = JPAHelper.getEntityManager()
				.createQuery(
						"SELECT v FROM VideoArt v JOIN FETCH v.directors d JOIN v.actors a WHERE d.id = a.id",
						VideoArt.class)
				.getResultList();
		System.out.println("-----------\nResult:\n-----------");
		for (VideoArt v : videoArts) {
			List<Celebrity> actors = v.getActors();
			List<Celebrity> directors = v.getDirectors();
			for (Celebrity a : actors) {
				for (Celebrity d : directors) {
					if (a.getId() == d.getId()) {
						System.out.println(v.getName() + "," + d.getFirstName() + " " + d.getSurname());
					}
				}
			}
		}
	}

}
