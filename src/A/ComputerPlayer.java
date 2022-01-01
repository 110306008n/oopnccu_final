package A;
import java.util.*;
public class ComputerPlayer extends Player {
	
	public ComputerPlayer(String name, int victoryNumber) {
		super(name, victoryNumber);
	}

    public void computerBattle(){
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

			Random rand = new Random();
			int computerPos = rand.nextInt(9) + 1;
			while (playerLocations.contains(computerPos) || computerLocations.contains(computerPos)) {
				computerPos = rand.nextInt(9) + 1;
			}

			placeMark(Board, computerPos, "computer");

			printBoard(Board);

			result = checkVictory();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}
		}
    }
}
