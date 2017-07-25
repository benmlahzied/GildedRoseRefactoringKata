package com.gildedrose.util;

import com.gildedrose.item.Item;

public final class ItemDataUtils {
	
	private ItemDataUtils(){
	}

	public static void decrementQuality(Item item) {
		item.setQuality(item.getQuality() - 1);
	}
	
	public static void decrementSellIn(Item item) {
		item.setSellIn(item.getSellIn() - 1);
	}
	
	public static void incrementQuality(Item item) {
		item.setQuality(item.getQuality() + 1);
	}	
}