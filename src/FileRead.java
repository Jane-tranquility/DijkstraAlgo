import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FileRead {
private String file;
	
	public FileRead(String fileIn){
		this.file=fileIn;
	}
	
	public String getFile(){
		return file;
	}
	
	public HashMap<String, List<Pair>> readFile() throws IOException{
		Scanner scan;
		scan = new Scanner(new File(getFile()));
		
		int number=Integer.parseInt(scan.nextLine());
		int temp=65;
		
		HashMap<String, List<Pair>> adjascencyList=new HashMap<String, List<Pair>>();
		for (int i=0;i<number;i++){
			adjascencyList.put(Character.toString((char)(temp+i)), new ArrayList<Pair>());
		}
		while (scan.hasNextLine()){
			String s=scan.nextLine();
			String[] splits=s.split(" ");
			Pair pair=new Pair(splits[1], Integer.parseInt(splits[2]));
			adjascencyList.get(splits[0]).add(pair);
		}
		
		scan.close();
		return adjascencyList;
	}
}
