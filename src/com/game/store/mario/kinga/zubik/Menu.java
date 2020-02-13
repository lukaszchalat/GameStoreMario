package com.game.store.mario.kinga.zubik;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static com.game.store.mario.kinga.zubik.OptionEnum.*;

public class Menu 
{
	private List<Game> games;
	private Scanner scanner;
	private String selectedOption;
	private ShoppingCart shoppingCart;
	
    public Menu() 
    {
    	this.games = Database.getInstance().getAllGames();
    	scanner = new Scanner(System.in);
    	shoppingCart = new ShoppingCart();
    }

    public void showMenu() 
    {
        System.out.println("Game Store Mario");
        System.out.println("Dostepny asortyment:");
        
        for(int i = 0; i < games.size(); i++)
        {
        	int menuPosition = i + 1;
        	
        	System.out.println(menuPosition + ". " + games.get(i).getName() + " " + games.get(i).getPrice() + " (" + games.get(i).getDescription() + ")");
        }
        
        if(! shoppingCart.isEmpty()) 
        {
        	System.out.println();
        	showShoppingCartContent();
        	System.out.println();
        }
        
        selectedOption = showOptions();
        
        executeOption(selectedOption);
    }
    
    public String showOptions()
    {
    	System.out.println();
    	System.out.println("Pokaz tylko gry komputerowe (K)");
    	System.out.println("Pokaz tylko gry karciane (A)");
    	System.out.println("Pokaz tylko gry planszowe (P)");
    	System.out.println("Pokaz wszystkie gry (W)");
    	System.out.println("Zamknij aplikacje (Z)");
    	System.out.println("Dodaj gre do koszyka (podaj numer produktu np. 1)");
    	System.out.println("Wybierz opcje: ");
    	
    	String option = scanner.nextLine();
    	
    	return option;
    }
    
    public void executeOption(String option)
    {
    	if(option.equals(CLOSE.getOption()))
    	{
    		System.exit(0);
    	}
    	else if(option.equals(ALL_GAMES.getOption()))
    	{
    		games.clear();
    		games.addAll(Database.getInstance().getAllGames());
    	}
    	else if(option.equals(ONLY_COMPUTER_GAMES.getOption()))
    	{
    		games.clear();
    		games.addAll(Database.getInstance().getComputerGames());
    	}
    	else if(option.equals(ONLY_CARD_GAMES.getOption()))
    	{
    		games.clear();
    		games.addAll(Database.getInstance().getCardGames());
    	}
    	else if(option.equals(ONLY_BOARD_GAMES.getOption()))
    	{
    		games.clear();
    		games.addAll(Database.getInstance().getBoardGames());
    	}
    	else
    	{
    		checkIfProductOption(option);
    	}
    }
    
    public boolean checkIfProductOption(String option)
    {
    	try
    	{
    		int productOption = Integer.parseInt(option);
    		Game selectedGame = Database.getInstance().getProductById(productOption);
    		
    		if(selectedGame != null)
    		{
    			shoppingCart.addProduct(selectedGame);
    		}
    		else 
    		{
    			System.out.println("Produkt o id: " + productOption + " nie istnieje. Prosze wybrac inny produkt.");
    			System.out.println();
    		}
    	}
    	catch(NumberFormatException nfe)
    	{
    		System.out.println("Podana opcja nie jest wspierana !!!");
    		System.out.println();
    	}
    	
    	return true;
    }
    
    public void showShoppingCartContent()
    {
    	System.out.println("Zawartosc twojego koszyka: ");
    	
    	for(Map.Entry<Game, Integer> entry: shoppingCart.getContent().entrySet())
    	{
    		System.out.println(entry.getKey().getName() + " " + entry.getValue());
    	}
    	
    	System.out.println();
    	System.out.println("Suma : " + shoppingCart.getSum());
    }
}
