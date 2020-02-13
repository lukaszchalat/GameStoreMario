package com.game.store.mario.kinga.zubik;

import java.util.ArrayList;
import java.util.List;

public class ComputerGame extends Game
{
	private String type;
	private List<String> platforms;
	
	
	
	public ComputerGame() {
		super();
	}

	public ComputerGame(int iSBN, String name, double price, String description, String type) {
		super(iSBN, name, price, description);
		this.type = type;
		platforms = new ArrayList<>();
	}

	public String getType() 
	{
		return type;
	}
	
	public void setType(String type) 
	{
		this.type = type;
	}
	
	public List<String> getPlatforms() 
	{
		return platforms;
	}
	
	public void setPlatforms(List<String> platforms) 
	{
		this.platforms = platforms;
	}
	
	public void addPlatform(String platform)
	{
		this.platforms.add(platform);
	}
	
	
}
