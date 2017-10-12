package com.seymourbeta;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.seymourbeta.math.Complex;
import com.seymourbeta.math.Fractal;
import com.seymourbeta.math.FractalAlgorithm;
import com.seymourbeta.math.MandelbrotFractal;
import com.seymourbeta.util.Range;

public class Main {
	
	public static final double X_START_RANGE = -2.0;
	public static final double X_END_RANGE = 2.0;
	public static final double Y_START_RANGE = -2.0;
	public static final double Y_END_RANGE = 2.0;
	public static final int MAX_ITERATIONS = 10000;
	
	
	public static int applyMandelbrot(Complex c, int maxIterations) {
		Complex z = new Complex(c);
		int numIterations = 1;
		while(z.magnitude2() < 4 && numIterations < maxIterations) {
			z = Complex.mul(z, z);
			z = Complex.add(z, c);
			numIterations = numIterations + 1;
		}
		
		return numIterations;
	}

	public static void main(String[] args) {
		
		int width = 500;
		int height = 500;
		int imageType = BufferedImage.TYPE_INT_RGB;
		BufferedImage bi = new BufferedImage(width, height, imageType);
		/*****/
		
		Range xRange = new Range(0, bi.getWidth());
		Range yRange = new Range(0, bi.getHeight());
		Range xNewRange = new Range(X_START_RANGE, X_END_RANGE);
		Range yNewRange = new Range(Y_START_RANGE, Y_END_RANGE);
		
		for(int y = 0; y < bi.getHeight(); y++) {
			for(int x = 0; x < bi.getWidth(); x++) {				
				double xNew = Range.toRange(x, xRange, xNewRange);
				double yNew = Range.toRange(y, yRange, yNewRange);
//				int numIterations = applyMandelbrot(new Complex(xNew, yNew), MAX_ITERATIONS);
				Fractal mandelbrot = new MandelbrotFractal(new Complex(xNew, yNew));
				FractalAlgorithm algorithm = new FractalAlgorithm(mandelbrot);
				int numIterations = algorithm.iterate(new Complex(0.0, 0.0), (Complex z, Integer nIter) -> {
					return z.magnitude2() >= 4 || nIter >= MAX_ITERATIONS;
				});
				bi.setRGB(x, y, MAX_ITERATIONS - numIterations);
			}
		}
		
		/*****/
		try {
			ImageIO.write(bi, "PNG", new File("fractal.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
