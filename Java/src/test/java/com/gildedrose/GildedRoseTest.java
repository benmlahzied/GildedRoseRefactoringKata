package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GildedRoseTest {
    
    @Test
    public void should_quality_increases_when_aged_brie_gets_older() {
    	Item[] items = new Item[] { new Item("Aged Brie", 2, 49), new Item("Aged Brie", -1, 10)};
    	GildedRose app = updateQuality(items);
    	assertThat(app.items[0].quality).isEqualTo(50);
    	assertThat(app.items[0].sellIn).isEqualTo(1);
    	
    	assertThat(app.items[1].quality).isEqualTo(12);
    	assertThat(app.items[1].sellIn).isEqualTo(-2);
    }
    
    @Test
    public void should_quality_increases_when_backstage_passes_gets_older() {
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
    	GildedRose app = updateQuality(items);
    	assertThat(app.items[0].quality).isEqualTo(21);
    	assertThat(app.items[0].sellIn).isEqualTo(14);
    }
    
    @Test
    public void should_quality_increases_by_2_when_there_are_10_days_or_less_to_sell_backstage_passes() {
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50) };
    	GildedRose app = updateQuality(items);
    	assertThat(app.items[0].quality).isEqualTo(22);
    	assertThat(app.items[1].quality).isEqualTo(50);
    }
    
    @Test
    public void should_quality_increases_by_3_when_there_are_5_days_or_less_to_sell_backstage_passes() {
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10) };
    	GildedRose app = updateQuality(items);
    	assertThat(app.items[0].quality).isEqualTo(23);
    	assertThat(app.items[1].quality).isEqualTo(13);
    }
    
    @Test
    public void should_quality_drops_to_0_after_the_concert_of_backstage_passes() {
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
    	GildedRose app = updateQuality(items);
    	assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    public void should_not_quality_decreases_when_item_is_sulfuras() {
    	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80), new Item("Sulfuras, Hand of Ragnaros", -1, 10)};
    	GildedRose app = updateQuality(items);
    	assertThat(app.items[0].quality).isEqualTo(80);
    	assertThat(app.items[1].quality).isEqualTo(10);
    }
    
    @Test
    public void should_item_never_be_sold_when_item_is_sulfuras() {
    	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 2, 80)};
    	GildedRose app = updateQuality(items);
    	assertThat(app.items[0].sellIn).isEqualTo(2);
    }
    
    @Test
    public void should_quality_decreases_when_dexterity_vest_gets_older() {
		Item[] items = new Item[] { new Item("5 Dexterity Vest", 15, 20)};
    	GildedRose app = updateQuality(items);
        assertEquals(19, app.items[0].quality);
        assertEquals(14, app.items[0].sellIn);
    }
    
    @Test
    public void should_quality_decreases_twice_as_fast_when_dexterity_vest_sell_by_date_has_passed () {
    	Item[] items = new Item[] { new Item("5 Dexterity Vest", 0, 5)};
    	GildedRose app = updateQuality(items);
    	assertThat(app.items[0].quality).isEqualTo(3);
    }
    
    @Test
    public void should_not_quality_decreases_when_dexterity_vest_sell_in_is_less_than__0() {
		Item[] items = new Item[] { new Item("5 Dexterity Vest", -1, -7)};
    	GildedRose app = updateQuality(items);
    	
    	assertThat(app.items[0].quality).isEqualTo(-7);
    	assertThat(app.items[0].sellIn).isEqualTo(-2);
    }
    
    @Test
    public void should_quality_decreases_when_elixir_of_the_mongoose_gets_older() {
    	Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7)};
    	GildedRose app = updateQuality(items);
    	assertThat(app.items[0].quality).isEqualTo(6);
    	assertThat(app.items[0].sellIn).isEqualTo(4);
    }
    
    @Test
    public void should_quality_decreases_twice_as_fast_when_elixir_of_the_mongoose_sell_by_date_has_passed () {
    	Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 7)};
    	GildedRose app = updateQuality(items);
    	assertThat(app.items[0].quality).isEqualTo(5);
    }
    
    @Test
    public void should_not_quality_decreases_when_elixir_of_the_mongoose_sell_in_is_less_than__0() {
		Item[] items = new Item[] { new Item("Elixir of the Mongoose", -1, -7)};
    	GildedRose app = updateQuality(items);
    	
    	assertThat(app.items[0].quality).isEqualTo(-7);
    	assertThat(app.items[0].sellIn).isEqualTo(-2);
    }
    
    @Test
    public void should_not_quality_be_negative () {
    	Item[] items = new Item[] { new Item("5 Dexterity Vest", 2, 0)};
    	GildedRose app = updateQuality(items);
    	assertThat(app.items[0].quality).isEqualTo(0);
    }
    
    @Test
    public void should_not_quality_exceeds_50 () {
		Item[] items = new Item[] { new Item("Aged Brie", 2, 50),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new Item("Aged Brie", -1, 50),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
    	GildedRose app = updateQuality(items);
    	assertThat(app.items[0].quality).isEqualTo(50);
    	assertThat(app.items[1].quality).isEqualTo(50);
    	assertThat(app.items[2].quality).isEqualTo(50);
    	assertThat(app.items[3].quality).isEqualTo(50);
    }
    
    private GildedRose updateQuality(Item[] items) {
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	return app;
    }
}
