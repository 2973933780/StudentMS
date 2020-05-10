package com.liu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.util.List;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.liu.dao.StockDao;
import com.liu.model.Stock;
import com.liu.util.StringUtil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StockManageFrm extends JInternalFrame {

	private JPanel contentPane;
	private JTextField StockNameTextField;
	private JTable StockTable;
	private JTextField editStockNameTextField;
	private JTextField editStockInfoTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockManageFrm frame = new StockManageFrm();
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
	public StockManageFrm() {
		setFrameIcon(new ImageIcon(StockManageFrm.class.getResource("/images/\u81EA\u6211\u4ECB\u7ECD.png")));
		setTitle("\u8FDB\u8D27\u4FE1\u606F\u7BA1\u7406");
		setBounds(250, 100, 874, 704);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true);
		setIconifiable(true);
		JLabel label = new JLabel("\u8FDB\u8D27\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon(StockManageFrm.class.getResource("/images/\u540D\u79F0.png")));
		label.setFont(new Font("楷体", Font.BOLD, 30));
		
		StockNameTextField = new JTextField();
		StockNameTextField.setFont(new Font("楷体", Font.BOLD, 24));
		StockNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			//添加的查询事件
			public void actionPerformed(ActionEvent arg0) 
			{
				Stock sc=new Stock();
				sc.setName(StockNameTextField.getText().toString());
				setTable(sc);
			}
		});
		searchButton.setIcon(new ImageIcon(StockManageFrm.class.getResource("/images/\u67E5\u8BE21.png")));
		searchButton.setFont(new Font("楷体", Font.BOLD, 30));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_1 = new JLabel("\u8FDB\u8D27\u540D\u79F0\uFF1A");
		label_1.setIcon(new ImageIcon(StockManageFrm.class.getResource("/images/\u540D\u79F0.png")));
		label_1.setFont(new Font("楷体", Font.BOLD, 25));
		
		editStockNameTextField = new JTextField();
		editStockNameTextField.setFont(new Font("宋体", Font.BOLD, 20));
		editStockNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8FDB\u8D27\u4FE1\u606F\uFF1A");
		label_2.setIcon(new ImageIcon(StockManageFrm.class.getResource("/images/\u4FE1\u606F.png")));
		label_2.setFont(new Font("楷体", Font.BOLD, 25));
		
		editStockInfoTextField = new JTextField();
		editStockInfoTextField.setFont(new Font("宋体", Font.BOLD, 20));
		editStockInfoTextField.setColumns(10);
		
		JButton subitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		subitEditButton.setIcon(new ImageIcon(StockManageFrm.class.getResource("/images/\u63D0\u4EA41.png")));
		subitEditButton.addActionListener(new ActionListener() {
			//确认修改事件
			public void actionPerformed(ActionEvent arg0) {
				submitEditAct(arg0);
			}
		});
		subitEditButton.setFont(new Font("楷体", Font.BOLD, 25));
		
		JButton subeditDeleteButton = new JButton("\u5220\u9664\u4FE1\u606F");
		subeditDeleteButton.setIcon(new ImageIcon(StockManageFrm.class.getResource("/images/\u5220\u96641.png")));
		subeditDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteStockAct(arg0);
			}
		});
		subeditDeleteButton.setFont(new Font("楷体", Font.BOLD, 25));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(78)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(StockNameTextField, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
									.addGap(60)
									.addComponent(searchButton))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(editStockInfoTextField, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(editStockNameTextField)))
									.addPreferredGap(ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(subeditDeleteButton)
										.addComponent(subitEditButton))
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(97)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 643, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(StockNameTextField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(editStockNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(subitEditButton))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2)
								.addComponent(editStockInfoTextField, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(148)
							.addComponent(subeditDeleteButton)))
					.addGap(137))
		);
		
		StockTable = new JTable();
		StockTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedTableRow(arg0);
			}
		});
		StockTable.setFont(new Font("楷体", Font.BOLD, 20));
		StockTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8FDB\u8D27\u7F16\u53F7", "\u8FDB\u8D27\u540D\u79F0", "\u8FDB\u8D27\u8D27\u54C1\u4FE1\u606F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		StockTable.getColumnModel().getColumn(0).setPreferredWidth(85);
		StockTable.getColumnModel().getColumn(1).setPreferredWidth(85);
		StockTable.getColumnModel().getColumn(2).setPreferredWidth(342);
		scrollPane.setViewportView(StockTable);
		contentPane.setLayout(gl_contentPane);
		setTable(new Stock());
	}
	//删除的方法
	protected void deleteStockAct(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "您确定删除么？") != JOptionPane.OK_OPTION){
			return;
		}
		int index=StockTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(this, "请选中要删除的数据!");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) StockTable.getModel();
		int id=Integer.parseInt(dft.getValueAt(StockTable.getSelectedRow(), 0).toString());
		StockDao stockDao=new StockDao();
		if(stockDao.delete(id)) 
		{
			JOptionPane.showMessageDialog(this, "删除成功!");
		}else 
		{
			JOptionPane.showMessageDialog(this, "删除失败!");
		}
		setTable(new Stock());
	}

	//确认修改的方法
	protected void submitEditAct(ActionEvent arg0) {
		// TODO Auto-generated method stub
		StockDao stockDao=new StockDao();
		int index=StockTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(this, "请选中要修改的数据!");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) StockTable.getModel();
		String stockname=dft.getValueAt(StockTable.getSelectedRow(), 1).toString();
		String stockinfo=dft.getValueAt(StockTable.getSelectedRow(), 2).toString();
		String editStockName=editStockNameTextField.getText().toString();
		String editStockInfo=editStockInfoTextField.getText().toString();
		if(StringUtil.isEmpty(editStockName)) 
		{
			JOptionPane.showMessageDialog(this, "请填写要修改的数据名称!");
			return;
		}
		if(stockname.equals(editStockName) && stockinfo.equals(editStockInfo)) 
		{
			JOptionPane.showMessageDialog(this, "您还没有做任何修改!");
			return;
		}
		int id=Integer.parseInt(dft.getValueAt(StockTable.getSelectedRow(), 0).toString());
		StockDao stockdao=new StockDao();	
		Stock sc=new Stock();
		sc.setId(id);
		sc.setName(editStockName);
		sc.setInfo(editStockInfo);
		if(stockdao.update(sc)) 
		{
			JOptionPane.showMessageDialog(this, "修改成功！");
		}
		else 
		{
			JOptionPane.showMessageDialog(this, "修改失败！");
		}
		
	}

	protected void selectedTableRow(MouseEvent arg0) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) StockTable.getModel();
		editStockNameTextField.setText(dft.getValueAt(StockTable.getSelectedRow(), 1).toString());
		editStockInfoTextField.setText(dft.getValueAt(StockTable.getSelectedRow(), 2).toString());
		
	}

	private void setTable(Stock studentClass){
		DefaultTableModel dft = (DefaultTableModel) StockTable.getModel();
		dft.setRowCount(0);
		StockDao classDao = new StockDao();
		List<Stock> classList = classDao.getClassList(studentClass);
		for (Stock sc : classList) {
			Vector v = new Vector();
			v.add(sc.getId());
			v.add(sc.getName());
			v.add(sc.getInfo());
			dft.addRow(v);
		}
	}
}
