package com.liu.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import com.liu.view.MainFrm;
import com.liu.dao.StockDao;
import com.liu.dao.UsersDao;
import com.liu.model.Stock;
import com.liu.model.Users;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class UsersManageFrm extends JInternalFrame {
	private JTable userUtiltable;
	private JTextField UserCardIDTextField;
	private JTextField editUserNameTextField;
	private JTextField editUserCardIDTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsersManageFrm frame = new UsersManageFrm();
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
	public UsersManageFrm() {
		setFrameIcon(new ImageIcon(UsersManageFrm.class.getResource("/images/\u7CFB\u7EDF\u7BA1\u7406-\u7528\u6237\u67E5\u8BE2 (1).png")));
		setIconifiable(true);
		setClosable(true);
		getContentPane().setFont(new Font("楷体", Font.BOLD, 25));
		setTitle("\u7528\u6237\u7BA1\u7406");
		setBounds(250, 150, 900, 617);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u5361\u53F7:");
		lblNewLabel.setIcon(new ImageIcon(UsersManageFrm.class.getResource("/images/\u5361\u53F7.png")));
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 25));
		
		UserCardIDTextField = new JTextField();
		UserCardIDTextField.setFont(new Font("楷体", Font.BOLD, 25));
		UserCardIDTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Users user=new Users();
				user.setClassId(UserCardIDTextField.getText().toString());
				selectB(user);
			}
		});
		searchButton.setIcon(new ImageIcon(UsersManageFrm.class.getResource("/images/\u7CFB\u7EDF\u7BA1\u7406-\u7528\u6237\u67E5\u8BE2.png")));
		searchButton.setFont(new Font("楷体", Font.BOLD, 25));
		
		JLabel label = new JLabel("\u7528\u6237\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(UsersManageFrm.class.getResource("/images/\u771F\u5B9E\u59D3\u540D.png")));
		label.setFont(new Font("楷体", Font.BOLD, 25));
		
		editUserNameTextField = new JTextField();
		editUserNameTextField.setFont(new Font("楷体", Font.BOLD, 24));
		editUserNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u5361\u53F7:");
		label_1.setIcon(new ImageIcon(UsersManageFrm.class.getResource("/images/\u5361\u53F7.png")));
		label_1.setFont(new Font("楷体", Font.BOLD, 25));
		
		editUserCardIDTextField = new JTextField();
		editUserCardIDTextField.setFont(new Font("楷体", Font.BOLD, 24));
		editUserCardIDTextField.setColumns(10);
		
		JButton deleteUserButton = new JButton("\u5220\u9664\u8BE5\u7528\u6237");
		deleteUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				delectUser(arg0);
			}
		});
		deleteUserButton.setIcon(new ImageIcon(UsersManageFrm.class.getResource("/images/\u5220\u96641.png")));
		deleteUserButton.setFont(new Font("楷体", Font.BOLD, 25));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(182)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(UserCardIDTextField, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
							.addGap(65)
							.addComponent(searchButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(135)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addGap(18)
									.addComponent(editUserNameTextField))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addGap(18)
									.addComponent(editUserCardIDTextField, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
							.addComponent(deleteUserButton)))
					.addContainerGap(160, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(109)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 676, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(99, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(UserCardIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(editUserNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(editUserCardIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(57)
							.addComponent(deleteUserButton)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		
		userUtiltable = new JTable();
		userUtiltable.setFont(new Font("楷体", Font.PLAIN, 20));
		userUtiltable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel dft = (DefaultTableModel) userUtiltable.getModel();
				editUserNameTextField.setText(dft.getValueAt(userUtiltable.getSelectedRow(), 1).toString());
				editUserCardIDTextField.setText(dft.getValueAt(userUtiltable.getSelectedRow(), 3).toString());
			}
		});
		userUtiltable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7528\u6237ID", "\u7528\u6237\u59D3\u540D", "\u7528\u6237\u6027\u522B", "\u7528\u6237\u5361\u53F7"
			}
		));
		scrollPane.setViewportView(userUtiltable);
		getContentPane().setLayout(groupLayout);
		selectB(new Users());
	}
	protected void delectUser(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "您确定删除么？") != JOptionPane.OK_OPTION){
			return;
		}
		int index=userUtiltable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(this, "请选中要删除的数据!");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) userUtiltable.getModel();
		int id=Integer.parseInt(dft.getValueAt(userUtiltable.getSelectedRow(), 0).toString());
		UsersDao stockDao=new UsersDao();
		if(stockDao.delete(id)) 
		{
			JOptionPane.showMessageDialog(this, "删除成功!");
		}else 
		{
			JOptionPane.showMessageDialog(this, "删除失败!");
		}
		selectB(new Users());
	}

	protected void selectB(Users student) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) userUtiltable.getModel();
		dft.setRowCount(0);
		UsersDao studentDao = new UsersDao();
		List<Users> studentList = studentDao.getStudentList(student);
		for (Users s : studentList) {
			Vector v = new Vector();
			v.add(s.getId());
			v.add(s.getName());
			v.add(s.getSex());
			v.add(s.getClassId());
			dft.addRow(v);
		}
		studentDao.closeDao();
	}


}
