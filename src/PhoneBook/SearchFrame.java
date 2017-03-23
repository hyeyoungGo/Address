package PhoneBook;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

class SearchFrame extends JFrame {
	JTextField srchField=new JTextField(15);
	JButton srchBt=new JButton("SEARCH");
	
	JTextField delField=new JTextField(15);
	JButton delBtn=new JButton("DEL");
	
	JTextArea ta=new JTextArea(20, 25);

	public SearchFrame(String title) {
		super(title);
		setBounds(100, 200, 330, 450);
		setLayout(new BorderLayout());
		Border border=BorderFactory.createEtchedBorder();
		
		Border srchBorder=BorderFactory.createTitledBorder(border, "Search");
		JPanel srchPanel=new JPanel();
		srchPanel.setBorder(srchBorder);
		srchPanel.setLayout(new FlowLayout());
		srchPanel.add(srchField);
		srchPanel.add(srchBt);

		Border delBorder=BorderFactory.createTitledBorder(border, "Delete");
		JPanel delPanel=new JPanel();
		delPanel.setBorder(delBorder);
		delPanel.setLayout(new FlowLayout());
		delPanel.add(delField);
		delPanel.add(delBtn);
		
		JScrollPane scrollTextArea=new JScrollPane(ta);	
		Border textBorder=BorderFactory.createTitledBorder(border, "Infomation Board");
		scrollTextArea.setBorder(textBorder);
		
		add(srchPanel, BorderLayout.NORTH);
		add(delPanel, BorderLayout.SOUTH);
		add(scrollTextArea, BorderLayout.CENTER);
		
		srchBt.addActionListener(new SearchEventHandler(srchField, ta));
		delBtn.addActionListener(new DeleteEventHandler(delField, ta));
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);	
	}
}
