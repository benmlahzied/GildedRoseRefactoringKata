package com.gildedrose.item;

public class ConjuredItem extends Item {

	public ConjuredItem(int sellIn, int quality) {
		super(sellIn, quality);
	}

	@Override
	public  void updateQuality() {
		if (getQuality() > 0) {
			setQuality(getQuality() - 2);
		}
		decrementSellIn();
	}
}