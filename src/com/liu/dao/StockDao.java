package com.liu.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liu.model.Stock;
import com.liu.util.StringUtil;

//销售信息与数据库的操作
public class StockDao extends BaseDao {
	public boolean addStock(Stock scl) 
	{
		String sql="insert into s_stock values(null,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,scl.getName());
			preparedStatement.setString(2,scl.getInfo());
			//插入数据，如果插入成功就返回一个true
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false ;
	}
	
	//进货信息与数据库的操作
	public List<Stock> getClassList(Stock studentClass){
		List<Stock> retList = new ArrayList<Stock>();
		String sqlString = "select * from s_stock";
		if(!StringUtil.isEmpty(studentClass.getName())){
			sqlString += " where name like '%"+studentClass.getName()+"%'";
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Stock sc = new Stock();
				sc.setId(executeQuery.getInt("id"));
				sc.setName(executeQuery.getString("name"));
				sc.setInfo(executeQuery.getString("info"));
				retList.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id) 
	{
		String sql ="delete from s_stock where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate()>0) 
			{
				return true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(Stock sc) 
	{
		String sql ="update s_stock set name=?, info=? where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, sc.getName());
			preparedStatement.setString(2, sc.getInfo());
			preparedStatement.setInt(3, sc.getId());
			if(preparedStatement.executeUpdate()>0) 
			{
				return true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
