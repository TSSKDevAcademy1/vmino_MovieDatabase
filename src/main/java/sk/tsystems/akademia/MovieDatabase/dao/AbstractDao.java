package sk.tsystems.akademia.MovieDatabase.dao;

import java.util.List;

import sk.tsystems.akademia.MovieDatabase.JPAHelper;

public abstract class AbstractDao {
	public static void save(Object object) {

		JPAHelper.beginTransaction();
		JPAHelper.getEntityManager().persist(object);
		JPAHelper.commitTransaction();
	}

	public static void listAll(Class<?> clazz) {
		JPAHelper.beginTransaction();

		List<?> objects = JPAHelper.getEntityManager().createQuery("SELECT p FROM " + clazz.getName() + " p", clazz)
				.getResultList();
		for (Object p : objects) {
			System.out.println(p);
		}

		JPAHelper.commitTransaction();
	}
}
