package kr.co.acorn.util;

public class ChangeMark {
	public static String change(int n) {
		String mark ="";
		
		if(n==1) {
			mark = "��";
		} else if (n==-1) {
			mark = "��";
		} else if(n==0) {
			mark = "-";
		}
		
		return mark;
	}
}
