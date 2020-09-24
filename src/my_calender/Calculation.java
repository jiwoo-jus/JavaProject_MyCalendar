package my_calender;

import java.util.Calendar;

public class Calculation {

	static void when_is_it(int days) {
		Calendar cal = Calendar.getInstance();
		Calendar newcalen = Calendar.getInstance();
		newcalen.clear();
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + days);
		System.out.print("=> " + cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH) + 1) + "월 " + cal.get(Calendar.DAY_OF_MONTH) + "일 ");
		switch(cal.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.SUNDAY : System.out.println("일요일\n"); break;
		case Calendar.MONDAY : System.out.println("월요일\n"); break;
		case Calendar.TUESDAY : System.out.println("화요일\n"); break;
		case Calendar.WEDNESDAY : System.out.println("수요일\n"); break;
		case Calendar.THURSDAY : System.out.println("목요일\n"); break;
		case Calendar.FRIDAY : System.out.println("토요일\n"); break;
		case Calendar.SATURDAY : System.out.println("금요일\n"); break;
		}
	}

	static void how_many_days_left(String[] newdate) {
		int new_year = Integer.parseInt(newdate[0]);
		int new_month = Integer.parseInt(newdate[1]) - 1;
		int new_day = Integer.parseInt(newdate[2]);
		Calendar cal = Calendar.getInstance();
		int [] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int s1 = 0, s2 = 0, total = 0;

		for(int j = new_month; j > 0; j--)
			s1 += months[j-1];
		s1 += new_day;
		for(int j = cal.get(Calendar.MONTH); j > 0; j--)
			s2 += months[j-1];
		s2 += cal.get(Calendar.DAY_OF_MONTH);
		if(s1 > s2)
			total = (new_year - cal.get(Calendar.YEAR)) * 365 + (s1 - s2);
		else
			total = (new_year - cal.get(Calendar.YEAR) - 1) *365 + (s1 + 365 - s2);

		System.out.print("=> 오늘로부터 " + total + "일 후 입니다.");
		System.out.print("(" + total/365 + "년  그리고 ");
		total = total % 365;
		int month_count = 0;
		while(total > months[new_month]) {
			total -= months[new_month];
			new_month = (new_month+1)%12;
			month_count++;
		}
		System.out.print(month_count + "달 그리고 ");
		System.out.println(total + "일 후)\n");
	}
}
