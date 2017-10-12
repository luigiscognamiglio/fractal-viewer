package com.seymourbeta.math;
import java.util.function.BiPredicate;

import com.seymourbeta.math.Complex;

public class FractalAlgorithm {

	private Fractal fractal;

	public FractalAlgorithm() {
		super();
	}

	public FractalAlgorithm(Fractal fractal) {
		super();
		this.fractal = fractal;
	}

	public Fractal getFractal() {
		return fractal;
	}

	public void setFractal(Fractal fractal) {
		this.fractal = fractal;
	}
	
	public int iterate(Complex startZ, BiPredicate<Complex, Integer> stopCondition) {
		int numIterations = 1;
		Complex result = fractal.compute(startZ);
		
		while(!stopCondition.test(result, numIterations)) {
			result = fractal.compute(result);
			numIterations++;
		}
		return numIterations;
	}
}
