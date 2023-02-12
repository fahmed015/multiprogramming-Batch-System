//import java.util.concurrent.Semaphore;


public class Process extends Thread {
	
	public int processID;
    ProcessState status=ProcessState.New;
   
	
	public Process(int m) {
		processID = m;
	
	}
	@Override
	public void run() {
		
		
		
		switch(processID)
		{
		case 1:process1();break;
		case 2:process2();break;
		case 3:process3();break;
		case 4:process4();break;
		case 5:process5();break;
		}
		
		
		
		
		

	}
	
	private void process1() {
		Printsemaphore.semPrintWait(this);
		OperatingSystem.printText("Enter File Name: ");
		Printsemaphore.semPrintPost();
		
		Textsemaphore.semTextWait(this);
		String filename=OperatingSystem.TakeInput();
		Textsemaphore.semTextPost();
		
		Readsemaphore.semReadWait(this);
		String data=OperatingSystem.readFile(filename)  ;
		Readsemaphore.semReadPost();
		
	
		Printsemaphore.semPrintWait(this);
		OperatingSystem.printText(data );
		Printsemaphore.semPrintPost();
		
		
		
		
		setProcessState(this,ProcessState.Terminated);
		
		
		}
	
	private void process2() {
		Printsemaphore.semPrintWait(this);
		OperatingSystem.printText("Enter File Name: " );
		Printsemaphore.semPrintPost();
		
		Textsemaphore.semTextWait(this);
		String filename= OperatingSystem.TakeInput();
		Textsemaphore.semTextPost();
		
		Printsemaphore.semPrintWait(this);
		OperatingSystem.printText("Enter Data: "  );
		Printsemaphore.semPrintPost();
		
		
		Textsemaphore.semTextWait(this);
		String data= OperatingSystem.TakeInput();
		Textsemaphore.semTextPost();
		
		Writesemaphore.semWriteWait(this);
		OperatingSystem.writefile(filename,data);
		Writesemaphore.semWritePost();
		
		setProcessState(this,ProcessState.Terminated);
		}
	private void process3() {
		Printsemaphore.semPrintWait(this);
		int x=0;
		while (x<301)
		{ 
			
			OperatingSystem.printText(x+"\n" );
			
			x++;
		}
		
		Printsemaphore.semPrintPost();
				setProcessState(this,ProcessState.Terminated);
		}
	
	private void process4() {
		Printsemaphore.semPrintWait(this);
		int x=500;
		while (x<1001)
		{
			
			OperatingSystem.printText(x+"\n" );
			
			x++;
		}	
		
		Printsemaphore.semPrintPost();
		
		setProcessState(this,ProcessState.Terminated);
		}
	private void process5() {
		
		Printsemaphore.semPrintWait(this);
		OperatingSystem.printText("Enter LowerBound: " );
		Printsemaphore.semPrintPost();
		
		Textsemaphore.semTextWait(this);
		String lower= OperatingSystem.TakeInput();
		Textsemaphore.semTextPost();
		
		
		Printsemaphore.semPrintWait(this);
		OperatingSystem.printText("Enter UpperBound: " );
		Printsemaphore.semPrintPost();
		
		Textsemaphore.semTextWait(this);
		String upper= OperatingSystem.TakeInput();
		Textsemaphore.semTextPost();
		
		
	int lowernbr=Integer.parseInt(lower);
		int uppernbr=Integer.parseInt(upper);
		String data="";
		
		while (lowernbr<=uppernbr)
		{
			data+=lowernbr++ +"\n";
	}	
		Writesemaphore.semWriteWait(this);
		OperatingSystem.writefile("P5.txt", data);
		Writesemaphore.semWritePost();
		
		setProcessState(this,ProcessState.Terminated);
	}
	
	 public static void setProcessState(Process p, ProcessState s) {
		 p.status=s;
		 if (s == ProcessState.Terminated)
		 {
			 OperatingSystem.ProcessTable.remove(OperatingSystem.ProcessTable.indexOf(p));
		 }
	}
	 
	 public static ProcessState getProcessState(Process p) {
		 return p.status;
	}
}
