package A;
import java.util.*;

public class OOXX {
	static ArrayList<Integer> playerLocations = new ArrayList<Integer>();
	static ArrayList<Integer> computerLocations = new ArrayList<Integer>();

	public static void main(String[] args) {
		//�{�����h�إߤ����OPlayer
		//�٦��l���OHumanPlayer�MComputerPlayer
		Scanner nameScanner = new Scanner(System.in);
		System.out.print("Please tell me your user name: ");
		HumanPlayer user = new HumanPlayer(nameScanner.nextLine());
		ComputerPlayer computer = new ComputerPlayer("CPU");
		
		char[][] Board = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };

		char[][] BoardNumber = { { '1', '|', '2', '|', '3' }, { '-', '+', '-', '+', '-' }, { '4', '|', '5', '|', '6' },
				{ '-', '+', '-', '+', '-' }, { '7', '|', '8', '|', '9' } };

		 //�o��code�i�H��HumanPlayer���O��user�Q���~�Ӫ��覡�A�ϥ�Player��getName()��k
		System.out.printf("Welcome to the Tic Tac Toe game, %s!\n", user.getName());
		System.out.println("Below is the format of our game board.");
		System.out.println(
				"Plsease select a posotion from 1 to 9 in each round so that we can compete against the computer!");
		printBoard(BoardNumber);

		while (true) {
			System.out.print("\nEnter a number from 1~9 to place your mark: ");
			Scanner scan = new Scanner(System.in);
			int playerPos = scan.nextInt();
			while (playerLocations.contains(playerPos) || computerLocations.contains(playerLocations)
					|| computerLocations.contains(playerPos)) {
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

	public static void placeMark(char[][] gameBoard, int pos, String user) {

		char symbol = ' ';

		if (user.equals("player")) {
			symbol = 'X';
			playerLocations.add(pos);
		} else if (user.equals("computer")) {
			symbol = 'O';
			computerLocations.add(pos);
		}

		switch (pos) {
		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[2][0] = symbol;
			break;
		case 5:
			gameBoard[2][2] = symbol;
			break;
		case 6:
			gameBoard[2][4] = symbol;
			break;
		case 7:
			gameBoard[4][0] = symbol;
			break;
		case 8:
			gameBoard[4][2] = symbol;
			break;
		case 9:
			gameBoard[4][4] = symbol;
			break;
		default:
			break;
		}
	}

	public static String checkVictory() {
		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List botRow = Arrays.asList(7, 8, 9);
		List leftCol = Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 8);
		List rightCol = Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(3, 5, 7);

		List<List> victory = new ArrayList<List>();
		victory.add(topRow);
		victory.add(midRow);
		victory.add(botRow);
		victory.add(leftCol);
		victory.add(midCol);
		victory.add(rightCol);
		victory.add(cross1);
		victory.add(cross2);

		for (List l : victory) {
			if (playerLocations.containsAll(l)) {
				return "Hooray, you won!! d(�P�s�P)b";
			} else if (computerLocations.containsAll(l)) {
				return "Sorry, the computer just won...(��_��)";
			}
		}
		if (playerLocations.size() + computerLocations.size() == 9) {
			return "This is a tie~ (-�s- )";
		}

		return "";
	}

	public static void printBoard(char[][] Board) {
		for (char[] row : Board) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
