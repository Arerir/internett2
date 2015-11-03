package myBeans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HBFSession
 */
@Stateless
@LocalBean
public class HBFSession implements HBFSessionRemote {

	private HashMap<String,Float> accounts = new HashMap<String,Float>();
    /**
     * Default constructor. 
     */
    public HBFSession() {
    	accounts.put("12345678901", 0.0F);
    	accounts.put("12345678902", 200.0F);
    	accounts.put("12345678903", 19000.32F);
    	accounts.put("12345678904", 6000000.43F);
    }
    public HBFSession(HashMap<String,Float> accounts){
    	this.accounts = accounts;
    }
    public String test(String to){
    	String retval = "test" + to;
    	for (int i = 0; i<accounts.size();i++){
    		if (accounts.containsKey(to)){
    			return retval;
    		}
    	}
    	return "ID missmatch";
    }

}
