package com.liu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.liu.view.MainFrm;
import com.liu.dao.AdminDao;
import com.liu.dao.UsersDao;
import com.liu.model.Admin;
import com.liu.model.UserType;
import com.liu.model.Users;
import com.liu.util.StringUtil;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JDesktopPane;
import java.awt.Toolkit;

public class LoginFrm extends JFrame {

	protected static final String ae = null;
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JComboBox userTypeComboBox;
	private JPasswordField passwordTextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
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
	public LoginFrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrm.class.getResource("/images/\u6D17\u53D1\u6C34-01.png")));
		setTitle("\u767B\u9646\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//把登录窗口放到中间位置
		setLocationRelativeTo(null);
		JLabel label = new JLabel("\u9500\u552E\u7CFB\u7EDF\u767B\u5F55\u754C\u9762");
		label.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u6D17\u53D1\u6C34 (4).png")));
		label.setFont(new Font("楷体", Font.BOLD, 28));
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D:");
		label_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u767B\u5F55 \u7528\u6237.png")));
		label_1.setFont(new Font("楷体", Font.PLAIN, 25));
		
		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("楷体", Font.PLAIN, 22));
		usernameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6 \u7801:");
		label_2.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u767B\u5F55-\u5BC6\u7801\u4E0D\u53EF\u89C1.png")));
		label_2.setFont(new Font("楷体", Font.PLAIN, 25));
		
		JLabel label_3 = new JLabel("\u7528\u6237\u7C7B\u578B:");
		label_3.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u7CFB\u7EDF\u7BA1\u7406-\u7528\u6237\u67E5\u8BE2 (1).png")));
		label_3.setFont(new Font("楷体", Font.PLAIN, 25));
		
		userTypeComboBox = new JComboBox();
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN,UserType.USER,UserType.VIPUSER}));
		userTypeComboBox.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u767B\u5F55\u63D0\u4EA4.png")));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
				loginAct(ae);
				
			}
		});
		loginButton.setFont(new Font("楷体", Font.PLAIN, 25));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u91CD\u7F6E2.png")));
		resetButton.setFont(new Font("楷体", Font.PLAIN, 25));
		
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("Microsoft Himalaya", Font.PLAIN, 22));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(80)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, Alignment.TRAILING)
						.addComponent(label_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(label_1)
						.addComponent(loginButton, Alignment.TRAILING))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(userTypeComboBox, 0, 225, Short.MAX_VALUE)
								.addComponent(usernameTextField)
								.addComponent(passwordTextField, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(resetButton)
							.addGap(35)))
					.addContainerGap(55, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(111, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(92))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginButton)
						.addComponent(resetButton))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
		private void setIconifiable(boolean b) {
		// TODO Auto-generated method stub
		
	}

		private void setClosable(boolean b) {
		// TODO Auto-generated method stub
		
	}

		//登录：消息响应
	protected void loginAct(ActionEvent ae2) {
		// TODO Auto-generated method stub
		//传值，把文本框的内容传递到userName,password中
		String userName=usernameTextField.getText().toString();
		String password=passwordTextField.getText().toString();
		UserType selectedItem = (UserType)userTypeComboBox.getSelectedItem();
		//判断文本框是不能为空的，这里的if语句中的调用了StringUtil
		if(StringUtil.isEmpty(userName)) 
		{
			JOptionPane.showMessageDialog(this, "用户名不能为空！！！");
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(this, "密码不能为空！");
			return;
		}
		//判断登录类型，并跳转到不同的界面
		//系统管理员登录
		Admin admin=null;
		if("系统管理员".equals(selectedItem.getName())) 
		{
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			adminTmp.setName(userName);
			adminTmp.setPassword(password);
			admin = adminDao.login(adminTmp);
			if(admin == null)
			{
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			this.dispose();
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】："+admin.getName()+"登录本系统！");
			new MainFrm(selectedItem, admin).setVisible(true);
			
		}
		//普通用户登录
		else if("用户".equals(selectedItem.getName())) 
		{
			Users user=null;
			UsersDao userDao=new UsersDao();
			Users users=new Users();
			users.setName(userName);
			users.setPassword(password);
			user=userDao.login(users);
			userDao.closeDao();
			if(user == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】："+users.getName()+"登录本系统！");
			this.dispose();
			new MainFrm(selectedItem, users).setVisible(true);
		}
		//VIP贵宾登录
		else
		{
			
		}
	}
	//重置的消息响应，将文本框清空
	protected void restValue(String ae2) {
		// TODO Auto-generated method stub
		usernameTextField.setText("");
		passwordTextField.setText("");
		userTypeComboBox.setSelectedIndex(0);
	
	}
}
