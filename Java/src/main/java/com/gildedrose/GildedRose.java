package com.gildedrose;

import com.gildedrose.item.Item;
import com.gildedrose.updator.AbstractItemUpdator;
import com.gildedrose.updator.ItemUpdators;

class GildedRose {
	
	Item[] items;
	
	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			AbstractItemUpdator itemUpdator = ItemUpdators.valueOf(item.getClass().getSimpleName()).getItemUpdator();
			if (itemUpdator != null) {
				itemUpdator.updateQuality(item);				
			}
		}
	}
}