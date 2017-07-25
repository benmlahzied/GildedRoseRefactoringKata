package com.gildedrose.item;

import static com.gildedrose.util.ItemDataUtils.decrementSellIn;
import static com.gildedrose.util.ItemDataUtils.incrementQuality;

public class AgedBrieItem extends Item {

	public AgedBrieItem(int sellIn, int quality) {
		super(sellIn, quality);
	}
	
	@Override
	public void updateQuality() {
		if (hasQualityLessThenMax()) {
			incrementQuality(this);
		}
		decrementSellIn(this);
		if (hasExpired()) {
			if (hasQualityLessThenMax()) {
				incrementQuality(this);
			}
		}
	}
}
