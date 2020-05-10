package com.liu.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.liu.dao.StockDao;
import com.liu.model.Stock;
import com.liu.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StockFrm extends JInternalFrame {

	private JPanel contentPane;
	private JTextField stockNameTextField;
	private JTextField stockInfoTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockFrm frame = new StockFrm();
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
	public StockFrm() {
		setFrameIcon(new ImageIcon(StockFrm.class.getResource("/images/\u81EA\u6211\u4ECB\u7ECD.png")));
		setTitle("\u6DFB\u52A0\u8FDB\u8D27\u4FE1\u606F");
		setBounds(350, 150, 700, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true);
		setIconifiable(true);
		JLabel label = new JLabel("\u8FDB\u8D27\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon(StockFrm.class.getResource("/images/\u540D\u79F0.png")));
		label.setFont(new Font("楷体", Font.PLAIN, 35));
		
		JLabel label_1 = new JLabel("\u8D27\u54C1\u4ECB\u7ECD\uFF1A");
		label_1.setIcon(new ImageIcon(StockFrm.class.getResource("/images/\u4FE1\u606F2.png")));
		label_1.setFont(new Font("楷体", Font.PLAIN, 35));
		
		stockNameTextField = new JTextField();
		stockNameTextField.setFont(new Font("楷体", Font.PLAIN, 30));
		stockNameTextField.setColumns(10);
		
		stockInfoTextField = new JTextField();
		stockInfoTextField.setFont(new Font("楷体", Font.PLAIN, 30));
		stockInfoTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u63D0\u4EA4");
		submitButton.addActionListener(new ActionListener() {
			//添加的提交按钮响应函数
			public void actionPerformed(ActionEvent arg0) 
			{
				submitstock(arg0);
			}
		});
		submitButton.setIcon(new ImageIcon(StockFrm.class.getResource("/images/\u63D0\u4EA41.png")));
		submitButton.setFont(new Font("楷体", Font.BOLD, 35));
		
		JButton restButton = new JButton("\u91CD\u7F6E");
		restButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				restValue(arg0);
			}
		});
		restButton.setIcon(new ImageIcon(StockFrm.class.getResource("/images/\u91CD\u7F6E2.png")));
		restButton.setFont(new Font("楷体", Font.BOLD, 35));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(84)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stockNameTextField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(submitButton)
								.addComponent(label_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(stockInfoTextField)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(restButton)
									.addGap(36)))))
					.addContainerGap(113, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(stockNameTextField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(stockInfoTextField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(submitButton)
						.addComponent(restButton))
					.addGap(30))
		);
		contentPane.setLayout(gl_contentPane);
	}
protected void submitstock(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String stockName=stockNameTextField.getText().toString();
		String stockInfo=stockInfoTextField.getText().toString();
		if(StringUtil.isEmpty(stockName)){
			JOptionPane.showMessageDialog(this, "进货的名称不能为空！");
			return;
		}
		if(StringUtil.isEmpty(stockInfo)){
			JOptionPane.showMessageDialog(this, "进货的信息不能为空！");
			return;
		}
		Stock scl =new Stock();
		scl.setName(stockName);
		scl.setInfo(stockInfo);
		StockDao stockDao =new StockDao();
		if(stockDao.addStock(scl)) 
		{
			JOptionPane.showMessageDialog(this, "进货信息添加成功！");
		}else{
			JOptionPane.showMessageDialog(this, "进货信息添加失败！");
		}
		restValue(arg0);
	}

//插入进货信息的重置实现
	protected void restValue(ActionEvent arg0) {
		// TODO Auto-generated method stub
		stockNameTextField.setText("");
		stockInfoTextField.setText("");
		
	}
}
