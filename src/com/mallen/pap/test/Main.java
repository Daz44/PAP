package com.mallen.pap.test;

import java.text.DecimalFormat;

import com.mallen.pap.console.Console;
import com.mallen.pap.physics.threads.CalcPhys;

public class Main {
	public static void main(String[] args){
		
		Console.initHeader();	
		Console.waitandparse();
	
		//(new Thread(new CalcPhys(0, 1000, 1000, 0, 60))).start();
	}
}
