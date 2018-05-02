package domain;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class GetCalls {

	private String line=null;
	private String csvFile="C:/1/input.csv";
	private int i;
	
	
	public Map<String, List<Methods>> getCalls(){
		GetMethods map = new GetMethods();
		Map<String, List<Methods>> map1 = map.getMethods();
		Set<String> keys = map1.keySet();
		Stack<Integer> stoiva = new Stack<>();			
		int blanks = 0;		
		String csvsplitby=",";
		
		String [] grammi=null;			
		int i=0;
		
		Methods method ;
		String s;
		
		
		try{
			int mhkos=0;
			int arxi=0;
			long prevms;
			long ms;
			int size;
			boolean flag2;
			List<Methods> methods;
			RandomAccessFile br = new RandomAccessFile(csvFile,"rw");
	        for(String key: keys){
	        	
	        	
	        	
	        	while((line=br.readLine())!=null){
	        		
	        			
	        		
	        		
	        		
	        		if(stoiva.isEmpty() && line.contains(key)){
						blanks = countBlanks(line);
						stoiva.push(blanks+1);									
						continue;
					}
	        		if(accepted(line))
						blanks = countBlanks(line);													
					else continue;	
					
					
	 				if(!stoiva.isEmpty() && stoiva.peek()==blanks )
	 							{
								
								grammi = line.split(csvsplitby);
								
								char firstchar=grammi[2].charAt(0);
								if(firstchar == '"'){					//an exei extra quotes to keli ta afairei
									mhkos = grammi[2].length();
									grammi[2]=grammi[2].substring(1, mhkos-1);
								}
								for (i=0; i<grammi[0].length();i++){
									if (Character.isUpperCase(grammi[0].charAt(i))){
										arxi=i;
										break;
										}
								}
								s = grammi[0].substring(arxi,grammi[0].length()-1);								
								ms=Integer.parseInt(grammi[2]);							
								method = new Methods(s,ms);								
								methods= map1.get(key);
								if (methods.size()==0)									
									methods.add(method);								
								
								else {
									size=methods.size();									
									flag2=true;
									for(i=0;i<size;i++)
									{
										
										if(methods.get(i).getMethod_name().equals(s)){
											prevms=methods.get(i).getMs();											
											ms=(prevms+ms)/2;											
											methods.get(i).setMs(ms);											
											flag2=false;
											
										}
									}
									if(flag2)
										methods.add(method);										
									
								}
								

	 						}	
	 				if(!stoiva.isEmpty()&& stoiva.peek()<=blanks && line.contains(key) ) 	 				
						stoiva.push(blanks+1);
					
	 				
					
	 				if(!stoiva.isEmpty() && stoiva.peek()>blanks)
	 					stoiva.pop();
	 					
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        	}
	        	br.seek(0);
	        	
	        	
	        	
	        	
	           
	        }
	      
	        
	        

		    
			
		
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
	
	
	private int countBlanks(String s){
		int count =0;
		
		for (i=0;i<s.length() && !Character.isAlphabetic(s.charAt(i));i++){
			if(Character.isWhitespace(s.charAt(i)))
				count+=1;
		}
			
			
	
		return count;
		
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
		if(s.contains("sun.") || s.contains("com.sun.") || s.contains("sun.awt.")){
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
