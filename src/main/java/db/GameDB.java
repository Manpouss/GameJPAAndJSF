package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Game;

public class GameDB {
	
	public static List<Game> getAllGames() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_gamelist");
		EntityManager em = emf.createEntityManager();
		List<Game> games = em.createQuery("from Game", Game.class).getResultList();
		em.close();
		emf.close();
		return games;
	}
	
	public static void deleteGameById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_gamelist");
		EntityManager em = emf.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		Game game = em.find(Game.class, id);
		em.remove(game);
		trans.commit();
		em.close();
		emf.close();
	}

	public static Game findById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_gamelist");
		EntityManager em = emf.createEntityManager();
		Game game = em.find(Game.class, id);
		em.close();
		emf.close();
		return game;
	}
	
	public static void updateGame(Game game) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_gamelist");
		EntityManager em = emf.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		em.merge(game);
		trans.commit();
		em.close();
		emf.close();
	}

	public static void saveGame(Game game) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_gamelist");
		EntityManager em = emf.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		em.persist(game);
		trans.commit();
		em.close();
		emf.close();
	}
}
