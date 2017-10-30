package com.guigu.stu.view;

import java.awt.EventQueue;

import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import com.guigu.stu.model.Student;
import com.guigu.stu.service.StudentService;
import com.guigu.stu.service.impl.StudentServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

public class AddNewStudentUI extends JInternalFrame {
	private JTextField vsid;
	private JTextField vsname;
	private JTextField vusername;
	private JPasswordField vpassword;
	private JTextField vsage;
	private JComboBox veducation;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton vmale;
	JRadioButton vfemale;
	private StudentService service = new StudentServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewStudentUI frame = new AddNewStudentUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddNewStudentUI() {
		
		super("添加学生信息", true, true, false, true);
		setBounds(100, 100, 560, 457);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("\u59D3\u540D:");
		label.setBounds(277, 62, 54, 15);
		getContentPane().add(label);

		vsid = new JTextField();
		vsid.setBounds(92, 57, 143, 26);
		getContentPane().add(vsid);
		vsid.setColumns(10);

		JLabel label_1 = new JLabel("\u5B66\u53F7\uFF1A");
		label_1.setBounds(42, 62, 54, 15);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel("\u6DFB\u52A0\u5B66\u751F\u4FE1\u606F");
		label_2.setBounds(196, 10, 122, 26);
		label_2.setIcon(new javax.swing.ImageIcon(".\\images\\add.png"));
		getContentPane().add(label_2);

		vsname = new JTextField();
		vsname.setBounds(341, 59, 161, 21);
		getContentPane().add(vsname);
		vsname.setColumns(10);

		JLabel label_3 = new JLabel("\u7528\u6237\u540D:");
		label_3.setBounds(42, 139, 54, 15);
		getContentPane().add(label_3);

		vusername = new JTextField();
		vusername.setBounds(92, 124, 143, 30);
		getContentPane().add(vusername);
		vusername.setColumns(10);

		JLabel label_4 = new JLabel("\u5BC6\u7801:");
		label_4.setBounds(277, 139, 54, 15);
		getContentPane().add(label_4);

		vpassword = new JPasswordField();
		vpassword.setBounds(341, 132, 161, 26);
		getContentPane().add(vpassword);

		JLabel label_5 = new JLabel("\u5E74\u9F84:");
		label_5.setBounds(42, 215, 54, 15);
		getContentPane().add(label_5);

		vsage = new JTextField();
		vsage.setBounds(92, 199, 143, 31);
		getContentPane().add(vsage);
		vsage.setColumns(10);

		JLabel label_6 = new JLabel("\u5B66\u5386\uFF1A");
		label_6.setBounds(277, 215, 54, 15);
		getContentPane().add(label_6);

		veducation = new JComboBox();
		veducation.setModel(new DefaultComboBoxModel(new String[] {
				"\u535A\u58EB", "\u7855\u58EB", "\u672C\u79D1", "\u4E13\u79D1",
				"\u9AD8\u4E2D" }));
		veducation.setBounds(341, 212, 72, 26);
		getContentPane().add(veducation);

		JLabel label_7 = new JLabel("\u6027\u522B:");
		label_7.setBounds(42, 280, 54, 15);
		getContentPane().add(label_7);

		vmale = new JRadioButton("\u7537");
		buttonGroup.add(vmale);
		vmale.setBounds(94, 276, 54, 26);
		getContentPane().add(vmale);

		vfemale = new JRadioButton("\u5973");
		buttonGroup.add(vfemale);
		vfemale.setBounds(153, 278, 59, 26);
		getContentPane().add(vfemale);

		JButton button = new JButton("\u6DFB\u52A0\u5B66\u751F\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewStudentActionPerformed(e);
			}
		});
		button.setBounds(92, 341, 137, 26);
		getContentPane().add(button);

		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.setBounds(296, 341, 152, 26);
		getContentPane().add(btnNewButton);

	}

	protected void addNewStudentActionPerformed(ActionEvent e) {
		// 对添加的数据执行校验
		// .............

		int sid = Integer.parseInt(this.vsid.getText());
		String username = this.vusername.getText();
		String password = this.vpassword.getText();
		String sname = this.vsname.getText();
		int sage = Integer.parseInt(this.vsage.getText());
		String education = (String) this.veducation.getSelectedItem();
		String ssex = null;
		if (vmale.isSelected()) {
			ssex = vmale.getText();
		} else if (vfemale.isSelected()) {
			ssex = vfemale.getText();
		}

		// 把得到的界面的数据封装为Student对象 传递到service 到dao层即可
		Student stu = new Student(sid, username, password, sname, sage, ssex,
				education);
		service.addNewStudent(stu);
		JOptionPane.showMessageDialog(null, "添加成功");
		this.dispose();

		// System.out.println(stu);
	}
}
