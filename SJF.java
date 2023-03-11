import java.util.ArrayList;
public class SJF {
	
	public static int[] gnatt_chart(int[] at,int[] bt,int[] p) {
		String s1=new String();
		String s2=new String();
		String s3="             ";
		System.out.println(s3+"---------Gnatt Chart---------");
		s1+=s3+"|";
		s2+=s3+"0";
		ArrayList<Integer> al=new ArrayList<Integer>();
		ArrayList<Integer> al1=new ArrayList<Integer>();
		int[] ft=new int[at.length];
		int time=0;
		int i=0;
		int j=0;
		while (true) {
			for (i=i+1-1;i<at.length;i++) {
				if (at[i]<=time) {
					al.add(bt[i]);
					al1.add(p[i]);
				}
				else {
					break;
				}
			}
			int[] mm=minimum(al,al1);
			time+=mm[0];
			ft[mm[1]]=time;
			j+=1;
			
			s1+=" P"+(mm[1]+1)+" ";
			int c=lengthOfNo(ft[mm[1]]);
			for (int jk=0;jk<c-1;jk++) {
				s1+=" ";
			}
			s1+="|";
			s2+="    "+ft[mm[1]];
			
			
			for (int k=0;k<al.size();k++) {
				if (al.get(k)==mm[0]) {
					al.remove(k);
					break;
				}
			}
			al1.remove(Integer.valueOf(mm[1]+1));
			if (j==at.length) 
				break;
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
	
	public static int[] minimum(ArrayList<Integer> al,ArrayList<Integer> al1) {
		int min=2147483647;
		int pmin=0;
		for (int i=0;i<al.size();i++) {
			if (al.get(i)<min) {
				min=al.get(i);
				pmin=al1.get(i);
			}
		}
		int[] ar= {min,pmin-1};
		return ar;
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
	
	public static void scheduling(int[] at,int[] bt) {
		System.out.println("Shortest Job First(SJF) Scheduling Scheme");
		System.out.println();
		float n=at.length;
		int[] p=new int[(int)n];
		for (int i=1;i<=(int)n;i++) {
			p[i-1]=i;
		}
		int[] ft= gnatt_chart(at,bt,p);
		int[] tr=turnAround(at,ft);
		int[] wt=waitingTime(tr,bt);
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
