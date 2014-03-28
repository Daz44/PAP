package com.mallen.pap.test;

import java.text.DecimalFormat;

import com.mallen.pap.console.Commands;
import com.mallen.pap.console.IO;
import com.mallen.pap.physics.CalcSpeed;

public class Main {
	public static void main(String[] args){
		
		IO.initHeader();	
		Commands.waitandparse();
	
		//(new Thread(new CalcPhys(0, 1000, 1000, 0, 60))).start();
	}
}
 