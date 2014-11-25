import java.net.InetAddress;
import java.net.UnknownHostException;

public class Hostowe {

	/**
	 * @param args
	 */
	public static void getHost_IP(){
		
		InetAddress localHost;
		String[] localIP;
		String[] mcast;
		int octets;
		int i=0;
		try {
			localHost = InetAddress.getLocalHost();
			// System.out.println(localHost.getHostName());
			if (localHost.getHostAddress().equals("127.0.0.1")) {
				System.out.println("That's 127.0.0.1! Needs to be something else.");
			} else {
                                if(!localHost.getHostAddress().contains(".")) {
                                    System.err.println("There is no ipv4 address");
                                    return;
                                }
				localIP = localHost.getHostAddress().split("[.]",4);
			        mcast = System.getProperty("mcast.addr").split("[.]",4);
				octets = Integer.getInteger("addr.octets").intValue();
				for (i=0;i<octets;i++) {
                                        System.out.print(mcast[i]);
					if (i < 3) System.out.print(".");
				}
				for (i=octets;i<4;i++) {
                                        System.out.print(localIP[i]);
					if (i < 3) System.out.print(".");
				}
				System.out.println();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}	
		 
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     getHost_IP();
	}

}
