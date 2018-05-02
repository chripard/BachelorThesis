package domain;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Results {

	private GetCalls map = new GetCalls();
	private Map<String, List<Methods>> map1 = map.getCalls();
	private Set<String> methkeys = map1.keySet();	
	private Klaseis k = new Klaseis();
	private TreeSet<String> tree = k.getKlaseis();
	private Map<String,List<Methods>> newmap = k.createList(tree);	
	private String klasi=null;
	private List<Methods> methods;	
	private int size;	
	private int  i;
	private String name=null;
	private int dot;
	private String classname=null;
	private List<Methods> sum;
	private long synolo=0;
	private long ms=0;
	private int thesi=0;
	private int j;
	
	
	public Map<String,List<Methods>> getSum(){
		System.out.println("Total methods : " +map1.size());
		System.out.println("Number of classes: "+tree.size());
		
		for(String s1 : tree){
			klasi = s1;
			
			
			
			for(String key : methkeys){
				if(key.contains(klasi) && isClass(key,klasi)){
					
					methods=map1.get(key);
				
					size=methods.size();
					if(size==0)
						continue;
					
					
					
					for(j=0;j<size;j++)
					{	
						thesi=j;
						
						name=methods.get(j).getMethod_name();
						
						for (i=0; i<name.length();i++){
							if( name.charAt(i) == '.')
							{
								dot=i;	
								break;
							}
						}
						sum=newmap.get(s1);
						classname=name.substring(0, dot);
						
						
						if(classname.equals(klasi))
							continue;
						for(i=0;i<sum.size();i++){
							if(sum.get(i).getMethod_name().equals(classname)){
								synolo=sum.get(i).getMs();
								ms=methods.get(thesi).getMs();			
								synolo=synolo+ms;
								sum.get(i).setMs(synolo);
								
							}
						}
					 }
				   }
				  }
				}
			
		
		
		
		
		return newmap;
		
	}

private boolean isClass(String s,String klasi){
		
		boolean flag=true;
		//int paren1=s.indexOf('(');
		//int paren2=s.indexOf(')');
		//int kl=s.indexOf(klasi);
		//if(kl<paren2 && kl>paren1)
			//flag=false;
		int dot=s.indexOf('.');
		//if(kl>dot)
			//flag=false;
		String classname=null;
		classname=s.substring(0,dot);
		if(!klasi.equals(classname))
			flag=false;
		
		return flag;
		
		
		
	}





}
