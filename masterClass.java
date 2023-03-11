import java.util.Scanner;
public class masterClass {

	public static void main(String[] args) {
		
		System.out.println("---------------Scheduling---------------");
		Scanner sc=new Scanner(System.in);
		while (true) {
			System.out.println("1. First Come First Serve (FCFS)");
			System.out.println("2. Shortest Job First (SJF)");
			System.out.println("3. Shortest Remaining Time First (SRTF)");
			System.out.println("4. Round Robin (RR)");
			System.out.println("5. Exit");
			System.out.print("Enter your choice(1,2,3,4,5): ");
			int choice=sc.nextInt();
			if (choice==5) {
				break;
			}
			System.out.print("Enter no. of processes: ");
			int n=sc.nextInt();
			System.out.print("Enter the arrival time's for "+n+" processes: ");
			int[] at=new int[n];
			for (int i=0;i<n;i++) {
				at[i]=sc.nextInt();
			}
			System.out.print("Enter the cpu burst time's for "+n+" processes: ");
			int[] bt=new int[n];
			for (int i=0;i<n;i++) {
				bt[i]=sc.nextInt();
			}
			if (choice==1) {
				FCFS.scheduling(at, bt);
			}
			else if (choice==2) {
				SJF.scheduling(at, bt);
			}
			else if (choice==3) {
				SRTF.scheduling(at, bt);
			}
			else if (choice==4) {
				System.out.print("Enter time quantum: ");
				int tq=sc.nextInt();
				RR.scheduling(at, bt, tq);
			}
			else {
				System.out.println("Wrong input");
			}
		}
		sc.close();
	}
}
