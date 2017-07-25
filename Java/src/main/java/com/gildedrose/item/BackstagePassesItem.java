package com.gildedrose.item;

import static com.gildedrose.util.ItemDataUtils.decrementSellIn;
import static com.gildedrose.util.ItemDataUtils.incrementQuality;

public class BackstagePassesItem extends Item {

	public BackstagePassesItem(int sellIn, int quality) {
		super(sellIn, quality);
	}

	@Override
	public void updateQuality() {
		if (hasQualityLessThenMax()) {
			incrementQuality(this);
			if (getSellIn() < 11) {
				if (hasQualityLessThenMax()) {
					incrementQuality(this);
				}
			}
			
			if (getSellIn() < 6) {
				if (hasQualityLessThenMax()) {
					incrementQuality(this);
				}
			}
		}
		decrementSellIn(this);
		if (hasExpired()) {
			setQuality(0);
		}
	}

}
