package com.gildedrose;

public class CommonItem extends Item {

	public CommonItem(int sellIn, int quality) {
		super(sellIn, quality);
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
