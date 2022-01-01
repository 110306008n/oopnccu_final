package A;
import java.util.*;

public class HumanPlayer extends Player {

	public HumanPlayer(String name,int victoryNumber) {
		super(name, victoryNumber);
	}
	
	public void humanBattle(){
        while (true) {
			System.out.print("\nEnter a number from 1~9 to place your mark: ");
			Scanner scan = new Scanner(System.in);
			int playerPos = scan.nextInt();
			while (playerLocations.contains(playerPos) || computerLocations.contains(playerLocations) || computerLocations.contains(playerPos)) {
				System.out.println("Position taken! Enter another position:");
				playerPos = scan.nextInt();
				while (playerLocations.contains(playerPos) || computerLocations.contains(playerPos)) {
					System.out.println("Position taken! Enter another position:");
					playerPos = scan.nextInt();
				}
			}

			placeMark(Board, playerPos, "player");

			String result = checkVictory();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}

			// Random rand = new Random();
			// int computerPos = rand.nextInt(9) + 1;
			// while (playerLocations.contains(computerPos) || computerLocations.contains(computerPos)) {
			// 	computerPos = rand.nextInt(9) + 1;
			// }

			int computerPos = scan.nextInt();
			while (computerLocations.contains(computerPos) || playerLocations.contains(computerLocations) || playerLocations.contains(computerPos)) {
				System.out.println("Position taken! Enter another position:");
				computerPos = scan.nextInt();
				while (computerLocations.contains(computerPos) || playerLocations.contains(computerPos)) {
					System.out.println("Position taken! Enter another position:");
					computerPos = scan.nextInt();
				}
			}

			placeMark(Board, computerPos, "oppponent");

			printBoard(Board);

			result = checkVictory();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}
		}
    }
}
