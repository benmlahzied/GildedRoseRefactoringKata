package com.gildedrose.updator;

import static com.gildedrose.util.ItemDataUtils.decrementSellIn;
import static com.gildedrose.util.ItemDataUtils.incrementQuality;

import com.gildedrose.item.Item;

public class BackstagePassesItemUpdator extends AbstractItemUpdator {
	
	@Override
	public void updateQuality(Item item) {
		if (item.hasQualityLessThenMax()) {
			incrementQuality(item);
			if (item.getSellIn() < 11) {
				if (item.hasQualityLessThenMax()) {
					incrementQuality(item);
				}
			}
			
			if (item.getSellIn() < 6) {
				if (item.hasQualityLessThenMax()) {
					incrementQuality(item);
				}
			}
		}
		decrementSellIn(item);
		if (item.hasExpired()) {
			item.setQuality(0);
		}
	}
}
