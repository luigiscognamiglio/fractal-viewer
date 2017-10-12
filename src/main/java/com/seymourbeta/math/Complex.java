package com.seymourbeta.math;

public class Complex {

	private double real;
	private double imag;

	public Complex() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Complex(double real, double imag) {
		super();
		this.real = real;
		this.imag = imag;
	}
	
	public Complex(Complex c) {
		super();
		this.real = c.real;
		this.imag = c.imag;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}
	
	public double magnitude() {
		return Math.sqrt(this.real * this.real + this.imag * this.imag);
	}
	
	public double magnitude2() {
		return this.real * this.real + this.imag * this.imag;
	}

	public static Complex add(Complex a, Complex b) {
		return new Complex(a.real + b.real, a.imag + b.imag);
	}

	public static Complex mul(Complex a, Complex b) {
		return new Complex(a.real * b.real - a.imag * b.imag, a.imag * b.real + a.real * b.imag);
	}
	
	public static Complex conj(Complex c) {
		return new Complex(c.real, -c.imag);
	}
}
