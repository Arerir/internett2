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
    	card1.add("12345678903");
    	cards.put("1111111111111111",card1);
    	
    	List<String> card2 = new ArrayList<String>();
    	card2.add("12345678902");
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
    
	@Override
	public String test(String id){
    	if (cards.containsKey(id)){
    		StringBuilder stb = new StringBuilder();
    		stb.append("ID: " + id);

    		for (int i = 0; i<cards.get(id).size();i++){
    			stb.append("\n" + cards.get(id).get(i) + ": " + accounts.get(cards.get(id).get(i)));
    		}
    		return stb.toString();
    	}
    	return "ID missmatch";
    }

	@Override
	public void addMoney(String id, float money){
    	if (accounts.containsKey(id)){
    		accounts.replace(id, money);
    	}
    }
	
    @Override
	public String transfer(String id, String from, String to, float amount){
    	if (cards.containsKey(id)){
    	if (accounts.containsKey(from)){
    		if (accounts.containsKey(to)){
    			if (accounts.get(from)>=amount){
    				accounts.replace(from, accounts.get(from)-amount);
    				accounts.replace(to, accounts.get(to)+amount);
    				return "Tranferring complete";
    			}else {
    				return "Insufficient founds";
    			}
    		}else {
    			return to + "is not in account list";
    		}
    	}else {
    		return from + "is not in account list";
    	}
    }
    	return "False ID";
    }

	@Override
	public String pullCash(String id, float amount) {
		// TODO Auto-generated method stub
		if (cards.containsKey(id)){
			if (accounts.get(cards.get(id).get(0))>=amount){
				accounts.replace(cards.get(id).get(0), accounts.get(cards.get(id).get(0))-amount);
				return "You just withdrew " + amount + " from your usage account.";
			}else {
				return "Insufficient founds";
			}
		}
		
		return "False ID";
	}
}
