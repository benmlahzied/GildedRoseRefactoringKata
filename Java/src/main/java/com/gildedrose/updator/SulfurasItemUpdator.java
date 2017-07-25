package com.gildedrose.updator;

import com.gildedrose.item.Item;

public class SulfurasItemUpdator  extends AbstractItemUpdator {

	/** 
	 * "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
	 */
	@Override
	public  void updateQuality(Item item) {
	}
}
