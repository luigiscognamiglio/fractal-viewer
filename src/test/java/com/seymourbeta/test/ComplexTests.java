package com.seymourbeta.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.seymourbeta.math.Complex;

@RunWith(JUnit4.class)
public class ComplexTests {

	@Test
	public void magnitudeTest() {

		double delta = 10e-2;

		Complex[] cArr = { new Complex(2, 2), new Complex(3, 4), new Complex(4, 5) };

		double[] expected = { 2.82, 5.0, 6.40 };

		for (int i = 0; i < cArr.length; i++)
			Assert.assertEquals(expected[i], cArr[i].magnitude(), delta);
	}

	@Test
	public void magnitude2Test() {
		double delta = 10e-2;

		Complex[] cArr = { new Complex(1, 2), new Complex(2, 4), new Complex(4, 8), };

		double[] expected = { 5.0, 20.0, 80.0 };

		for (int i = 0; i < cArr.length; i++)
			Assert.assertEquals(expected[i], cArr[i].magnitude2(), delta);
	}

	@Test
	public void conjTest() {
		double delta = 0.0;
		Complex c = new Complex(3.0, 4.0);
		Complex conj = Complex.conj(c);
		Assert.assertEquals(3.0, conj.getReal(), delta);
		Assert.assertEquals(-4.0, conj.getImag(), delta);
	}

	@Test
	public void addTest() {
		
	}

	@Test
	public void mulTest() {

	}
}
