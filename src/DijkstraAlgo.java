import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class DijkstraAlgo {
	public static void AlgoCalculate(HashMap<String, List<Pair>> adjascencyList){
		HashMap<String, Integer> distance=new HashMap<String, Integer >();
		HashMap<String, String> parent=new HashMap<String, String>();
		HashMap<String, Boolean> check=new HashMap<String, Boolean>();
		
		int size=adjascencyList.size();
		PriorityQueue<Pair> heap=new PriorityQueue<Pair>(size);
		
		Set<String> vertices=adjascencyList.keySet();
		for (String vertex: vertices){
			distance.put(vertex, Integer.MAX_VALUE);
			parent.put(vertex, null);
			check.put(vertex,true);
		}
		distance.put("A", 0);
		for (String vertex: vertices){
			Pair pair=new Pair(vertex,distance.get(vertex));
			heap.add(pair);
		}
		
		
		/*for (String str: distance.keySet()){
			System.out.println("vertex"+str+": "+distance.get(str));
		}*/
		
		while (heap.size()!=0){
			Pair head=heap.poll();
			check.put(head.getEndVertex(), false);
			String vertex=head.getEndVertex();
			int dis=head.getWeight();
			List<Pair> neighbours=adjascencyList.get(vertex);
			for (Pair pair:neighbours){
				if ((distance.get(pair.getEndVertex())>(dis+pair.getWeight()))&&(check.get(pair.getEndVertex())==true)){
					distance.put(pair.getEndVertex(), (dis+pair.getWeight()));
					//for (Pair pairInQueue:heap){
						
						/*for (String str: distance.keySet()){
							System.out.println("vertex"+str+": "+distance.get(str));
						}*/
						
						//if (heap.getEndVertex()==pair.getEndVertex()){
							heap.remove(pair);
							Pair pairNew=new Pair(pair.getEndVertex(),distance.get(pair.getEndVertex()));
							heap.add(pairNew);
						//}
						
						/*for (String str: distance.keySet()){
							System.out.println("vertex"+str+": "+distance.get(str));
						}*/
						
					//}
					parent.put(pair.getEndVertex(), vertex);
		
				}
				
			}
		}
		
		/*for (String str: distance.keySet()){
			System.out.println("vertex"+str+": "+distance.get(str));
		}*/
		System.out.println(distance.get("B"));
		
		Stack<String> stack=new Stack<String>();
		stack.push("B");
		String temp=stack.push(parent.get("B"));
		while (temp!=null){
			temp=stack.push(parent.get(temp));
		}
		stack.pop();
		while (!stack.isEmpty()){
			System.out.print(stack.pop());
		}
		System.out.print("\n");
		
		
	}
}
