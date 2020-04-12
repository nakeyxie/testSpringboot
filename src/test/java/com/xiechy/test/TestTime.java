package com.xiechy.test;

public class TestTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.util.Date d = new java.util.Date();
		java.util.Calendar cl = java.util.Calendar.getInstance();
		cl.setTime(d);
		int ia[] = new int[5];
		int year = cl.get(java.util.Calendar.YEAR);
		ia[0] = cl.get(java.util.Calendar.MONTH) + 1;
		ia[1] = cl.get(java.util.Calendar.DAY_OF_MONTH);
		ia[2] = cl.get(java.util.Calendar.HOUR_OF_DAY);
		ia[3] = cl.get(java.util.Calendar.MINUTE);
		ia[4] = cl.get(java.util.Calendar.SECOND);
		byte ba[] = new byte[19];
		ba[4] = ba[7] = (byte) '-';
		ba[10] = (byte) ' ';
		ba[13] = ba[16] = (byte) ':';
		ba[0] = (byte) (year / 1000 + '0');
		ba[1] = (byte) ((year / 100) % 10 + '0');
		ba[2] = (byte) ((year / 10) % 10 + '0');
		ba[3] = (byte) (year % 10 + '0');
		for (int i = 0; i < 5; i++) {
			ba[i * 3 + 5] = (byte) (ia[i] / 10 + '0');//5 8 11 14 17
			ba[i * 3 + 6] = (byte) (ia[i] % 10 + '0');//6 9 12 15 18
		}
		System.out.println(new String(ba));

	}

}
