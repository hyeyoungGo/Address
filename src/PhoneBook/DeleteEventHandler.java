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
			ta.append("������ ������ �Ϸ��Ͽ����ϴ�. \n");
		else
			ta.append("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�. \n");
	}
}
