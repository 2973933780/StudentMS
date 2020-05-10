package com.liu.view;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.liu.view.MainFrm;
import com.liu.dao.AdminDao;
import com.liu.model.Admin;
import com.liu.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditPasswordFrm extends JInternalFrame {

	private JPanel contentPane;
	private JTextField oldPasswordTextField;
	private JTextField newPasswordTextField;
	private JTextField confrimPasswordTextField;
	private JButton submitButton;
	private JButton resetButton;
	private JLabel label_3;
	private JLabel currentUserLabel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EditPasswordFrm frame = new EditPasswordFrm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public EditPasswordFrm() {
		setFrameIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u78011.png")));
	
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(400, 150, 600, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true);
		setIconifiable(true);
		JLabel label = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		label.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u5BC6\u7801 3.png")));
		label.setFont(new Font("楷体", Font.PLAIN, 30));
		
		oldPasswordTextField = new JTextField();
		oldPasswordTextField.setFont(new Font("楷体", Font.PLAIN, 28));
		oldPasswordTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_1.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u5BC6\u78014.png")));
		label_1.setFont(new Font("楷体", Font.PLAIN, 30));
		
		newPasswordTextField = new JTextField();
		newPasswordTextField.setFont(new Font("楷体", Font.PLAIN, 28));
		newPasswordTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u63D0\u4EA41.png")));
		label_2.setFont(new Font("楷体", Font.PLAIN, 30));
		
		confrimPasswordTextField = new JTextField();
		confrimPasswordTextField.setFont(new Font("楷体", Font.PLAIN, 28));
		confrimPasswordTextField.setColumns(10);
		
		submitButton = new JButton("\u786E\u8BA4");
		submitButton.addActionListener(new ActionListener() {
			//确认按钮事件添加
			public void actionPerformed(ActionEvent ae) 
			{
				submitEdit(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u6DFB\u52A0\u5173\u6CE8(\u8BDD\u9898).png")));
		submitButton.setFont(new Font("楷体", Font.BOLD, 30));
		
		resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u91CD\u7F6E2.png")));
		resetButton.setFont(new Font("楷体", Font.BOLD, 30));
		
		label_3 = new JLabel("\u5F53\u524D\u7528\u6237\uFF1A");
		label_3.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/0\u89D2\u8272\u7BA1\u7406.png")));
		label_3.setFont(new Font("楷体", Font.PLAIN, 30));
		
		currentUserLabel = new JLabel("");
		currentUserLabel.setFont(new Font("楷体", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(96)
					.addComponent(submitButton)
					.addPreferredGap(ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
					.addComponent(resetButton)
					.addGap(98))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(68)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
							.addComponent(currentUserLabel, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label)
										.addComponent(label_1))
									.addGap(36))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(newPasswordTextField, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
								.addComponent(oldPasswordTextField, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
								.addComponent(confrimPasswordTextField, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))))
					.addGap(77))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(currentUserLabel))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(confrimPasswordTextField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		if("系统管理员".equals(MainFrm.userType.getName())){
			Admin admin = (Admin)MainFrm.userObject;
			currentUserLabel.setText("【系统管理员】" + admin.getName());
		}
	}

	protected void submitEdit(ActionEvent ae) {
		// TODO Auto-generated method stub
		String oldPassword=oldPasswordTextField.getText().toString();
		String newPassword=newPasswordTextField.getText().toString();
		String confrimPassword=confrimPasswordTextField.getText().toString();
		if(StringUtil.isEmpty(oldPassword)) 
		{
			JOptionPane.showMessageDialog(this, "请填写旧密码！！！");
			return;
		}
		if(StringUtil.isEmpty(newPassword)) 
		{
			JOptionPane.showMessageDialog(this, "请填写新密码！！！");
			return;
		}
		if(StringUtil.isEmpty(confrimPassword)) 
		{
			JOptionPane.showMessageDialog(this, "请确认新密码！！！");
			return;
		}
		if(!newPassword.equals(confrimPassword)) 
		{
			JOptionPane.showMessageDialog(this, "两次密码输入不一样！！！");
			return;
		}
		//
		if("系统管理员".equals(MainFrm.userType.getName())){
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			Admin admin = (Admin)MainFrm.userObject;
			adminTmp.setName(admin.getName());
			adminTmp.setId(admin.getId());
			adminTmp.setPassword(oldPassword);
			JOptionPane.showMessageDialog(this, adminDao.editPassword(adminTmp, newPassword));
			return;
		}
	}

	//更改密码界面的重置按钮事件
	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		oldPasswordTextField.setText("");
		newPasswordTextField.setText("");
		confrimPasswordTextField.setText("");
	}
}
