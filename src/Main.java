import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] fnames={"Case1.txt","Case2.txt","Case3.txt"};
		
		for (String fname: fnames){
			HashMap<String, List<Pair>> adjascencyList;	
			try{
				FileRead file=new FileRead(fname);
				adjascencyList=file.readFile();
				//System.out.print(adjascencyList.keySet());
				DijkstraAlgo.AlgoCalculate(adjascencyList);
			
			}
		    catch(IOException e){
		    	System.out.println("ERROR: file opening error for " + fname);
			    e.printStackTrace();
			    System.exit(0);
		    }
			
			
		}
	}

}
