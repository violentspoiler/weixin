package service;


import java.sql.SQLException;


import dao.UserDao;
import pojo.User;


public class UserService {
	    private String appid = "wx1f8fe95a40e06a47";
        private String secretKey = "12f425fe324030a17a7c02ae3c10f017";
        private String WeChat_biz = "MzIzOTU0NTQ0MA==";//公众号id
        SentURL sentURL=new SentURL(appid, secretKey);
        public String doWhat(String code) throws NumberFormatException, SQLException {
    		// TODO 根据传输来的code，method，cash进行注册操作
        	String userId=sentURL.getIdFromDB(code);
        	User user=null;
        	UserDao ud=new UserDao();
        	if(ud.findUserByUserId(userId)==null) {
        		
        		ud.addUser(new User(userId));
        		//注册获取公众号链接
        		return "https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz="+this.WeChat_biz+"#wechat_redirect";
        	}else {//登录获取余额
        		user=ud.findUserByUserId(userId);
        		double cash=user.getCash();
        		return cash+"";
        	}
        	
    	}
        
}