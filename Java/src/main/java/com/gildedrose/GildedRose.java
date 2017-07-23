package com.gildedrose;

class GildedRose {

	private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final int MAXIMUM_QUALITY = 50;

	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			updateItemQuality(item);
		}
	}

	private void updateItemQuality(Item item) {
		String name = item.getName();
		if (name.equals(AGED_BRIE)) {
			updateAgedBrieQuality(item);
		} else if (name.equals(BACKSTAGE)) {
			updateBackstagePassesQuality(item);
		} else if (!name.equals(SULFURAS)) {
			updateCommonItemsQuality(item);
		}
	}
	
	private void updateAgedBrieQuality(Item item) {
		if (hasQualityLessThenMax(item)) {
			item.incrementQuality();
		}
		item.decrementSellIn();
		if (item.hasExpired()) {
			if (hasQualityLessThenMax(item)) {
				item.incrementQuality();
			}
		}
	}

	private void updateBackstagePassesQuality(Item item) {
		if (hasQualityLessThenMax(item)) {
			item.incrementQuality();
			if (item.getSellIn() < 11) {
				if (hasQualityLessThenMax(item)) {
					item.incrementQuality();
				}
			}
			
			if (item.getSellIn() < 6) {
				if (hasQualityLessThenMax(item)) {
					item.incrementQuality();
				}
			}
		}
		item.decrementSellIn();
		if (item.hasExpired()) {
			item.setQuality(0);
		}
	}
	
	private void updateCommonItemsQuality(Item item) {
		if (item.getQuality() > 0) {
			item.decrementQuality();
		}
		item.decrementSellIn();
		if (item.hasExpired()) {
			if (item.getQuality() > 0) {
				item.decrementQuality();
			}
		}
	}

	private boolean hasQualityLessThenMax(Item item) {
		return item.getQuality() < MAXIMUM_QUALITY;
	}
}