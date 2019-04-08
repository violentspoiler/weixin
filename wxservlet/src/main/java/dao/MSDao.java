package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import JDBCUtils.DataSourceUtils;
import pojo.ManSong;

public class MSDao {
	// 添加满送操作			
			public void addManSong(ManSong manSong) throws SQLException {
				// 1.创建QueryRunner
				QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
				// 2.执行sql语句
				String sql = "INSERT INTO mansong VALUE(NULL,?,?,?);";
				runner.update(sql,manSong.getMaster().getMasterId(),manSong.getMan(),manSong.getSong() );
			}
			//满送获取(单店)
			public double findManSongByManSongId(double manCash) throws SQLException {
				// 1.创建QueryRunner
				QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
				// 2.执行sql语句
				String sql = "SELECT song FROM mansong WHERE man-?<0 ORDER BY ABS(man-?) LIMIT 1;";
				return (double)runner.query(sql, new BeanHandler<Double>(Double.class),manCash,manCash);
			}
			//修改满song
			public void changeMS(ManSong manSong) throws SQLException {
				QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
				// 2.执行sql语句
				String sql = "UPDATE mansong SET man=?,song=? WHERE msid=5;";
				runner.update(sql,manSong.getMan(),manSong.getSong(),manSong.getMsId() );
			}
			/**
			 * 
			 * @return 返回所有满送信息
			 * @throws SQLException
			 */
			public List<ManSong> findAllManSongByManSongId() throws SQLException {
				// 1.创建QueryRunner
				QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
				// 2.执行sql语句
				String sql = "SELECT * FROM mansong;";
				return runner.query(sql, new BeanListHandler <ManSong>(ManSong.class));
			}
}
