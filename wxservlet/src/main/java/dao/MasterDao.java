package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import JDBCUtils.DataSourceUtils;
import pojo.Master;

public class MasterDao {
	// 注册店主操作
		public void addMaster(String masterId) throws SQLException {
			// 1.创建QueryRunner
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			// 2.执行sql语句
			String sql = "insert into master values(?,null)";
			runner.update(sql,masterId);
		}
		//店主登录
		public Master findMasterByMasterId(String masterId) throws SQLException {
			// 1.创建QueryRunner
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			// 2.执行sql语句
			String sql = "select * from user where userId=?";
			return runner.query(sql, new BeanHandler<Master>(Master.class), masterId);
		}
}
