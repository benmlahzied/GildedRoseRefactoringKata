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
		if (item.name.equals(AGED_BRIE) || item.name.equals(BACKSTAGE)) {
			if (hasQualityLessThenMax(item)) {
				incrementQuality(item);

				if (item.name.equals(BACKSTAGE)) {
					updateBackstageQuality(item);
				}
			}
		} else {
			if (item.quality > 0 && !item.name.equals(SULFURAS)) {
				decrementQuality(item);
			}
		}

		if (!item.name.equals(SULFURAS)) {
			decrementSellIn(item);
		}

		if (hasExpired(item)) {
			if (item.name.equals(AGED_BRIE)) {
				if (hasQualityLessThenMax(item)) {
					incrementQuality(item);
				}
			} else if (item.name.equals(BACKSTAGE)) {
				item.quality = 0;
			} else if (item.quality > 0 && !item.name.equals(SULFURAS)) {
				decrementQuality(item);
			}
		}
	}

	private boolean hasExpired(Item item) {
		return item.sellIn < 0;
	}

	private void updateBackstageQuality(Item item) {
		if (item.sellIn < 11) {
			if (hasQualityLessThenMax(item)) {
				incrementQuality(item);
			}
		}

		if (item.sellIn < 6) {
			if (hasQualityLessThenMax(item)) {
				incrementQuality(item);
			}
		}
	}

	private int decrementQuality(Item item) {
		return item.quality = item.quality - 1;
	}

	private int decrementSellIn(Item item) {
		return item.sellIn = item.sellIn - 1;
	}

	private int incrementQuality(Item item) {
		return item.quality = item.quality + 1;
	}

	private boolean hasQualityLessThenMax(Item item) {
		return item.quality < MAXIMUM_QUALITY;
	}
}