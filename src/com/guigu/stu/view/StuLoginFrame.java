package com.guigu.stu.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.junit.Test;

import com.guigu.stu.model.Student;
import com.guigu.stu.service.StudentService;
import com.guigu.stu.service.impl.StudentServiceImpl;
import javax.swing.JPasswordField;

public class StuLoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private StudentService service = new StudentServiceImpl();
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuLoginFrame frame = new StuLoginFrame();
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

	public StuLoginFrame() {
		setTitle("\u5b66\u751f\u7ba1\u7406\u7cfb\u7edf");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel();
		label.setBounds(91, 102, 95, 29);
		label.setFont(new java.awt.Font("宋体", 0, 14));
		label.setIcon(new javax.swing.ImageIcon(".\\images\\user.png")); 
		label.setText("\u7528\u6237\u540d");

		contentPane.add(label);

		username = new JTextField();
		username.setBounds(196, 102, 177, 29);
		contentPane.add(username);
		username.setColumns(10);

		JLabel label_1 = new JLabel();
		label_1.setBounds(94, 159, 92, 29);
		label_1.setFont(new java.awt.Font("宋体", 0, 14));
		label_1.setIcon(new javax.swing.ImageIcon(".\\images\\password.png")); 
		label_1.setText("\u5bc6\u7801");
		contentPane.add(label_1);

		JLabel label_4 = new JLabel();
		label_4.setBounds(175, 39, 198, 36);
		label_4.setFont(new java.awt.Font("宋体", 0, 24));
		label_4.setIcon(new javax.swing.ImageIcon(".\\images\\student.png")); 
		label_4.setText("\u5b66\u751f\u7ba1\u7406\u7cfb\u7edf");
		contentPane.add(label_4);

		JLabel lblAa = new JLabel();
		lblAa.setBounds(430, 20, 74, 76);
		lblAa.setIcon(new javax.swing.ImageIcon(".\\images\\Teacher.png"));
		contentPane.add(lblAa);

		JButton button = new JButton("\u767B\u9646");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//单独定义方法执行登陆校验和登陆操作
				logonActionPerformed(e);
			}
		});
		button.setBounds(232, 227, 93, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("\u6CE8\u518C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		button_1.setBounds(104, 227, 93, 23);
		contentPane.add(button_1);

		JButton button_2 = new JButton("\u91CD\u7F6E");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		button_2.setBounds(353, 227, 93, 23);
		contentPane.add(button_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(196, 161, 177, 29);
		contentPane.add(passwordField);

	}

	private void resetActionPerformed(java.awt.event.ActionEvent evt) {
		this.username.setText("");
		this.passwordField.setText("");

	}
	
	/**
	 * 对登陆的按钮 进行业务逻辑的判断
	 * @param evt
	 */
	private void logonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String user = this.username.getText();
		String pwd = this.passwordField.getText();
		if (user == null || user.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "账号不能为空");
		}
		if (pwd == null || pwd.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
		}

		try {
			Student conditionStu = new Student();
			conditionStu.setUsername(user);
			conditionStu.setPassword(pwd);
			//查询学生信息
			Student restultStu = service.login(conditionStu);
			if (restultStu != null) {
				// this.dispose();
				JOptionPane.showMessageDialog(null, "登陆成功");
				new MainUI().setVisible(true);
				this.dispose();

			} else {
				JOptionPane.showMessageDialog(null, "登陆失败");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "登陆失败");
			e.printStackTrace();
		}

	}
}
