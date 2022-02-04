package homework;

public class Cross extends Agent {



	public Cross(String opinion, String conformism, int i, int j) {
		super(opinion, conformism, i, j);
	}

	

	@Override
	public void change_opinion() {

		int min = 0;
		int max = 4;
		int r = (int)(Math.random() * (max - min + 1) + min);
		if (this.getConformism().equals("Yes")) {
			if (r<this.getQuantity_A()) {
				this.setOpinion("A");
				this.addHistory("A");
			}
			else {
				this.setOpinion("B");
				this.addHistory("B");
			}
		
		}
		
		if (this.getConformism().equals("No")) {
			if (r>this.getQuantity_A()) {
				this.setOpinion("A");
				this.addHistory("A");
			}
			else {
				this.setOpinion("B");
				this.addHistory("B");
			}
		
		}
	}

	@Override
	public void polling_neighbors() {
		// TODO Auto-generated method stub
		// тут будут сет для опин_топ и остальных

		if (this.getI() == 0 & this.getJ() == 0) {
			this.setMopin_right(agents[this.getI()][this.getJ() + 1].getOpinion());
			this.setMopin_bottom(agents[this.getI() + 1][this.getJ()].getOpinion());
		}
		if (this.getI() == 0 & this.getJ() != (agents[this.getI()].length - 1) & this.getJ() != 0) {
			this.setMopin_right(agents[this.getI()][this.getJ() + 1].getOpinion());
			this.setMopin_bottom(agents[this.getI() + 1][this.getJ()].getOpinion());
			this.setMopin_left(agents[this.getI()][this.getJ() - 1].getOpinion());
		}
		if (this.getJ() == (agents[this.getI()].length - 1) & this.getI() == 0) {
			this.setMopin_bottom(agents[this.getI() + 1][this.getJ()].getOpinion());
			this.setMopin_left(agents[this.getI()][this.getJ() - 1].getOpinion());
		}

		if (this.getJ() == 0 & this.getI() != 0 & this.getI() != (agents.length - 1)) {
			this.setMopin_right(agents[this.getI()][this.getJ() + 1].getOpinion());
			this.setMopin_bottom(agents[this.getI() + 1][this.getJ()].getOpinion());
			this.setMopin_top(agents[this.getI() - 1][this.getJ()].getOpinion());
		}
		if (this.getJ() == 0 & this.getI() == (agents.length - 1)) {
			this.setMopin_right(agents[this.getI()][this.getJ() + 1].getOpinion());
			this.setMopin_top(agents[this.getI() - 1][this.getJ()].getOpinion());
		}
		if ((this.getI() == agents.length - 1) & this.getJ() != 0 & this.getJ() != (agents[this.getI()].length - 1)) {
			this.setMopin_right(agents[this.getI()][this.getJ() + 1].getOpinion());
			this.setMopin_left(agents[this.getI()][this.getJ() - 1].getOpinion());
			this.setMopin_top(agents[this.getI() - 1][this.getJ()].getOpinion());
		}
		if ((this.getI() == agents.length - 1) & this.getJ() == (agents[this.getI()].length - 1)) {
			this.setMopin_left(agents[this.getI()][this.getJ() - 1].getOpinion());
			this.setMopin_top(agents[this.getI() - 1][this.getJ()].getOpinion());
		}
		if ((this.getI() != agents.length - 1) & this.getI() != 0 & this.getJ() == (agents[this.getI()].length - 1)) {
			this.setMopin_bottom(agents[this.getI() + 1][this.getJ()].getOpinion());
			this.setMopin_left(agents[this.getI()][this.getJ() - 1].getOpinion());
			this.setMopin_top(agents[this.getI() - 1][this.getJ()].getOpinion());
		}
		if (this.getI() != 0 & this.getI() != agents.length - 1 & this.getJ() != 0 & this.getJ() != agents[this.getI()].length - 1) {
			this.setMopin_bottom(agents[this.getI() + 1][this.getJ()].getOpinion());
			this.setMopin_left(agents[this.getI()][this.getJ() - 1].getOpinion());
			this.setMopin_top(agents[this.getI() - 1][this.getJ()].getOpinion());
			this.setMopin_right(agents[this.getI()][this.getJ() + 1].getOpinion());
		}

	}

	@Override
	public void count_neighbors() {
		// TODO Auto-generated method stub
		// тут будут сет для колА
		int a = 0;
		int b = 0;
		if (this.getMopin_bottom() != null ) {
			
			if (this.getMopin_bottom().equals("A")) {
				a = a + 1;
			}
			
			if (this.getMopin_bottom().equals("B")) {
				b = b + 1;
			}
		}
		
		if (this.getMopin_top() != null ) {
		
			if (this.getMopin_top().equals("A")) {
				a = a + 1;
			}
			if (this.getMopin_top().equals("B")) {
				b = b + 1;
			}
			
		}
		
		if (this.getMopin_right() != null ) {
			
		
			if (this.getMopin_right().equals("A")) {
				a = a + 1;
			}
			if (this.getMopin_right().equals("B")) {
				b = b + 1;
			}
		}
		
		if (this.getMopin_left() != null ) {
			if (this.getMopin_left().equals("A")) {
				a = a + 1;
			}
			if (this.getMopin_left().equals("B")) {
				b = b + 1;
			}
		}
		

			
		

		this.setQuantity_A(a);
		this.setQuantity_B(b);
	}

}
