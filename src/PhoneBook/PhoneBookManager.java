package PhoneBook;

import java.io.*;
import java.util.*;

class PhoneBookManager {
	private final File dataFile=new File("PhoneBook.dat");
	HashSet<PhoneInfo> infoStorage=new HashSet<PhoneInfo>();
	
	static PhoneBookManager inst=null;
	public static PhoneBookManager createManagerInst() {
		if(inst==null)
			inst=new PhoneBookManager();
		
		return inst;
	}
	
	private PhoneBookManager() {
		readFromFile();
	}
	
	private PhoneInfo readFriendInfo() {
		System.out.print("이름: ");
		String name=MenuViewer.scanner.nextLine();
		System.out.print("전화번호: ");
		String phone=MenuViewer.scanner.nextLine();
		return new PhoneInfo(name, phone);
	}
	
	private PhoneInfo readUnivFriendInfo() {
		System.out.print("이름: ");
		String name=MenuViewer.scanner.nextLine();
		System.out.print("전화번호: ");
		String phone=MenuViewer.scanner.nextLine();
		System.out.print("전공: ");
		String major=MenuViewer.scanner.nextLine();
		System.out.print("학년: ");
		int year=MenuViewer.scanner.nextInt();
		MenuViewer.scanner.nextLine();
		return new PhoneUnivInfo(name, phone, major, year);
	}
	
	private PhoneInfo readCompanyFriendInfo() {
		System.out.print("이름: ");
		String name=MenuViewer.scanner.nextLine();
		System.out.print("전화번호: ");
		String phone=MenuViewer.scanner.nextLine();
		System.out.print("회사: ");
		String company=MenuViewer.scanner.nextLine();
		return new PhoneCompanyInfo(name, phone, company);	
	}	
	
	public void inputData() throws MenuChoiceException {
		System.out.println("데이터 입력");
		System.out.println("1. 일반, 2. 대학, 3. 회사");
		System.out.print("선택>> ");
		int choice=MenuViewer.scanner.nextInt();
		MenuViewer.scanner.nextLine();
		PhoneInfo info=null;
		
		if(choice<INPUT_SELECT.NORMAL || choice>INPUT_SELECT.COMPANY)
			throw new MenuChoiceException(choice);
		
		switch(choice) {
		case INPUT_SELECT.NORMAL:
			info=readFriendInfo();
			break;
		case INPUT_SELECT.UNIV:
			info=readUnivFriendInfo();
			break;
		case INPUT_SELECT.COMPANY:
			info=readCompanyFriendInfo();
			break;
		}
		
		boolean isAdded=infoStorage.add(info);
		if(isAdded==true)
			System.out.println("데이터 입력이 완료되었습니다. \n");
		else
			System.out.println("이미 저장된 데이터입니다. \n");
	}
	
	public String searchData(String name) {
		PhoneInfo info=search(name);
		if(info==null)
			return null;
		else
			return info.toString();
	}
	
	public boolean deleteData(String name) {	
		Iterator<PhoneInfo> itr=infoStorage.iterator();
		while(itr.hasNext()) {
			PhoneInfo curInfo=itr.next();
			if(name.compareTo(curInfo.name)==0) {
				itr.remove();
				return true;
			}
		}
		
		return false;
	}
	
	private PhoneInfo search(String name) {
		Iterator<PhoneInfo> itr=infoStorage.iterator();
		while(itr.hasNext()) {
			PhoneInfo curInfo=itr.next();
			if(name.compareTo(curInfo.name)==0)
				return curInfo;
		}
		return null;
	}
	
	public void storeToFile() {
		try {
			FileOutputStream file=new FileOutputStream(dataFile);		
			ObjectOutputStream out=new ObjectOutputStream(file);
			
			Iterator<PhoneInfo> itr=infoStorage.iterator();
			while(itr.hasNext())
				out.writeObject(itr.next());
			
			out.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readFromFile() {
		if(dataFile.exists()==false)
			return;
		
		try {
			FileInputStream file=new FileInputStream(dataFile);		
			ObjectInputStream in=new ObjectInputStream(file);
			
			while(true) {
				PhoneInfo info=(PhoneInfo)in.readObject();
				if(info==null)
					break;
				infoStorage.add(info);
			}
			
			in.close();
		}
		catch(IOException e) {
			return;
		}
		catch(ClassNotFoundException e) {
			return;
		}
	}
}