package sk.tsystems.akademia.MovieDatabase;

import java.util.Date;

import sk.tsystems.akademia.MovieDatabase.dao.CelebrityDao;
import sk.tsystems.akademia.MovieDatabase.dao.GenreDao;
import sk.tsystems.akademia.MovieDatabase.dao.ReviewDao;
import sk.tsystems.akademia.MovieDatabase.dao.VideoArtDao;
import sk.tsystems.akademia.MovieDatabase.model.Celebrity;
import sk.tsystems.akademia.MovieDatabase.model.Genre;
import sk.tsystems.akademia.MovieDatabase.model.Movie;
import sk.tsystems.akademia.MovieDatabase.model.Review;
import sk.tsystems.akademia.MovieDatabase.model.TvSeries;
import sk.tsystems.akademia.MovieDatabase.model.VideoArt;

public class App {
	public static void main(String[] args) {
		
//		Metody:
//		1. vytvorenie noveho filmu (movie) alebo serialu (tv series)
//		VideoArtDao.createMovie("New Movie", 2015, new Date(), 120);
//		VideoArtDao.createTvSeries("New Series", 2015, 1, 1, 2015, 2099);
		
//		2. vytvorenie noveho zanru (genre), vypisanie vsetkych ulozenych zanrov
//		GenreDao.createGenre("documentary", "learning video");
//		GenreDao.listAll(Genre.class);
		
//		3. pridanie zanru do video art 
//		VideoArt videoArt = VideoArtDao.find(22);
//		Genre genre = GenreDao.find(42);
//		VideoArtDao.addGenreToVideoArt(videoArt, genre); //videoArt and genre are objects

//		4. vytvorenie novej celebrity (BEZ priradenych filmov a serialov ktore rezirovali alebo v ktorych hrali)
//		CelebrityDao.createCelebrity("FirstName", "Surname", new Date(), "some biography");
		
//		5. pridanie rezisera do video art
//		VideoArtDao.addDirectorToVideoArt(videoArt, director); //videoArt and director are objects
		
//		6. pridanie herca do video art
//		VideoArtDao.addActorToVideoArt(videoArt, actor); //videoArt and actor are objects
		
//		7. vytvorenie review k video art
//		VideoArtDao.createReviewToVideoArt(videoArt, 5, "some cool text"); //videoArt is object

//		Selecty:
//		1. zobrazenie vsetkych filmov publikovanych vo zvoleny rok
//		VideoArtDao.findMoviesByYear(1994);
		
//	    2. zobrazenie vsetkych filmov v ktorych hral zvoleny herec
//		VideoArtDao.findMoviesByActor(CelebrityDao.find(33));
		
//		3. zobrazenie celkoveho poctu tv serialov v databaze
//		VideoArtDao.getTvSeriesCount();
		
//		4. zobrazenie celkoveho poctu filmov v databaze
//		VideoArtDao.getMoviesCount();
		
//		5. zobrazenie vsetkych filmov a serialov zvoleneho zanru
//		VideoArtDao.findVideoArtsByGenre(GenreDao.find(42));
		
//		6. zobrazenie vsetkych filmov, ktore maju aspon jedno review s hodnotenim podla zvoleneho cisla a vyssie
//		VideoArtDao.findMoviesByRating(8);
		
//		7. zobrazenie suctu minut filmov zvoleneho zanru
//		VideoArtDao.getMoviesCountByGenre(GenreDao.find(42));
		
//		8. zobrazenie najlepsie hodnoteneho filmu (pouzit priemer hodnoteni pre film)
//		VideoArtDao.getBestRatedMovie();

//		Bonus:
//		 - zobrazenie parov celebrity a video art, kde celebrita vystupuje aj ako reziser aj ako herec
//		VideoArtDao.findSuperCelebrity();
		
		JPAHelper.close();
	}
}
