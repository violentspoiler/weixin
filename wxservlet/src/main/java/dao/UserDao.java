package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import JDBCUtils.DataSourceUtils;

import pojo.User;
/**
 * 
 * @author 韶琪
 *
 */


public class UserDao {
	/**
	 * 
	 * @param user
	 * @throws SQLException
	 */
	// 添加用户操作
	public void addUser(User user) throws SQLException {
		// 1.创建QueryRunner
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		// 2.执行sql语句
		String sql = "insert into user values(?,?)";
		runner.update(sql, user.getUserId(),user.getCash());
	}
	/**
	 * 
	 * @param userId 用户id
	 * @return	     从数据库中返回用户相关数据
	 * @throws SQLException
	 */
	//查询用户/登录
	public User findUserByUserId(String userId) throws SQLException {
		// 1.创建QueryRunner
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		// 2.执行sql语句
		String sql = "select * from user where userId=?";
		return runner.query(sql, new BeanHandler<User>(User.class), userId);
	}
	/**
	 * 
	 * @param userId 用户id
	 * @param cash 	 充值的金额
	 * @throws SQLException
	 */
	//充值
	public void addBlance(String userId,double cash) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="UPDATE USER SET cash=cash+? where userId=?;";
		runner.update(sql, cash,userId);
	}
	/**
	 * 
	 * @param userId 用户id
	 * @param cash 	 消费的金额
	 * @throws SQLException
	 */
	//消费
	public void minusBlance(String userId,Double cash) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="UPDATE USER SET cash=cash-? where userId=?;";
		runner.update(sql, cash,userId);
	}
}
