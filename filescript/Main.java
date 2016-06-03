package oop.ex5.filescript;

import oop.ex5.filescript.MyFileScript;

public class Main {
	
	public static void main(String[] args){

		String temp = "D:\\oop\\ex5\\basic_filters\\filter00";
		String temp2 = ".flt";
		String dic = "D:\\oop\\ex5\\basic_source_directory";
		String[] temp3 = new String[2];
		temp3[0] = dic;
		//int j =  11;
		for (int i=1 ;i <10;i++){
			temp3[1] = temp + i + temp2;
			System.out.println(i);
			MyFileScript.main(temp3);
			//System.out.println("\n");

		}		
		temp = "D:\\oop\\ex5\\basic_filters\\filter0";
		temp3 = new String[2];
		temp3[0] = dic;
		//int j =  11;
		for (int i=10 ;i <51;i++){
			temp3[1] = temp + i + temp2;
			System.out.println(i);
			MyFileScript.main(temp3);
		}			
		
		
		temp = "D:\\oop\\ex5\\advanced_filters\\filter0";
		temp2 = ".flt";
		dic = "D:\\oop\\ex5\\advanced_source_directory";
		temp3 = new String[2];
		temp3[0] = dic;
		//int j =  11;
		for (int i=60 ;i <61;i++){
			temp3[1] = temp + i + temp2;
			System.out.println(i);
			MyFileScript.main(temp3);
		}

	}
}
