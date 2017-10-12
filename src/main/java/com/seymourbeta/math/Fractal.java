package com.seymourbeta.math;
import com.seymourbeta.math.Complex;

public abstract class Fractal {

	protected Complex c;

	public Fractal() {
		c = new Complex(0.0, 0.0);
	}

	public Fractal(Complex c) {
		super();
		this.c = c;
	}

	public Complex getC() {
		return c;
	}

	public void setC(Complex c) {
		this.c = c;
	}

	public abstract Complex compute(Complex z);

}
