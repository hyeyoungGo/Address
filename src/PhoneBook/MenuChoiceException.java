package PhoneBook;

public class MenuChoiceException extends Exception {
	int wrongChoice;
	
	public MenuChoiceException(int choice) {
		super("다시 선택해 주세요.");
		wrongChoice=choice;
	}
	
	public void showWrongChoice() {
		System.out.println(wrongChoice+"은(는) 존재하지 않습니다.");
	}
}

