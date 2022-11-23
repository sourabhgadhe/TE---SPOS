import java.util.*;
public class Main
{
	public static int refPage[],frame[]= {-1,-1,-1},no,pageFault=0,pageHit=0,front=0;
	public static void MRU() {
		for(int i=0;i<no;i++) {
			boolean isFull=false;
			for(int j=0;j<3;j++) {
				if(frame[j]==-1) {
					frame[j]=refPage[i];
					pageFault++;
					break;
				}else if(frame[j]==refPage[i]) {
					pageHit++;
					break;
				}
				if(j==2) {
					isFull=true;
				}
			}
			if(isFull) {
				int close1=refPage[(i-1)];
				for(int k=0;k<3;k++) {
					if(frame[k]==close1) {
						frame[k]=refPage[i];
						pageFault++;
						break;
					}
				}
				
			}
			
			display();
		}
		System.out.println("Page Fault="+pageFault);
		System.out.println("Page Hit="+pageHit);
	}
	
	public static void display() {
		System.out.println("Frames Content:");
		for(int i=0;i<3;i++) {
			System.out.println(frame[i]);
		}
	}
	
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of Pages=");
		no=sc.nextInt();
		refPage=new int[no];
		System.out.println("\nEnter Pages:");
		for(int i=0;i<no;i++) {
			refPage[i]=sc.nextInt();
		}
		MRU();
		
		sc.close();
	}
}

