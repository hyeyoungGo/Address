package PhoneBook;

import java.awt.event.*;
import javax.swing.*;

class SearchEventHandler implements ActionListener {
	JTextField search;
	JTextArea ta;
	
	public SearchEventHandler(JTextField field, JTextArea area) {
		search=field;
		ta=area;
	}
	
	public void actionPerformed(ActionEvent e) {
		String name=search.getText();
		PhoneBookManager manager=PhoneBookManager.createManagerInst();
		String srchResult=manager.searchData(name);
		if(srchResult==null) {
			ta.append("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�.\n");
		}
		else {
			ta.append("ã���ô� ������ �˷��帳�ϴ�. \n");
			ta.append(srchResult);
			ta.append("\n");
		}
	}
}