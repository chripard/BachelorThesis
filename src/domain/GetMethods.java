package domain;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GetMethods {
	
	
	
	
	private String csvFile="C:/1/input.csv";
	
	private String line=null;
	private String csvsplitby=",";
	private String[] grammi=null;
	private boolean flag;
	
	
	
	
	public Map<String, List<Methods>> getMethods(){
		
		Map<String, List<Methods>> map1 = new HashMap<>();
		
		try{
			
			RandomAccessFile br = new RandomAccessFile(csvFile,"rw");
			
			
			
			line=br.readLine();
			line=br.readLine();	
			line=br.readLine();
			
			while ((line=br.readLine())!=null)
			{
				int i=0;
				int arxi=0;
				grammi = line.split(csvsplitby);
				flag=accepted(grammi[0]);
				if(flag){
					for (i=0; i<grammi[0].length();i++){
						if (Character.isUpperCase(grammi[0].charAt(i))){
							arxi=i;
							break;
							}
					}
					String s = grammi[0].substring(arxi,grammi[0].length()-1);
					List<Methods> methods= map1.get(s);
					
					if(methods==null)
						map1.put(s,methods=new ArrayList<Methods>());					
					
				
				}else continue;

			}		
				
				
				
			br.close();
			
			
			
	      
	     
			
			
			
		}catch (StringIndexOutOfBoundsException e){
			e.printStackTrace();
	  	}catch (FileNotFoundException e) {
			e.printStackTrace();
	  	}catch (NumberFormatException e){
	  		e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return map1;
		
		
	}
	
	
	
	private boolean accepted(String s){
		boolean flag =true;
		boolean hasUppercase= !s.equals(s.toLowerCase());
		if(!hasUppercase) 
			flag=false;
		if (s.contains("Self time")) 
			flag=false;		
		if(!s.contains("."))
			flag=false;
		if(s.contains("javax.") || s.contains("java.")){
			int paren1=s.indexOf('(');
			int paren2=s.indexOf(')');
			int kl=s.indexOf("java");
			if(kl<paren2 && kl>paren1)
				flag=true;	
			else flag=false;
			}
		if(s.contains("sun.") || s.contains("com.sun.") || s.contains("sunw.")){
			int paren3=s.indexOf('(');
			int paren4=s.indexOf(')');
			int kl1=s.indexOf(".sun.");
			if(kl1<paren4 && kl1>paren3)
				flag=true;
			else flag=false;
			}
		return flag;
		
	}
	
	
	
	
	
	
	
}
