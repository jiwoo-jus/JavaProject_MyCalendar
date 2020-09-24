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
		int leap_year_count = 0, s1 = 0, s2 = 0, total = 0;

		//현재년도부터 미래년도 사이에 있는 윤년 개수 세기
		for(int i = cal.get(Calendar.YEAR); i < new_year; i++) {
			if((i%4 == 0 && i%100 != 0) || i%400 == 0)
				leap_year_count++;
		}
		//s1 = 미래 날짜의 월+일 일수
		for(int i = new_month; i > 0; i--) { //ex-a)xx년 5월 14일이면 이곳에선 1,2,3,4월 누적 일수 더함: 31+(28)+31+30
			if(i==1 && (new_year%4 == 0 && new_year % 100 != 0) || new_year%400 == 0) //2월 누적 일수를 더할 때 해당 월이 윤달인지 확인
				s1++;
			s1 += months[i-1];
		}
		s1 += new_day; //ex-a)이곳에선 앞서 구한 것에 14일을 더함: 31+(28)+31+30+'14'
		//s2 = 현재 날짜의 월+일 일수
		for(int i = cal.get(Calendar.MONTH); i > 0; i--) {
			if(i==1 && (cal.get(Calendar.YEAR)%4 == 0 && cal.get(Calendar.YEAR)%100 != 0) || cal.get(Calendar.YEAR)%400 == 0)
				s2++;
			s2 += months[i-1];
		}
		s2 += cal.get(Calendar.DAY_OF_MONTH);
		//s1이 s2보다 작으면 1년(365일)땡겨 써서 월+일 일수 차이를 양수로 계산, 대신 년도 차이 구할 때 하나 차감
		if(s1 > s2)
			total = (new_year - cal.get(Calendar.YEAR)) * 365 + leap_year_count + (s1 - s2);
		else
			total = (new_year - cal.get(Calendar.YEAR) - 1) *365 + leap_year_count + (s1 + 365 - s2);

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
