package PhoneBook;

public class MenuChoiceException extends Exception {
	int wrongChoice;
	
	public MenuChoiceException(int choice) {
		super("�ٽ� ������ �ּ���.");
		wrongChoice=choice;
	}
	
	public void showWrongChoice() {
		System.out.println(wrongChoice+"��(��) �������� �ʽ��ϴ�.");
	}
}

