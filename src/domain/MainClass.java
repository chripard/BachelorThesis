package domain;


import java.io.File;

 
public class MainClass {
	
  public static void main(String[] args) {
	if(args.length==1)
	{
		
			File dir = new File(args[0]);
			if(!dir.exists()){
				System.out.println("Invalid directory.\n");
				System.exit(1);
			}
			else {
				MergeFiles file= new MergeFiles();
				file.mergeFiles(args[0]);
				System.out.println("input ready");
				System.out.println("Scanning file..");
				WriteCSVfile l = new WriteCSVfile();
				
				l.writeCSVfile();
			}						
									
	}
	else {
		System.out.println("No directory given.\nExit.");
		System.exit(1);
	}
	

  }}
