package com.liu.view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.liu.model.UserType;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.Toolkit;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JLabel;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	public static UserType userType;
	public static Object userObject;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public MainFrm(UserType userType,Object userObject) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/images/\u6D17\u53D1\u6C34-01.png")));
		this.userType=userType;
		this.userObject=userObject;
		setTitle("\u9500\u552E\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 1000);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		setLocationRelativeTo(null);
		JMenu menu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menu.setFont(new Font("楷体", Font.PLAIN, 25));
		menu.setForeground(new Color(0, 0, 0));
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7CFB\u7EDF.png")));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editPassword(ae);
			}
		});
		menuItem.setFont(new Font("楷体", Font.PLAIN, 23));
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u78011.png")));
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_1.addActionListener(new ActionListener() {
			//退出系统
			public void actionPerformed(ActionEvent ae) {
				if(JOptionPane.showConfirmDialog(MainFrm.this, "确定退出系统吗？")==JOptionPane.OK_OPTION) 
				{
					System.exit(0);
				}
			}
		});
		menuItem_1.setFont(new Font("楷体", Font.PLAIN, 23));
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9000\u51FA1.png")));
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u9500\u552E\u7BA1\u7406");
		menu_1.setForeground(Color.BLACK);
		menu_1.setFont(new Font("楷体", Font.PLAIN, 25));
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9500\u552E\u53D1\u8D27 (1).png")));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u9500\u552E\u6DFB\u52A0");
		menuItem_2.setFont(new Font("楷体", Font.PLAIN, 23));
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6D17\u53D1\u6C34-01.png")));
		menu_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u9500\u552E\u5217\u8868");
		menuItem_3.setFont(new Font("楷体", Font.PLAIN, 23));
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6D17\u53D1\u6C34.png")));
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_9 = new JMenuItem("\u67E5\u8BE2\u8BA2\u5355");
		menuItem_9.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u67E5\u8BE21.png")));
		menuItem_9.setFont(new Font("楷体", Font.PLAIN, 23));
		menu_1.add(menuItem_9);
		
		JMenu menu_2 = new JMenu("\u8FDB\u8D27\u7BA1\u7406");
		menu_2.setForeground(Color.BLACK);
		menu_2.setFont(new Font("楷体", Font.PLAIN, 25));
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6210\u54C1\u4ED3\u5E93.png")));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_4 = new JMenuItem("\u8FDB\u8D27\u6DFB\u52A0");
		menuItem_4.addActionListener(new ActionListener() {
			//进货添加事件响应
			public void actionPerformed(ActionEvent ae) {
				addStock(ae);
			}
		});
		menuItem_4.setFont(new Font("楷体", Font.PLAIN, 23));
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6D17\u53D1\u6C34.png")));
		menu_2.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u8FDB\u8D27\u5217\u8868");
		menuItem_5.addActionListener(new ActionListener() {
			//进货列表响应函数
			public void actionPerformed(ActionEvent arg0) {
				StockManageFrm stockManageFrm=new StockManageFrm(); 
				stockManageFrm.setVisible(true);
				desktopPane.add(stockManageFrm);
			}
		});
		menuItem_5.setFont(new Font("楷体", Font.PLAIN, 23));
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6D17\u53D1\u6C34 (1).png")));
		menu_2.add(menuItem_5);
		
		JMenu menu_4 = new JMenu("\u7528\u6237\u7BA1\u7406");
		menu_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u767B\u5F556.png")));
		menu_4.setFont(new Font("楷体", Font.PLAIN, 25));
		menu_4.setForeground(new Color(0, 0, 0));
		menuBar.add(menu_4);
		
		JMenuItem menuItem_7 = new JMenuItem("\u6DFB\u52A0\u7528\u6237");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addUser(ae);
			}
		});
		menuItem_7.setFont(new Font("楷体", Font.PLAIN, 24));
		menuItem_7.setIcon(new ImageIcon(MainFrm.class.getResource("/images/1\u4EBA\u5458\u7BA1\u7406.png")));
		menu_4.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("\u7528\u6237\u67E5\u8BE2");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Userselect(arg0);
			}
		});
		menuItem_8.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7CFB\u7EDF\u7BA1\u7406-\u7528\u6237\u67E5\u8BE2.png")));
		menuItem_8.setFont(new Font("楷体", Font.PLAIN, 24));
		menu_4.add(menuItem_8);
		
		JMenu menu_3 = new JMenu("\u5E2E\u52A9");
		menu_3.setForeground(Color.BLACK);
		menu_3.setFont(new Font("楷体", Font.PLAIN, 25));
		menu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5E2E \u52A9.png")));
		menuBar.add(menu_3);
		
		JMenuItem menuItem_6 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_6.setFont(new Font("楷体", Font.PLAIN, 24));
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
				aboutUs(ae);
				
			}
		});
		menuItem_6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC1.png")));
		menu_3.add(menuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.addAncestorListener(new AncestorListener() {
			//画布消息响应，未使用
			public void ancestorAdded(AncestorEvent arg0) {
			}
			public void ancestorMoved(AncestorEvent arg0) {
				
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		desktopPane.setBackground(Color.PINK);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u6D17\u53D1\u6C34\u5927\u5356");
		label.setForeground(Color.CYAN);
		label.setFont(new Font("楷体", Font.BOLD, 46));
		label.setBounds(620, 355, 385, 183);
		desktopPane.add(label);
		setLocationRelativeTo(null);
	}

	protected void Userselect(ActionEvent arg0) {
		// TODO Auto-generated method stub
		UsersManageFrm umf=new UsersManageFrm();
		umf.setVisible(true);
		desktopPane.add(umf);
	}

	protected void addUser(ActionEvent ae) {
		// TODO Auto-generated method stub
		AddUsersFrm auf=new AddUsersFrm();
		auf.setVisible(true);
		desktopPane.add(auf);
	}

	protected void addStock(ActionEvent ae) {
		// TODO Auto-generated method stub
		StockFrm sca=new StockFrm(); 
		sca.setVisible(true);
		desktopPane.add(sca);
	}

	protected void editPassword(ActionEvent ae) {
		// TODO Auto-generated method stub
		EditPasswordFrm editPasswordFrm = new EditPasswordFrm();
		editPasswordFrm.setVisible(true);
		desktopPane.add(editPasswordFrm);
	}

	protected void aboutUs(ActionEvent ae) {
		// TODO Auto-generated method stub
		String info ="欢迎您使用该系统！！！\n";
		info +="愿为您提供最好的服务！\n";
		info +="最好的防脱发洗发水！！！";
		//JOptionPane.showMessageDialog(this,info);
		String[] buttons = {"迫不及待去看看!","心情不好以后再说!"};
		int ret=JOptionPane.showOptionDialog(this, info,"关于我们", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, new ImageIcon(LoginFrm.class.getResource("/images/logo.png")), buttons, null);
		if(ret==0) 
		{
			try {
				URI uri = new URI("https://s.taobao.com/search?q=%E9%98%B2%E8%84%B1%E5%8F%91%E6%B4%97%E5%8F%91%E6%B0%B4&imgfile=&commend=all&ssid=s5-e&search_type=item&sourceId=tb.index&spm=a21bo.2017.201856-taobao-item.1&ie=utf8&initiative_id=tbindexz_20170306");
				Desktop.getDesktop().browse(uri);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else 
		{
			JOptionPane.showMessageDialog(this, "你真是狠心，坏淫！");
		}
	}
}
