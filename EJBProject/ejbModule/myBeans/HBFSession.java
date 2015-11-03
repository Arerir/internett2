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
    private HashMap<String, List<String>> cards = new HashMap<String, List<String>>();
	/**
     * Default constructor. 
     */
    public HBFSession() {
    	List<String> card1 = new ArrayList<String>();
    	card1.add("12345678901");
    	card1.add("12345678902");
    	cards.put("1111111111111111",card1);
    	
    	List<String> card2 = new ArrayList<String>();
    	card2.add("12345678903");
    	card2.add("12345678904");
    	cards.put("2222222222222222",card2);
    	
    	accounts.put("12345678901", 0.0F);
    	accounts.put("12345678902", 200.0F);
    	accounts.put("12345678903", 19000.32F);
    	accounts.put("12345678904", 6000000.43F);
    }
    public HBFSession(HashMap<String,Float> accounts){
    	this.accounts = accounts;
    }
    public String test(String id){
    	if (cards.containsKey(id)){
    		StringBuilder stb = new StringBuilder();
    		stb.append("ID: " + id);
        	System.out.println(id);

    		for (int i = 0; i<cards.get(id).size();i++){
    			stb.append("\n" + cards.get(id).get(i) + ": " + accounts.get(cards.get(id).get(i)));
    		}
    		return stb.toString();
    	}
    	return "ID missmatch";
    }

    public void addMoney(String id, float money){
    	if (accounts.containsKey(id)){
    		accounts.replace(id, money);
    	}
    }
}
