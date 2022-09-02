package beans;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import db.GameDB;
import entities.Game;

@ManagedBean
@RequestScoped 
public class GameMB {
	
	private int id;
	private String name;
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public static List<Game> getAllGames() {
		return GameDB.getAllGames();
	}

	public String showGameDetails(int id) {
		Game game = findById(id);
		sessionMap.put("editGame", game);
		return "updateGameName.xhtml?faces-redirect=true";
	}
	
	private Game findById(int id) {
		return GameDB.findById(id);
	}

	public static String updateGame(Game game) {
		GameDB.updateGame(game);
		return "displayGameList.xhtml?faces-redirect=true";
	}
	
	public String newGame() {
		Game game = new Game();
		sessionMap.put("newGame", game);
		return "addGame.xhtml?faces-redirect=true";
	}
	
	public static String saveGame(Game game) {
		GameDB.saveGame(game);
		return "displayGameList.xhtml?faces-redirect=true";
	}

	public static void deleteGameById(int id) {
		GameDB.deleteGameById(id);
	}
	
	
	
}
