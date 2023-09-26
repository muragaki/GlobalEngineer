package grobal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import grobal.domain.service.GlobalService;

public class Entory extends JDialog {
	GlobalService globalService = null;
	// パネル
	JPanel panel = new JPanel();
	// ラベル
	JLabel lblid = new JLabel("内定者番号");
	JLabel lblrollnumber = new JLabel("展開エンジニアコード");
	JLabel lblname = new JLabel("氏名");
	JLabel lblnationality = new JLabel("国籍");
	JLabel lblbirthday = new JLabel("生年月日");
	JLabel lblsex = new JLabel("性別");
	JLabel lblalmamater = new JLabel("出身学校");
	JLabel lblsalary = new JLabel("給与");
	JLabel lblemployment = new JLabel("雇用形態");
	JLabel lblplace = new JLabel("配属先");
	JLabel lblemail = new JLabel("E-Mail");
	JLabel lblnote = new JLabel("備考");
	// 入力フィールド
	JTextField txtid = new JTextField(20);
	JTextField txtrollnumber = new JTextField(20);
	JTextField txtname = new JTextField(20);
	JTextField txtnationality = new JTextField(20);
	JTextField txtbirthday = new JTextField("2000/1/1", 20);
	JTextField txtsex = new JTextField(20);
	JTextField txtalmamater = new JTextField(20);
	JTextField txtsalary = new JTextField("0", 20);
	JTextField txtemployment = new JTextField(20);
	JTextField txtplace = new JTextField(20);
	JTextField txtemail = new JTextField(20);
	JTextArea txanote = new JTextArea(3, 20);
	JPanel panelBirthday = new JPanel();
	JSpinner spinyy = new JSpinner();
	JSpinner spinmm = new JSpinner();
	JSpinner spindd = new JSpinner();
	SpinnerModel modelyy = new SpinnerNumberModel(2000, 1970, 2030, 1);
	SpinnerModel modelmm = new SpinnerNumberModel(1, 1, 12, 1);
	SpinnerModel modeldd = new SpinnerNumberModel(1, 1, 31, 1);
	
	// ボタン
	JButton btnentry = new JButton("登録");
	JButton btncancel = new JButton("キャンセル");	
	
	String[] placeof = {"札幌","仙台","東京","横浜","新潟",
			"名古屋","大阪","広島","北九州","福岡"};
	JList<String> list = new JList<String>(placeof);
	JScrollPane scrl = new JScrollPane(list);
	String[] datayyyy = {"1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};
	String[] datamm = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	String[] datadd = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	JList<String> listyyyy = new JList<>(datayyyy);
	JList<String> listmm = new JList<>(datamm);
	JList<String> listdd = new JList<>(datadd);
	JScrollPane paneyyyy = new JScrollPane();
	JScrollPane panemm = new JScrollPane();
	JScrollPane panedd = new JScrollPane();
	
	public Entory(JFrame frame) {
		super(frame, "新規エンジニア登録", true);
		globalService = GlobalService.getInstance();
		spinyy.setModel(modelyy);
		spinmm.setModel(modelmm);
		spindd.setModel(modeldd);
		panelBirthday.setLayout(new FlowLayout());
		panelBirthday.add(spinyy);
		panelBirthday.add(spinmm);
		panelBirthday.add(spindd);

		btnentry.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int count = globalService.insert(null, null, txtname.getText(), txtnationality.getText(), txtbirthday.getText(), txtsex.getText(), txtalmamater.getText(), Integer.parseInt(txtsalary.getText()), txtemployment.getText(), txtplace.getText(), txtemail.getText(), txanote.getText());
				
				
			}
		});
		btncancel.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		layout.setAutoCreateContainerGaps(true);
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup().
				addComponent(lblid).
				addComponent(lblrollnumber).
				addComponent(lblname).
				addComponent(lblnationality).
				addComponent(lblbirthday).
				addComponent(lblsex).
				addComponent(lblalmamater).
				addComponent(lblsalary).
				addComponent(lblemployment).
				addComponent(lblplace).
				addComponent(lblemail).
				addComponent(lblnote).
				addComponent(btnentry));
		hGroup.addGroup(layout.createParallelGroup().
				addComponent(txtid).
				addComponent(txtrollnumber).
				addComponent(txtname).
				addComponent(txtnationality).
				addComponent(txtbirthday).
			//	addComponent(panelBirthday).
				addComponent(txtsex).
				addComponent(txtalmamater).
				addComponent(txtsalary).
				addComponent(txtemployment).
				addComponent(txtplace).
				addComponent(txtemail).
				addComponent(txanote).
				addComponent(btncancel));
		layout.setHorizontalGroup(hGroup);
		GroupLayout.SequentialGroup vGruop = layout.createSequentialGroup();
		vGruop.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
				addComponent(lblid).addComponent(txtid));
		vGruop.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
				addComponent(lblrollnumber).addComponent(txtrollnumber));
		vGruop.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
				addComponent(lblname).addComponent(txtname));
		vGruop.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
				addComponent(lblnationality).addComponent(txtnationality));
		vGruop.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
				addComponent(lblbirthday).addComponent(txtbirthday));
	//	vGruop.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
	//			addComponent(lblbirthday).addComponent(panelBirthday));
		vGruop.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
				addComponent(lblsex).addComponent(txtsex));
		vGruop.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
				addComponent(lblalmamater).addComponent(txtalmamater));
		vGruop.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
				addComponent(lblsalary).addComponent(txtsalary));
		vGruop.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
				addComponent(lblemployment).addComponent(txtemployment));
		vGruop.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
				addComponent(lblplace).addComponent(txtplace));
		vGruop.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
				addComponent(lblemail).addComponent(txtemail));
		vGruop.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
				addComponent(lblnote).addComponent(txanote));
		vGruop.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
				addComponent(btnentry).addComponent(btncancel));
		layout.setVerticalGroup(vGruop);	
		add(panel);
		pack();
		setVisible(true);
	}
}