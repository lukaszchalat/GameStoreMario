package com.game.store.mario.kinga.zubik;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart 
{
	private Map<Game, Integer> productToAmountMapping;
	
	public ShoppingCart()
	{
		productToAmountMapping = new LinkedHashMap<>();
	}
	
	public boolean isEmpty()
	{
		return this.productToAmountMapping.isEmpty();
	}
	
	public void addProduct(Game game)
	{
		this.productToAmountMapping.computeIfPresent(game, (k, v) -> v = v + 1);
		this.productToAmountMapping.computeIfAbsent(game, v -> 1);
	}
	
	public Map<Game, Integer> getContent()
	{
		return this.productToAmountMapping;
	}
	
	public BigDecimal getSum()
	{
		return productToAmountMapping.entrySet().stream()
                                                .map( entry -> ComputationService.computePriceForProduct( entry.getKey(), entry.getValue() ) )
                                                .reduce( BigDecimal.ZERO, BigDecimal::add );
	}
}
