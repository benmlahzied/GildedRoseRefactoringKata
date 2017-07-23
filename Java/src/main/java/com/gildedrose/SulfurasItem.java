package com.gildedrose;

public class SulfurasItem extends Item {

	public SulfurasItem(int sellIn, int quality) {
		super(sellIn, quality);
	}

	@Override
	void updateQuality() {
		// nothing to do
	}
}