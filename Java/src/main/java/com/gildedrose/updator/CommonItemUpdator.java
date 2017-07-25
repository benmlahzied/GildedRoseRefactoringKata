package com.gildedrose.updator;

import static com.gildedrose.util.ItemDataUtils.decrementQuality;
import static com.gildedrose.util.ItemDataUtils.decrementSellIn;

import com.gildedrose.item.Item;

public class CommonItemUpdator extends AbstractItemUpdator {

	@Override
	public  void updateQuality(Item item) {
		if (item.getQuality() > 0) {
			decrementQuality(item);
		}
		decrementSellIn(item);
		if (item.hasExpired()) {
			if (item.getQuality() > 0) {
				decrementQuality(item);
			}
		}
	}
}
