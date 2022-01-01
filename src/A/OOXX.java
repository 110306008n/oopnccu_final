package A;
import java.util.*;

public class OOXX {

	public static void main(String[] args) {
		Scanner nameScanner = new Scanner(System.in);
		Scanner opponentType=new Scanner (System.in);
		System.out.print("Please tell me your user name: ");
		HumanPlayer user = new HumanPlayer(nameScanner.nextLine(),0);
		System.out.print("\nPlease chooose huamn or computer(human for 1 and computer for  2)");
		int chooseNumber=opponentType.nextInt();
		if(chooseNumber==2){
			ComputerPlayer computer = new ComputerPlayer("CPU",0);
			computer.start();
			computer.computerBattle();
		}else if(chooseNumber==1){
			System.out.print("Please tell me your opponent name: ");
			HumanPlayer opponent = new HumanPlayer(nameScanner.nextLine(),0);
			opponent.start();
			opponent.humanBattle();
		}

	}

}
