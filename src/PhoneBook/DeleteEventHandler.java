package PhoneBook;

import java.awt.event.*;
import javax.swing.*;

class DeleteEventHandler implements ActionListener {
	JTextField delfield;
	JTextArea ta;
	
	public DeleteEventHandler(JTextField field, JTextArea area) {
		delfield=field;
		ta=area;
	}
	
	public void actionPerformed(ActionEvent e) {
		String name=delfield.getText();
		PhoneBookManager manager=PhoneBookManager.createManagerInst();
		boolean isDeleted=manager.deleteData(name);
		if(isDeleted)
			ta.append("데이터 삭제를 완료하였습니다. \n");
		else
			ta.append("해당하는 데이터가 존재하지 않습니다. \n");
	}
}
