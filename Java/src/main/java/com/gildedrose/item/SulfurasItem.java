package com.gildedrose.item;

public class SulfurasItem extends Item {

	public SulfurasItem(int sellIn, int quality) {
		super(sellIn, quality);
	}

	/** 
	 * "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
	 */
	@Override
	public  void updateQuality() {
	}
}