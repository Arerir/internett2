package myBeans;

import javax.ejb.Remote;

@Remote
public interface HBFSessionRemote {
		public String test(String id);
		public void addMoney(String id, float money);
}
