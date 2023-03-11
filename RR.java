import java.util.Arrays;

public class RR {
	
	public static int[][] gnatt_chart(int[] at,int[] bt,int[] p,int quantum) {
		String s1=new String();
		String s2=new String();
		String s3="             ";
		System.out.println(s3+"---------Gnatt Chart---------");
		s1+=s3+"|";
		s2+=s3+"0";
		
		int[] ft=new int[at.length];
		int[] fr=new int[at.length];
		for (int i=0;i<at.length;i++) {
			fr[i]=-1;
		}
		int time=0;
		int j=0;
		while (true) {
			for (int i=0;i<at.length;i++) {
				if (bt[i]==0) {
					continue;
				}
				if (bt[i]<=quantum) {
					if (fr[i]==-1) {
						fr[i]=time;
					}
					
					time+=bt[i];
					ft[i]=time;
					j+=1;
					bt[i]=0;
					
					s1+=" P"+(i+1)+" ";
					int c=lengthOfNo(time);
					for (int jk=0;jk<c-1;jk++) {
						s1+=" ";
					}
					s1+="|";
					s2+="    "+time;
					
				}
				else {
					if (fr[i]==-1) {
						fr[i]=time;
					}
					
					bt[i]-=quantum;
					time+=quantum;
					
					s1+=" P"+(i+1)+" ";
					int c=lengthOfNo(time);
					for (int jk=0;jk<c-1;jk++) {
						s1+=" ";
					}
					s1+="|";
					s2+="    "+time;
					
				}
				if (j==at.length)
					break;
			}
			if (j==at.length)
				break;
		}

		System.out.println(s1);
		System.out.println(s2);
		System.out.println();
		System.out.println();
		
		int[][] frt=new int[2][at.length];
		frt[0]=ft;
		frt[1]=fr;
		return frt;
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
	
	public static int[] waitingTime(int[] tr,int[] bt) {
		int[] wt=new int[bt.length];
		for (int i=0;i<bt.length;i++) {
			wt[i]=tr[i]-bt[i];
		}
		return wt;
	}
	
	public static int[] responseTime(int[] fr,int[] at) {
		int[] wt=new int[at.length];
		for (int i=0;i<at.length;i++) {
			wt[i]=fr[i]-at[i];
		}
		return wt;
	}
	
	public static void scheduling(int[] at,int[] bt,int quantum) {
		System.out.println("Round Robin(RR) Scheduling Scheme");
		System.out.println();
		
		float n=at.length;
		int[] p=new int[(int)n];
		for (int i=1;i<=(int)n;i++) {
			p[i-1]=i;
		}
		int[][] frt= gnatt_chart(at,Arrays.copyOf(bt,(int) n),p,quantum);
		
		int[] ft=frt[0];
		int[] fr=frt[1];
		int[] tr=turnAround(at,ft);
		int[] wt=waitingTime(tr,bt);
		int[] rt=responseTime(fr,at);
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
