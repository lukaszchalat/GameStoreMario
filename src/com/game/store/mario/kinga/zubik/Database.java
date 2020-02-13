package com.game.store.mario.kinga.zubik;

import java.util.ArrayList;
import java.util.List;

public class Database 
{
	private List<ComputerGame> computerGames;
	private List<CardGame> cardGames;
	private List<BoardGame> boardGames;
	
	private static Database instance;
	
	private Database()
	{
		loadResources();
	}
	
	public static Database getInstance()
	{
		if(instance == null)
		{
			instance = new Database();		
		}
		
		return instance;
	}
	
	private void loadResources()
	{
		computerGames = new ArrayList<>();
		
		computerGames.add(new ComputerGame(1, "Wiedzmin 3", 99.90, "Gra o wiedzminie Geralcie", "RPG"));
		computerGames.add(new ComputerGame(2, "Tom Raider", 49.90, "Hit sylwestrowej nocy", "Przygodowa"));
		computerGames.add(new ComputerGame(3, "Minecraft", 69.90, "Jesli masz nadmiar wolnego czasu i brak pomyslu na zycie o gra dla Ciebie", "RPG"));
		computerGames.add(new ComputerGame(4, "Heroes 3", 99.90, "Klasyk na dlugie noce. Nigdy sie nie nudzi", "Turowa"));
		computerGames.add(new ComputerGame(5, "Warcraft 3", 99.90, "Work work ... ;)", "RPS"));
		
		cardGames = new ArrayList<>();
		
		cardGames.add(new CardGame(6, "Dixit", 150.00, "Sprawdz swoja wyobraznie"));
		cardGames.add(new CardGame(7, "Uno", 50.00, "Uno due ..."));
		
		boardGames = new ArrayList<>();
		
		boardGames.add(new BoardGame(8, "Szachy", 200.00, "Szachy jakie sa kazdy widzi"));
		boardGames.add(new BoardGame(9, "Warcaby", 100.00, "Szachy dla ubogich"));
		boardGames.add(new BoardGame(10, "Chinczyk", 200.00, "Takie tam wyscigi z kostka"));
		boardGames.add(new BoardGame(11, "Monopoly", 200.00, "Dla kazdego kto chce zostac developerem"));
	}

	public List<ComputerGame> getComputerGames() 
	{
		return computerGames;
	}

	public List<CardGame> getCardGames() 
	{
		return cardGames;
	}

	public List<BoardGame> getBoardGames() 
	{
		return boardGames;
	}
	
	public List<Game> getAllGames()
	{
		List<Game> games = new ArrayList<>();
		
		games.addAll(computerGames);
		games.addAll(cardGames);
		games.addAll(boardGames);
		
		return games;
	}
	
	public Game getProductById(int id)
	{
		return getAllGames().stream().filter(game -> game.getISBN() == id).findFirst().orElse(null);
	}
}
