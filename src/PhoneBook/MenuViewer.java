package PhoneBook;

import java.util.Scanner;

class MenuViewer {
	public static Scanner scanner=new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("선택하세요!");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 프로그램 종료");
		System.out.print("선택: ");
	}
}