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
		if (item.getName().equals(AGED_BRIE) || item.getName().equals(BACKSTAGE)) {
			if (hasQualityLessThenMax(item)) {
				item.incrementQuality();

				if (item.getName().equals(BACKSTAGE)) {
					updateBackstageQuality(item);
				}
			}
		} else if (item.getQuality() > 0 && !item.getName().equals(SULFURAS)) {
				item.decrementQuality();
		}

		if (!item.getName().equals(SULFURAS)) {
			item.decrementSellIn();
		}

		if (item.hasExpired()) {
			if (item.getName().equals(AGED_BRIE)) {
				if (hasQualityLessThenMax(item)) {
					item.incrementQuality();
				}
			} else if (item.getName().equals(BACKSTAGE)) {
				item.setQuality(0);
			} else if (item.getQuality() > 0 && !item.getName().equals(SULFURAS)) {
				item.decrementQuality();
			}
		}
	}

	private void updateBackstageQuality(Item item) {
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

	private boolean hasQualityLessThenMax(Item item) {
		return item.getQuality() < MAXIMUM_QUALITY;
	}
}