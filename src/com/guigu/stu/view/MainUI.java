package com.guigu.stu.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainUI extends JFrame {

	private JDesktopPane desktop = new JDesktopPane();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
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
	public MainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 508);
	
		
		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);

		JMenu menu_1 = new JMenu("\u57FA\u672C\u4FE1\u606F\u7BA1\u7406");
		menuBar_1.add(menu_1);

		JMenu menu = new JMenu("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		menu_1.add(menu);

		JMenuItem menuItem = new JMenuItem(
				"\u67E5\u8BE2\u5B66\u751F\u4FE1\u606F");
		menu.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem(
				"\u4FEE\u6539\u5B66\u751F\u4FE1\u606F");
		menu.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem(
				"\u5220\u9664\u5B66\u751F\u4FE1\u606F");
		menu.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem(
				"\u589E\u52A0\u5B66\u751F\u4FE1\u606F");
		menu.add(menuItem_3);
		menuItem_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addNewStudentActionPerformed(e);
			}
		});

		
		desktop.setPreferredSize(new Dimension(480, 360));
		add(desktop);
		
			
				try {
					UIManager	.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		

	}
	
	protected void addNewStudentActionPerformed(ActionEvent e) {
		AddNewStudentUI iframe =new AddNewStudentUI();
		desktop.add(iframe);
		iframe.show();

		
	}
}
