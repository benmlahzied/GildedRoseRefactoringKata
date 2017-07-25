package com.gildedrose.item;

import static com.gildedrose.util.ItemDataUtils.decrementSellIn;

public class ConjuredItem extends Item {

	public ConjuredItem(int sellIn, int quality) {
		super(sellIn, quality);
	}

	@Override
	public  void updateQuality() {
		if (getQuality() > 0) {
			setQuality(getQuality() - 2);
		}
		decrementSellIn(this);
	}
}