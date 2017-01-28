package codechef.challenge.jan2017;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CapitalMovementSoln {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder ans=new StringBuilder();
		
		while (T-- != 0) {

			int N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			long ar[] = new long[N];

			ArrayList<ArrayList<Integer>> as=new ArrayList<>();
			
			TreeMap<Long,Integer> tmap=new TreeMap<>();
			
			for (int i = 0; i < N; i++) {
				ar[i] = Long.parseLong(st.nextToken());
				tmap.put(ar[i],i);
				as.add(new ArrayList<Integer>());
			}
			
			
			
			for (int i = 0; i < N-1; i++) {
				st = new StringTokenizer(br.readLine());

				int u = Integer.parseInt(st.nextToken()) - 1;
				int v = Integer.parseInt(st.nextToken()) - 1;
				
				as.get(u).add(v);
				as.get(v).add(u);

			}
			for (int i = 0; i < N; i++) {
				TreeMap<Long,Integer> temp=new TreeMap<>();
				temp.put(ar[i], tmap.get(ar[i]));
				tmap.remove(ar[i]);
				
				
				for(Integer t:as.get(i)){
					tmap.remove(ar[t]);
					temp.put(ar[t],t);
				}
				
				if (tmap.isEmpty()) {
					//System.out.print(0 + " ");
					ans.append(0+" ");
				} else {
					//System.out.print((tmap.get(tmap.lastKey())+1) + " ");
					ans.append((tmap.get(tmap.lastKey())+1) + " ");
				}
				tmap.putAll(temp);
			}
			//System.out.println();
			ans.append("\n");
		}
		System.out.println(ans);
	}

}