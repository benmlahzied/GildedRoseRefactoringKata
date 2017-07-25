package com.gildedrose.updator;

import static com.gildedrose.util.ItemDataUtils.decrementSellIn;
import static com.gildedrose.util.ItemDataUtils.incrementQuality;

import com.gildedrose.item.Item;

public class AgedBrieItemUpdator extends AbstractItemUpdator {

	@Override
	public void updateQuality(Item item) {
		if (item.hasQualityLessThenMax()) {
			incrementQuality(item);
		}
		decrementSellIn(item);
		if (item.hasExpired()) {
			if (item.hasQualityLessThenMax()) {
				incrementQuality(item);
			}
		}
	}
}
