package com.gildedrose.updator;

import static com.gildedrose.util.ItemDataUtils.decrementSellIn;

import com.gildedrose.item.Item;

public class ConjuredItemUpdator extends AbstractItemUpdator {

	@Override
	public  void updateQuality(Item item) {
		if (item.getQuality() > 0) {
			item.setQuality(item.getQuality() - 2);
		}
		decrementSellIn(item);
	}
}
