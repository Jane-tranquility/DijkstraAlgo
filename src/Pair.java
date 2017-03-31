
public class Pair implements Comparable {
	private String endVertex;
	private int weight;
	
	public Pair(String endVertexIn, int weightIn){
		endVertex=endVertexIn;
		weight=weightIn;
	}
	

	public String getEndVertex(){
		return endVertex;
	}
	
	public int getWeight(){
		return weight;
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Pair pair=(Pair) o;
		if (weight<pair.weight){
			return -1;
		}
		else if (weight>pair.weight){
			return 1;
		}
		else return 0;
	}
}
