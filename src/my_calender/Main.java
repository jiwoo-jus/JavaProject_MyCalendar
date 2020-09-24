package my_calender;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);

		int option = 0;
		while(option != 4) {
			System.out.println("원하는 항목의 번호를 입력하세요.\n1. 오늘로부터 며칠 후 구하기 \n2. 오늘로부터 며칠 전 구하기 \n3. 오늘로부터 그 날짜까지 기간 구하기\n4. 그만하기");
			option = scan.nextInt();
			if(option == 1) {
				System.out.println("오늘로부터 _일 후?");
				Calculation.when_is_it(scan.nextInt());
				}
			if(option == 2) {
				scan.nextLine(); //scanner가  nextInt()에서 nextLine()으로 잘 넘어오기 위함
				System.out.println("오늘로부터 _일 전?");
				Calculation.when_is_it(scan.nextInt()*(-1));
			}
			if(option == 3) {
				System.out.println("xxxx/xx/xx 형태로 날짜 입력");
				scan.nextLine();
				String [] newdate = scan.nextLine().split("/");
				Calculation.how_many_days_left(newdate);
			}
		}
		scan.close();
	}
}