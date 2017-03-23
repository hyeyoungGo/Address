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
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);
					return;
				}
			}
			catch(MenuChoiceException e) {
				e.showWrongChoice();
				System.out.println("�޴� ������ ó������ �ٽ� �����մϴ�.\n");
			}
		}
	}
}