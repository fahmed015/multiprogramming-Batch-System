import java.util.LinkedList;
import java.util.Queue;

public class Writesemaphore  {
	
	static boolean a=true;
	static Queue<Process> writeblocked ;
		
	public  Writesemaphore() {
	
		writeblocked = new LinkedList<>(); 
		
	}	
		
	@SuppressWarnings("deprecation")

	public static void semWriteWait(Process c){
		
if(a==true){
			
			
			a=false;
			
			
		}
else{		
		
			
				writeblocked.add(c);
				Process.setProcessState(c,ProcessState.Waiting);
				
				//(OperatingSystem.q).remove(c);
				
				c.suspend();
			
		}
		
	}
	
	public static void semWritePost() {
	
if(writeblocked.isEmpty()==true){
			
			a=true;
		}
		
	else{
				Process p = writeblocked.peek();
				writeblocked.remove();
			Process.setProcessState(p,ProcessState.Ready);
				
				//(OperatingSystem.q).add(p);
				p.resume();

			}

		
		
		
		
		
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
