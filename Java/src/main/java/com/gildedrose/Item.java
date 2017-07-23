package com.gildedrose;

public class Item {

	private String name;
	private int sellIn;
	private int quality;

	public Item(String name, int sellIn, int quality) {
		this.name = name;
		this.setSellIn(sellIn);
		this.setQuality(quality);
	}

	@Override
	public String toString() {
		return this.getName() + ", " + this.getSellIn() + ", " + this.getQuality();
	}

	public String getName() {
		return name;
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

	boolean hasExpired() {
		return getSellIn() < 0;
	}

	void decrementQuality() {
		setQuality(getQuality() - 1);
	}

	void decrementSellIn() {
		setSellIn(getSellIn() - 1);
	}

	void incrementQuality() {
		setQuality(getQuality() + 1);
	}
}
