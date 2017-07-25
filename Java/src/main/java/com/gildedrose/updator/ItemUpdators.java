package com.gildedrose.updator;

/**
 * Enum used to switch between quality update strategies.
 */
public enum ItemUpdators {
	
	SulfurasItem(new SulfurasItemUpdator()),
	AgedBrieItem(new AgedBrieItemUpdator()),
	ConjuredItem(new ConjuredItemUpdator()),
	CommonItem(new CommonItemUpdator()),
	BackstagePassesItem(new BackstagePassesItemUpdator());
	
	AbstractItemUpdator itemUpdator;
	
	public AbstractItemUpdator getItemUpdator() {
		return itemUpdator;
	}

	private ItemUpdators(AbstractItemUpdator itemUpdator){
		this.itemUpdator = itemUpdator;
	}	
}
