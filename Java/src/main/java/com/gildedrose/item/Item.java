package com.gildedrose.item;

public abstract class Item {

	private int sellIn;
	private int quality;
	
	private static final int DEFAULT_MAXIMUM_QUALITY = 50;

	public Item(int sellIn, int quality) {
		this.setSellIn(sellIn);
		this.setQuality(quality);
	}

	@Override
	public String toString() {
		return this.getSellIn() + ", " + this.getQuality();
	}

	public int getSellIn() {
		return sellIn;
	}

	public int setSellIn(int sellIn) {
		this.sellIn = sellIn;
		return sellIn;
	}

	public int getQuality() {
		return quality;
	}

	public int setQuality(int quality) {
		this.quality = quality;
		return quality;
	}

	public boolean hasExpired() {
		return getSellIn() < 0;
	}

	public boolean hasQualityLessThenMax() {
		return getQuality() < DEFAULT_MAXIMUM_QUALITY;
	}
}
