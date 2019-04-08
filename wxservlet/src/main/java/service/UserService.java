package service;


import java.sql.SQLException;


import dao.UserDao;
import pojo.User;


public class UserService {
	    private String appid = "wx1f8fe95a40e06a47";
        private String secretKey = "12f425fe324030a17a7c02ae3c10f017";
        SentURL sentURL=new SentURL(appid, secretKey);
        public String doWhat(String code) throws NumberFormatException, SQLException {
    		// TODO 根据传输来的code，method，cash进行注册操作
        	User user=new User(sentURL.getIdFromDB(code));
        	UserDao ud=new UserDao();
        	if(ud.findUserByUserId(user.getUserId())==null) {
        		ud.addUser(user);
        		return "regist";
        	}
        	return "login";
    	}
        
}