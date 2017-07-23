package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gildedrose.item.AgedBrieItem;
import com.gildedrose.item.BackstagePassesItem;
import com.gildedrose.item.CommonItem;
import com.gildedrose.item.ConjuredItem;
import com.gildedrose.item.Item;
import com.gildedrose.item.SulfurasItem;

public class GildedRoseTest {

	@Test
	public void should_quality_increases_when_aged_brie_gets_older() {
		Item[] items = new Item[] { new AgedBrieItem(2, 49), new AgedBrieItem(-1, 10) };
		GildedRose app = updateQuality(items);
		assertThat(app.items[0].getQuality()).isEqualTo(50);
		assertThat(app.items[0].getSellIn()).isEqualTo(1);

		assertThat(app.items[1].getQuality()).isEqualTo(12);
		assertThat(app.items[1].getSellIn()).isEqualTo(-2);
	}

	@Test
	public void should_quality_increases_when_backstage_passes_gets_older() {
		Item[] items = new Item[] { new BackstagePassesItem(15, 20) };
		GildedRose app = updateQuality(items);
		assertThat(app.items[0].getQuality()).isEqualTo(21);
		assertThat(app.items[0].getSellIn()).isEqualTo(14);
	}

	@Test
	public void should_quality_increases_by_2_when_there_are_10_days_or_less_to_sell_backstage_passes() {
		Item[] items = new Item[] { new BackstagePassesItem(10, 20),
				new BackstagePassesItem(10, 50) };
		GildedRose app = updateQuality(items);
		assertThat(app.items[0].getQuality()).isEqualTo(22);
		assertThat(app.items[1].getQuality()).isEqualTo(50);
	}

	@Test
	public void should_quality_increases_by_3_when_there_are_5_days_or_less_to_sell_backstage_passes() {
		Item[] items = new Item[] { new BackstagePassesItem(5, 20), new BackstagePassesItem(1, 10) };
		GildedRose app = updateQuality(items);
		assertThat(app.items[0].getQuality()).isEqualTo(23);
		assertThat(app.items[1].getQuality()).isEqualTo(13);
	}

	@Test
	public void should_quality_drops_to_0_after_the_concert_of_backstage_passes() {
		Item[] items = new Item[] { new BackstagePassesItem(0, 20) };
		GildedRose app = updateQuality(items);
		assertThat(app.items[0].getQuality()).isEqualTo(0);
	}

	@Test
	public void should_not_quality_decreases_when_item_is_sulfuras() {
		Item[] items = new Item[] { new SulfurasItem(0, 80),
				new SulfurasItem(-1, 10) };
		GildedRose app = updateQuality(items);
		assertThat(app.items[0].getQuality()).isEqualTo(80);
		assertThat(app.items[1].getQuality()).isEqualTo(10);
	}

	@Test
	public void should_item_never_be_sold_when_item_is_sulfuras() {
		Item[] items = new Item[] { new SulfurasItem(2, 80) };
		GildedRose app = updateQuality(items);
		assertThat(app.items[0].getSellIn()).isEqualTo(2);
	}

	@Test
	public void should_quality_decreases_when_common_item_gets_older() {
		Item[] items = new Item[] { new CommonItem(15, 20) };
		GildedRose app = updateQuality(items);
		assertEquals(19, app.items[0].getQuality());
		assertEquals(14, app.items[0].getSellIn());
	}

	@Test
	public void should_quality_decreases_twice_as_fast_when_common_item_sell_by_date_has_passed() {
		Item[] items = new Item[] { new CommonItem(0, 5) };
		GildedRose app = updateQuality(items);
		assertThat(app.items[0].getQuality()).isEqualTo(3);
	}

	@Test
	public void should_not_quality_decreases_when_common_item_sell_in_is_less_than__0() {
		Item[] items = new Item[] { new CommonItem(-1, -7) };
		GildedRose app = updateQuality(items);

		assertThat(app.items[0].getQuality()).isEqualTo(-7);
		assertThat(app.items[0].getSellIn()).isEqualTo(-2);
	}
	
	@Test
	public void should_not_quality_be_negative() {
		Item[] items = new Item[] { new CommonItem(2, 0) , new ConjuredItem(10, 0)};
		GildedRose app = updateQuality(items);
		assertThat(app.items[0].getQuality()).isEqualTo(0);
		assertThat(app.items[1].getQuality()).isEqualTo(0);
	}

	@Test
	public void should_not_quality_exceeds_50() {
		Item[] items = new Item[] { new AgedBrieItem(2, 50),
				new BackstagePassesItem(10, 49),
				new AgedBrieItem(-1, 50),
				new BackstagePassesItem(5, 49) };
		GildedRose app = updateQuality(items);
		assertThat(app.items[0].getQuality()).isEqualTo(50);
		assertThat(app.items[1].getQuality()).isEqualTo(50);
		assertThat(app.items[2].getQuality()).isEqualTo(50);
		assertThat(app.items[3].getQuality()).isEqualTo(50);
	}
	
	@Test
	public void should_conjured_items_quality_decreases_twice_as_fast_as_normal_items(){
		Item[] items = new Item[] { new ConjuredItem(10, 5) };
		GildedRose app = updateQuality(items);
		assertThat(app.items[0].getQuality()).isEqualTo(3);
	}

	private GildedRose updateQuality(Item[] items) {
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		return app;
	}
}
