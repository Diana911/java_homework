package homework;

public class Whole extends Agent {



	public Whole(String opinion, String conformism, int i, int j) {
		super(opinion, conformism, i, j);
	}

	

	@Override
	public void change_opinion() {
		if (this.getConformism().equals("Yes")) {
			this.setOpinion(this.getMopin_random());
			this.addHistory(this.getMopin_random());
		}
		
		if (this.getConformism().equals("No")) {
			if (this.getMopin_random().equals("A")) {
				this.setOpinion("B");
				this.addHistory("B");
			}
			else {
				this.setOpinion("A");
				this.addHistory("A");
			}
		}
		
		
	}

	@Override
	public void polling_neighbors() {
		// TODO Auto-generated method stub
		// тут будут сет для опин_топ и остальных
		
		int imin = 0;
		int imax = 2;
		int jmin = 0;
		int jmax = 2;
		int ii = (int)(Math.random() * (imax - imin + 1) + imin);
		int jj = (int)(Math.random() * (jmax - jmin + 1) + jmin);
		
		this.setMopin_random(agents[ii][jj].getOpinion());
		
	}

	@Override
	public void count_neighbors() {
		
	}


}
