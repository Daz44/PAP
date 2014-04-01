package com.mallen.pap.physics;

import com.mallen.pap.console.IO;

public class CalcMass {
	private double acel, force;
	public void printMass(){
		IO.println("> Mass: " + force/acel);
	}
	public void set(double a, double f){
		acel = a;
		force = f;
	}
}
