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
			ta.append("해당하는 데이터가 존재하지 않습니다.\n");
		}
		else {
			ta.append("찾으시는 정보를 알려드립니다. \n");
			ta.append(srchResult);
			ta.append("\n");
		}
	}
}