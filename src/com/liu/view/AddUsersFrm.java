package com.liu.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.liu.dao.UsersDao;
import com.liu.model.Users;
import com.liu.util.StringUtil;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddUsersFrm extends JInternalFrame {
	private JTextField UserNameTextField;
	private JTextField UserCardTextField;
	private JPasswordField UserpasswordField;
	private ButtonGroup sexButtonGroup;
	private JRadioButton studentSexManRadioButton;
	private JRadioButton studentSexFemalRadioButton;
	private JRadioButton studentSexUnkonwRadioButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUsersFrm frame = new AddUsersFrm();
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
	public AddUsersFrm() {
		setFrameIcon(new ImageIcon(AddUsersFrm.class.getResource("/images/\u6DFB\u52A0\u5173\u6CE8(\u8BDD\u9898).png")));
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6DFB\u52A0\u7528\u6237");
		setBounds(400, 150, 600, 416);
		
		JLabel label = new JLabel("\u7528\u6237\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(AddUsersFrm.class.getResource("/images/\u771F\u5B9E\u59D3\u540D.png")));
		label.setFont(new Font("楷体", Font.BOLD, 25));
		
		UserNameTextField = new JTextField();
		UserNameTextField.setFont(new Font("楷体", Font.PLAIN, 22));
		UserNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5361 \u53F7\uFF1A");
		label_1.setIcon(new ImageIcon(AddUsersFrm.class.getResource("/images/\u5361\u53F7.png")));
		label_1.setFont(new Font("楷体", Font.BOLD, 25));
		
		UserCardTextField = new JTextField();
		UserCardTextField.setFont(new Font("楷体", Font.BOLD, 22));
		UserCardTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(AddUsersFrm.class.getResource("/images/\u767B\u5F55-\u5BC6\u7801\u4E0D\u53EF\u89C1.png")));
		label_2.setFont(new Font("楷体", Font.BOLD, 25));
		
		UserpasswordField = new JPasswordField();
		UserpasswordField.setFont(new Font("楷体", Font.BOLD, 22));
		
		JLabel label_3 = new JLabel("\u6027\u522B\uFF1A");
		label_3.setIcon(new ImageIcon(AddUsersFrm.class.getResource("/images/\u6027\u522B1.png")));
		label_3.setFont(new Font("楷体", Font.BOLD, 25));
		
		JButton submitbutton = new JButton("\u786E\u8BA4");
		submitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				UserAddAct(ae);
			}
		});
		submitbutton.setIcon(new ImageIcon(AddUsersFrm.class.getResource("/images/\u786E\u8BA41.png")));
		submitbutton.setFont(new Font("楷体", Font.BOLD, 25));
		
		studentSexManRadioButton = new JRadioButton("\u7537");
		studentSexManRadioButton.setFont(new Font("楷体", Font.PLAIN, 25));
		
		studentSexFemalRadioButton = new JRadioButton("\u5973");
		studentSexFemalRadioButton.setFont(new Font("楷体", Font.PLAIN, 25));
		
		studentSexUnkonwRadioButton = new JRadioButton("\u4FDD\u5BC6");
		studentSexUnkonwRadioButton.setFont(new Font("楷体", Font.PLAIN, 25));
		
		//实现性别选择单选框
		sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(studentSexManRadioButton);
		sexButtonGroup.add(studentSexFemalRadioButton);
		sexButtonGroup.add(studentSexUnkonwRadioButton);
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(AddUsersFrm.class.getResource("/images/\u91CD\u7F6E2.png")));
		resetButton.setFont(new Font("楷体", Font.BOLD, 25));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(97)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(label_2)
							.addComponent(label_3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(studentSexManRadioButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(studentSexFemalRadioButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(studentSexUnkonwRadioButton))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(UserpasswordField)
							.addComponent(UserCardTextField)
							.addComponent(UserNameTextField, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)))
					.addContainerGap(118, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(130)
					.addComponent(submitbutton)
					.addPreferredGap(ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
					.addComponent(resetButton)
					.addGap(134))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(UserNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(UserCardTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(UserpasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(studentSexManRadioButton)
						.addComponent(studentSexFemalRadioButton)
						.addComponent(studentSexUnkonwRadioButton))
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitbutton)
						.addComponent(resetButton))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
	//实现添加按钮的方法
	protected void UserAddAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String studentName = UserNameTextField.getText().toString();
		String studentCard = UserCardTextField.getText().toString();
		String studentPassword = UserpasswordField.getText().toString();
		if(StringUtil.isEmpty(studentName)){
			JOptionPane.showMessageDialog(this, "请填写学生姓名!");
			return;
		}
		if(StringUtil.isEmpty(studentPassword)){
			JOptionPane.showMessageDialog(this, "请填写密码!");
			return;
		}
		if(StringUtil.isEmpty(studentCard)){
			JOptionPane.showMessageDialog(this, "请填写卡号!");
			return;
		}
		String sex = studentSexManRadioButton.isSelected() ? studentSexManRadioButton.getText() : (studentSexFemalRadioButton.isSelected() ? studentSexFemalRadioButton.getText() : studentSexUnkonwRadioButton.getText());
		Users student=new Users();
		student.setName(studentName);
		student.setClassId(studentCard);
		student.setPassword(studentPassword);
		student.setSex(sex);
		UsersDao studentDao=new UsersDao();
		if(studentDao.addStudent(student)){
			JOptionPane.showMessageDialog(this, "添加成功!");
		}else{
			JOptionPane.showMessageDialog(this, "添加失败!");
		}
		resetValue(ae);
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		UserNameTextField.setText("");
		UserpasswordField.setText("");
		UserCardTextField.setText("");
		sexButtonGroup.clearSelection();
		studentSexManRadioButton.setSelected(true);
	}
}
