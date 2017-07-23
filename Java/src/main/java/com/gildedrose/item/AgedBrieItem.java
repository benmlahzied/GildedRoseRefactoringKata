package com.gildedrose.item;

public class AgedBrieItem extends Item {

	public AgedBrieItem(int sellIn, int quality) {
		super(sellIn, quality);
	}
	
	@Override
	public void updateQuality() {
		if (hasQualityLessThenMax()) {
			incrementQuality();
		}
		decrementSellIn();
		if (hasExpired()) {
			if (hasQualityLessThenMax()) {
				incrementQuality();
			}
		}
	}
}
