package test;

import java.sql.SQLException;

import dao.UserDao;
import pojo.User;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			User user = new UserDao().findUserByUserId("b9d02dc2-2eba-4a15-bf7f-85146db75df8");
			System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
