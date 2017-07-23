package com.gildedrose;

public abstract class Item {

	private int sellIn;
	private int quality;
	
	static final int DEFAULT_MAXIMUM_QUALITY = 50;

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

	protected boolean hasExpired() {
		return getSellIn() < 0;
	}

	protected void decrementQuality() {
		setQuality(getQuality() - 1);
	}

	protected void decrementSellIn() {
		setSellIn(getSellIn() - 1);
	}

	protected void incrementQuality() {
		setQuality(getQuality() + 1);
	}

	abstract void updateQuality();

	protected boolean hasQualityLessThenMax() {
		return getQuality() < DEFAULT_MAXIMUM_QUALITY;
	}
}
