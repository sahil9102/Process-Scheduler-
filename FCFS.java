
public class FCFS {
	public static int [] gnatt_chart(int[] at, int[] bt, int[] p) {
		String s1=new String();
		String s2=new String();
		System.out.println("\t\t---------Gnatt Chart---------");
		s1+="\t\t|";
		s2+="\t\t0";
		int[] ft=new int[at.length];
		for (int i=0;i<at.length;i++) {
			if (i==0) {
				ft[i]=bt[i];
			}
			else {
				ft[i]=bt[i]+ft[i-1];
			}
			s1+=" P"+p[i]+" ";
			int c=lengthOfNo(ft[i]);
			for (int j=0;j<c-1;j++) {
				s1+=" ";
			}
			s1+="|";
			s2+="    "+ft[i];
		}
		System.out.println(s1);
		System.out.println(s2);
		System.out.println();
		System.out.println();
		return ft;
	}
	
	public static int lengthOfNo(int n) {
		int c=0;
		while (n!=0) {
			n=n/10;
			c+=1;
		}
		return c;
	}
	
	public static int[] turnAround(int[] at,int[] ft) {
		int[] tr=new int[at.length];
		for (int i=0;i<at.length;i++) {
			tr[i]=ft[i]-at[i];
		}
		return tr;
	}
	
	public static int[] waitingtime(int[] tr,int[] bt) {
		int[] wt=new int[bt.length];
		for (int i=0;i<bt.length;i++) {
			wt[i]=tr[i]-bt[i];
		}
		return wt;
	}
	
	public static void scheduling(int[] at,int[] bt) {
		System.out.println("First Come First Serve(FCFS) Scheduling Scheme");
		System.out.println();
		float n=at.length;
		int[] p=new int[(int)n];
		for (int i=1;i<=(int)n;i++) {
			p[i-1]=i;
		}
		int[] ft= gnatt_chart(at,bt,p);
		int[] tr=turnAround(at,ft);
		int[] wt=waitingtime(tr,bt);
		int[] rt=wt;
		int atr=0,awt=0,art=0;
		System.out.println("--------------------------------------------------------");
		System.out.println("Process\tArival\tBurst\tTurn Around\tWaiting\tResponse");
		System.out.println("\t Time\tTime\t   Time\t\t Time\t  Time");
		System.out.println("--------------------------------------------------------");
		for (int i=0;i<at.length;i++) {
			System.out.println("   P"+p[i]+"\t  "+at[i]+"\t  "+bt[i]+"\t     "+tr[i]+"\t\t   "+wt[i]+"\t    "+rt[i]);
			atr+=tr[i];
			awt+=wt[i];
			art+=rt[i];
		}
		System.out.println("--------------------------------------------------------");
		System.out.println("\t\tAverage :    "+(float)atr / n+"\t   "+(float)awt / n+"\t    "+(float)art / n);
		System.out.println();
		System.out.println("\tAverage Turn Around Time is "+(float)atr / n);
		System.out.println("\tAverage Waiting Time is "+(float)awt / n);
		System.out.println("\tAverage Response Time is "+(float)art / n);
		System.out.println();
		System.out.println();
	}

}
