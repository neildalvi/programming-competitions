package codechef.challenge.dec2016;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TrainPartner {

	private Map<Short, Passenger> partnerMap = new HashMap<Short, Passenger>();

	public TrainPartner() {
		partnerMap.put((short)3, new Passenger((short)6, "UB"));
		partnerMap.put((short)2, new Passenger((short)5, "MB"));
		partnerMap.put((short)1, new Passenger((short)4, "LB"));
		partnerMap.put((short)7, new Passenger((short)8, "SU"));
		partnerMap.put((short)6, new Passenger((short)3, "UB"));
		partnerMap.put((short)5, new Passenger((short)2, "MB"));
		partnerMap.put((short)4, new Passenger((short)1, "LB"));
		partnerMap.put((short)8, new Passenger((short)7, "SL"));
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		TrainPartner obj = new TrainPartner();
		while(--t>=0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(obj.findPartner(n));
		}
	}

	public String findPartner(int n) {
		short reducedNo = (short)((n-1)%8+1);
		Passenger partner = partnerMap.get(reducedNo);
		return partner.getNo() + 8 * ((n-1)/8) + partner.getBerth();
	}
	
	class Passenger {
		private short no;
		private String berth;

		public Passenger(short no, String berth) {
			super();
			this.no = no;
			this.berth = berth;
		}

		public short getNo() {
			return no;
		}

		public String getBerth() {
			return berth;
		}
		
	}
}


