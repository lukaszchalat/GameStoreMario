package com.game.store.mario.kinga.zubik;

import java.math.BigDecimal;

public class ComputationService 
{
	public static BigDecimal computePriceForProduct(Game game, Integer amount)
	{
		return BigDecimal.valueOf(amount).multiply(BigDecimal.valueOf(game.getPrice()));
	}
}
