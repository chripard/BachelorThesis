package domain;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;



public class MergeFiles {
	
	
	
	CSVReader reader = null;
	CSVWriter writer = null;
	
	
	public void mergeFiles(String directory_name){
		File dir = new File(directory_name);
		String[] list = dir.list(new FilenameFilter() {

		    @Override

		    public boolean accept(File dir, String name) {

		        return name.toLowerCase().endsWith(".csv");

		    }

		});
		if(list.length==0){
			System.out.println("No .csv files found.\nExit.");
			System.exit(1);
			
		}
			
		try {
		String inputpath="C:/1/input.csv";
		File csvFile = new File(inputpath);
		
		String [] path=new String[list.length];
		for(int i=0;i<list.length;i++)
			path[i]=directory_name+"/"+list[i];	
		
		writer = new CSVWriter(new FileWriter(csvFile));
		
		for(int i=0;i<path.length;i++){
			
	
			reader = new CSVReader(new FileReader(path[i]));
			List<String[]> rows = reader.readAll();
			writer.writeAll(rows);
		
		
		}
			reader.close();
			writer.close();
		
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		
		
			
		}
		
		
		
		
		
		
	}
	
	
	
}
