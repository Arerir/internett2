package myBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HBFSession
 */
@Stateless
@LocalBean
public class HBFSession implements HBFSessionRemote {

	private List<String> cardId = new ArrayList<String>();
    /**
     * Default constructor. 
     */
    public HBFSession() {
    	cardId.add("12345678901");
    	cardId.add("12345678902");
    	cardId.add("12345678903");
    	cardId.add("12345678904");
    	cardId.add("12345678905");
    	cardId.add("12345678906");
    	cardId.add("12345678907");
    	cardId.add("12345678908");
    }
    public HBFSession(List<String> bankNumbers){
    	cardId = bankNumbers;
    }
    public String test(String to){
    	String retval = "test" + to;
    	for (int i = 0; i<cardId.size();i++){
    		if (cardId.get(i).equals(to)){
    			return retval;
    		}
    	}
    	return "ID missmatch";
    }

}
