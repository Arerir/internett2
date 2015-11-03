package clients;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import myBeans.*;

public class SimpleClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, 
				"org.apache.openejb.client.RemoteInitialContextFactory");
		Context context = new InitialContext(props);
		HBFSessionRemote hbfRemote = (HBFSessionRemote) context.lookup("HBFSessionRemote");
		System.out.println(hbfRemote.test("this"));
		System.out.println(hbfRemote.test("1111111111111111"));
	}

}
