package com.game.store.mario.kinga.zubik;

public enum OptionEnum 
{
	ALL_GAMES("W"),
	ONLY_COMPUTER_GAMES("K"),
	ONLY_CARD_GAMES("A"),
	ONLY_BOARD_GAMES("P"),
	CLOSE("Z");
	
	private String option;
	
	private OptionEnum(String option)
	{
		this.option = option;
	}
	
	public String getOption()
	{
		return this.option;
	}
	
	public String toString()
	{
		return this.option;
	}
}
