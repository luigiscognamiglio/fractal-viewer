package com.seymourbeta.util;

public class Range {

	private double start;
	private double end;

	public Range() {
		super();
	}

	public Range(double start, double end) {
		super();
		this.start = start;
		this.end = end;
	}

	public double getStart() {
		return start;
	}

	public void setStart(double start) {
		this.start = start;
	}

	public double getEnd() {
		return end;
	}

	public void setEnd(double end) {
		this.end = end;
	}

	public static boolean inRange(double val, Range range) {
		return (val >= range.start) && (val <= range.end);
	}

	public static double toRange(double val, Range source, Range target) {
		return target.start
				+ ((val - source.start) / (Math.abs(source.end - source.start))) * Math.abs(target.end - target.start);
	}

	public static double toRange(double val, double sourceStart, double sourceEnd, double targetStart,
			double targetEnd) {
		return Range.toRange(val, new Range(sourceStart, sourceEnd), new Range(targetStart, targetEnd));
	}

}
