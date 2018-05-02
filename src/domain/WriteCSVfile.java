package domain;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.opencsv.CSVWriter;

public class WriteCSVfile {

	
	private CSVWriter writer = null;
	
	
	private String csvFile = "C:/1/output.csv";
	private Results k = new Results();
	private Map<String,List<Methods>> map = k.getSum();	
	private String headers=null;
	private List<String[]> list=new ArrayList<>();
	private Klaseis l = new Klaseis();
	private TreeSet<String> tree = l.getKlaseis();
	private String[] h=null;
	private String [] rows=new String[tree.size()+1];
	private int i=0;
	private int j=0;
	private List<Methods> methods;
	
	
	
	public void writeCSVfile() {
	
		
	try {
			System.out.println("Writing file..");
			writer = new CSVWriter(new FileWriter(csvFile));
			
			h=tree.toArray(new String[tree.size()]);			
			headers=Arrays.toString(h);
			headers=headers.substring(1, headers.length()-1);
			headers = "Class Name"+", "+headers;
			
			rows[0]=headers;
			
			
			for(String key : tree)
			{	j+=1;
				rows[j]=key+", ";				
				methods=map.get(key);
				for(i=0;i<methods.size();i++)
					rows[j]=rows[j]+String.valueOf(methods.get(i).getMs())+", ";			
				
			}
			
			for(i=0;i<rows.length;i++)
				list.add(new String[] {rows[i]});
			
			writer.writeAll(list);
			
			writer.close();
	
			System.out.println("File ready.");
			
			
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	
	
		
	}
	}
	
	
	
}
