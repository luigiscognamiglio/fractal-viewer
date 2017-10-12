package com.seymourbeta.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.seymourbeta.util.Range;

@RunWith(JUnit4.class)
public class RangeTests {

	@Test
	public void inRangeWithPositiveValuesTest() {
		double start = 2;
		double end = 5;
		Range range = new Range(start, end);

		Assert.assertTrue(Range.inRange(start, range));
		Assert.assertTrue(Range.inRange(end, range));

		double[] values = { 3, 3.5, 4, 4.5 };
		for (int i = 0; i < values.length; i++)
			Assert.assertTrue(Range.inRange(values[i], range));
	}

	@Test
	public void inRangeWithNegativeValuesTest() {
		double start = -5;
		double end = -2;
		Range range = new Range(start, end);

		Assert.assertTrue(Range.inRange(start, range));
		Assert.assertTrue(Range.inRange(end, range));

		double[] values = { -4.8, -4.5, -4.0, -3.0, -2.5, -2.1 };
		for (int i = 0; i < values.length; i++)
			Assert.assertTrue(Range.inRange(values[i], range));
	}

	@Test
	public void inRangeWithNegativeStartValueAndPositiveEndValue() {
		double start = -5;
		double end = 2;
		Range range = new Range(start, end);

		Assert.assertTrue(Range.inRange(start, range));
		Assert.assertTrue(Range.inRange(end, range));

		double[] values = { -4.8, -4.5, -4.0, -3.0, -2.5, -2.1, -2.0, -1.0, -0.6, -0.4, 0.0, 0.6, 0.9, 1.2, 1.8, 1.9999};
		for (int i = 0; i < values.length; i++)
			Assert.assertTrue(Range.inRange(values[i], range));
	}
	
	@Test
	public void inRangeWithOutOfRangeValuesTest() {
		double start = 7;
		double end = 17;
		Range range = new Range(start, end);

		Assert.assertFalse(Range.inRange(start-0.1, range));
		Assert.assertFalse(Range.inRange(end+0.1, range));
		
		double[] values = {1, 2, 3, 4, 5, 6, 18, 19, 20};
		for (int i = 0; i < values.length; i++)
			Assert.assertFalse(Range.inRange(values[i], range));
	}
}
