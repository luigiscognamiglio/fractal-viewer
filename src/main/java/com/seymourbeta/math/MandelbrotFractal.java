package com.seymourbeta.math;
import com.seymourbeta.math.Complex;

public class MandelbrotFractal extends Fractal {

	public MandelbrotFractal() {
		super();
	}

	public MandelbrotFractal(Complex c) {
		super(c);
	}

	@Override
	public Complex compute(Complex z) {
		Complex result = Complex.mul(z, z);
		result = Complex.add(result, this.c);
		return result;
	}

}
