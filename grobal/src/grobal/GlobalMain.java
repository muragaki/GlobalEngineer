package grobal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import grobal.model.MyTableModel;

public class GlobalMain extends JFrame {
	
	public GlobalMain() {
		JFrame frame = this;
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Global Engineer 一覧　　");
		JButton buttonEntry = new JButton("新規登録");
		buttonEntry.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Entory(frame);				
			}
		});
		JButton buttonExit = new JButton("終了");
		buttonExit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(label);
		panel.add(buttonEntry);
		add(panel, BorderLayout.NORTH);
		add(buttonExit,BorderLayout.SOUTH);
		
		MyTableModel model = new MyTableModel();
		JTable table = new JTable(model);
		add(table,BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new GlobalMain();
	}
}