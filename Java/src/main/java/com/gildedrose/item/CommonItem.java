package com.gildedrose.item;

import static com.gildedrose.util.ItemDataUtils.decrementQuality;
import static com.gildedrose.util.ItemDataUtils.decrementSellIn;

public class CommonItem extends Item {

	public CommonItem(int sellIn, int quality) {
		super(sellIn, quality);
	}

	@Override
	public  void updateQuality() {
		if (getQuality() > 0) {
			decrementQuality(this);
		}
		decrementSellIn(this);
		if (hasExpired()) {
			if (getQuality() > 0) {
				decrementQuality(this);
			}
		}
	}
}