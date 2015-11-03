package myBeans;

import javax.ejb.Remote;

@Remote
public interface HBFSessionRemote {
		public String test(String to);
}
