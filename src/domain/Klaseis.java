package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Klaseis {
	
	
	
	private int telos=0;
	private int i;
	private int arxi=0;
	private String klasi;
	private GetMethods map = new GetMethods();
	private Map<String, List<Methods>> map1 = map.getMethods();
	private Set<String> keys = map1.keySet();		
	private TreeSet<String> set=new TreeSet<>();
	
	
	
	
	
	public TreeSet<String> getKlaseis() {
		
		
		
		 for(String key: keys){
			 if(key.contains("$"))
				 continue;
			 for (i=0; i<key.length();i++){
					if (Character.isUpperCase(key.charAt(i))){
						arxi=i;
						break;
						}
				}
				for (i=arxi; i<key.length();i++){
					if( key.charAt(i) == '.')
					{
						telos=i;	
						break;
					}
				}
		
				klasi = key.substring(arxi,telos);
				set.add(klasi);
		 	}
				
				
					
					
					
					
			 return set;
					
	}
		public Map<String,List<Methods>> createList(TreeSet<String> set){
			
			List<Methods> methods;	
			Methods method;
			Map<String, List<Methods>> map2 = new HashMap<>();
			Iterator<String> iterator = set.iterator();
			
			while (iterator.hasNext()) 											
				map2.put(iterator.next(),new ArrayList<Methods>());	
			
			keys = map2.keySet();
			iterator = set.iterator();
			for(String key : keys){
				for(String s1 : set){
					methods=map2.get(key);
					method = new Methods(s1,0);	
					methods.add(method);
				}
			}
			
				return map2;
				}
			
			
			
			
		}
		
	

