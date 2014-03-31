package com.mallen.pap.physics;

import java.text.DecimalFormat;

public class CalcAcel {
	 double mass, force;
	public  void printAcel(){
		DecimalFormat df = new DecimalFormat("#.000");
		System.out.println("Acel: " + df.format((force/mass)) + "m/s/s");
	}
	public  void set(double f, double m){
		mass = m;
		force = f;
	}
}
