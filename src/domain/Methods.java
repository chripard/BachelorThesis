package domain;

public class Methods {
	
	private String method_name;
	private long ms;
	
	public Methods(String method_name,long ms){
		this.method_name=method_name;
		this.ms=ms;
		
		
		
	}

	
	
	
	public void setMethod_name(String method_name){
		this.method_name=method_name;
	}
	
	public String getMethod_name()
	{
		return method_name;
	}

	public void setMs(long ms)
	{
		this.ms=ms;
	}
	
	public long getMs(){
		return ms;
		
	}
	
	
	
	
}
