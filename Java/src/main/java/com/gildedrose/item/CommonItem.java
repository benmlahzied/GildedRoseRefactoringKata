package com.gildedrose.item;

public class CommonItem extends Item {

	public CommonItem(int sellIn, int quality) {
		super(sellIn, quality);
	}

	@Override
	public  void updateQuality() {
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
