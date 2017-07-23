package com.gildedrose;

public class CommonItem extends Item {

	public CommonItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	void updateQuality() {
		if (getQuality() > 0) {
			decrementQuality();
		}
		decrementSellIn();
		if (hasExpired()) {
			if (getQuality() > 0) {
				decrementQuality();
			}
		}
	}
	
	

}
