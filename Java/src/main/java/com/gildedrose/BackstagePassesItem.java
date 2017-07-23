package com.gildedrose;

public class BackstagePassesItem extends Item {

	public BackstagePassesItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	void updateQuality() {
		if (hasQualityLessThenMax()) {
			incrementQuality();
			if (getSellIn() < 11) {
				if (hasQualityLessThenMax()) {
					incrementQuality();
				}
			}
			
			if (getSellIn() < 6) {
				if (hasQualityLessThenMax()) {
					incrementQuality();
				}
			}
		}
		decrementSellIn();
		if (hasExpired()) {
			setQuality(0);
		}
	}

}
