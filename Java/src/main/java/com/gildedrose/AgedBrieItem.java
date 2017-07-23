package com.gildedrose;

public class AgedBrieItem extends Item {

	public AgedBrieItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	@Override
	void updateQuality() {
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
