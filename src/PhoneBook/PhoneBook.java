package PhoneBook;

class PhoneBook {	
	public static void main(String[] args) {
		PhoneBookManager manager=PhoneBookManager.createManagerInst();
		SearchFrame winFrame=new SearchFrame("PhoneBook");
		
		int choice;
		
		while(true) {
			try {
				MenuViewer.showMenu();
				choice=MenuViewer.scanner.nextInt();
				MenuViewer.scanner.nextLine();
				
				if(choice<INIT_MENU.INPUT || choice>INIT_MENU.EXIT)
					throw new MenuChoiceException(choice);
				
				switch(choice) {
				case INIT_MENU.INPUT:
					manager.inputData();
					break;
				case INIT_MENU.EXIT:
					manager.storeToFile();
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					return;
				}
			}
			catch(MenuChoiceException e) {
				e.showWrongChoice();
				System.out.println("메뉴 선택을 처음부터 다시 진행합니다.\n");
			}
		}
	}
}