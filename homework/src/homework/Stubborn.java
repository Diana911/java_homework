package homework;

public class Stubborn extends Agent {



	public Stubborn(String opinion, String conformism, int i, int j) {
		super(opinion, conformism, i, j);
	}

	

	@Override
	public void change_opinion() {
		this.setDayNext(this.getOpinion());
		this.addHistory(this.getOpinion());
		
	}

	@Override
	public void polling_neighbors() {
		// TODO Auto-generated method stub
		// ��� ����� ��� ��� ����_��� � ���������
		

	}

	@Override
	public void count_neighbors() {
		
	}


}