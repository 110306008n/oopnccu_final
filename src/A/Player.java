package A;

public class Player {
	protected String name;
	protected int victoryNumber = 0;
	
	//�ڦb�Q�ण����main method�ϥΨ�getName�MaddVictory�o��ؤ�k
	
	public Player(String name) {
		this.name = name;
	}

	//�ثeHumanPlayer���Ψ�o��A��ComputerPlayer�S�Ψ�
	public String getName() {
		return name;
	}	
	
	//�ڦb�Q���S����k��p��ӳ��Ƥ]�[�i�{���̡A���~�ӯ���������A���ڦ��I�䤣��ӫ���
	public void addVictory(boolean win) {
		victoryNumber++;
	}

}
