package myBeans;

import javax.ejb.Remote;

@Remote
public interface HBFSessionRemote {
		public String test(String id);
		public void addMoney(String id, float money);
		public String transfer(String id, String from, String to, float amount);
		public String pullCash(String id, float amount);
}
