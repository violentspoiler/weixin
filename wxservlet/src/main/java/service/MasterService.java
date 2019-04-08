package service;

import java.sql.SQLException;
import dao.MSDao;
import dao.MasterDao;
import dao.UserDao;


public class MasterService {
    private String appid = "wx1f8fe95a40e06a47";
    private String secretKey = "12f425fe324030a17a7c02ae3c10f017";
    SentURL sent=new SentURL(appid, secretKey);
    /**
     * 
     * @param code 用户code
     * @param method 要进行的操作   充值/消费
     * @param cash 金额
     * @throws NumberFormatException
     * @throws SQLException
     */
        public void doWhat(String code, String method, String cash) throws NumberFormatException, SQLException {
    		// TODO 根据传输来的code，method，cash进行充值/消费/注册操作
            if(method.equals("recharge")) {//充值
            	//recharge(code, new MSDao().findManSongByManSongId(Double.valueOf(cash))+Double.valueOf(cash));   
            	recharge(code, Double.valueOf(cash));
            }else if(method.equals("consume")) {//消费           	
    			consume(code, Double.valueOf(cash));
            }else if(method.equals("regist")) {//店长注册
        		new MasterDao().addMaster(sent.getIdFromDB(code));
        }
    	}	
        private void recharge(String code,double cash) throws SQLException {
        	//TODO 充值
        	cash=new MSDao().findManSongByManSongId(cash);
        	new UserDao().addBlance(sent.getIdFromDB(code), cash);
        }
        private void consume(String code,double cash) throws SQLException {
        	//TODO 消费
        	new UserDao().minusBlance(sent.getIdFromDB(code), cash);
        }
//        private void findMS() {
//        	
//        }
	    
}
