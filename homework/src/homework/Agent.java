package homework;

import java.util.ArrayList;

public abstract class Agent {
	static Agent[][] agents;
	
	protected String mopinion;
	protected String mconformism;
	private String mopin_top;
	private String mopin_bottom;
	private String mopin_right;
	private String mopin_left;
	private String mopin_bottom_right;
	private String mopin_bottom_light;
	private String mopin_top_right;
	private String mopin_top_light;
	private String mopin_random;
	private ArrayList<String> history = new ArrayList<>();;
	private int quantity_A;
	private int quantity_B;
	private double entropia;
	protected int ii;
	protected int jj;
	protected String mopinionNext;

	public Agent(String opinion, String conformism, int i, int j) {
		mopinion = opinion;
		mconformism = conformism;
		ii = i;
		jj = j;
		
		
	}
	
	public String getDayNext() {
		return mopinionNext;
	}
	
	public void setDayNext(String value) {
		mopinionNext = value;
	}
	
	public int getI() {
		return ii;
	}
	
	public int getJ() {
		return jj;
	}
	
	public double getEntropia() {
		return entropia;
	}
	
	public void setEntropia(double value) {
		entropia = value;
	}
	
	public ArrayList<String> getHistory() {
		return history;
	}
	
	public void addHistory(String value) {
		getHistory().add(value);
	}
	
	public String getOpinion() {
		return mopinion;
	}

	public void setOpinion(String value) {
		mopinion = value;
	}
	
	public String getConformism() {
		return mconformism;
	}
	
	public String getMopin_top() {
		return mopin_top;
	}

	public void setMopin_top(String value) {
		mopin_top = value;
	}

	public String getMopin_bottom() {
		return mopin_bottom;
	}
	
	public String getMopin_random() {
		return mopin_random;
	}
	
	public void setMopin_random(String value) {
		mopin_random = value;
	}

	public void setMopin_bottom(String value) {
		mopin_bottom = value;
	}

	public void setMopin_bottom_right(String value) {
		mopin_bottom_right = value;
	}

	public String getMopin_right() {
		return mopin_right;
	}

	public void setMopin_right(String value) {
		mopin_right = value;
	}

	public String getMopin_left() {
		return mopin_left;
	}

	public void setMopin_left(String value) {
		mopin_left = value;
	}

	public void setMopin_bottom_light(String value) {
		mopin_bottom_light = value;
	}

	public void setMopin_top_right(String value) {
		mopin_top_right = value;
	}

	public void setMopin_top_light(String value) {
		mopin_top_light = value;
	}

	public String getMopin_top_light() {
		return mopin_top_light;
	}

	public String getMopin_top_right() {
		return mopin_top_right;
	}
	
	public String getMopin_bottom_light() {
		return mopin_bottom_light;
	}
	
	public String getMopin_bottom_right() {
		return mopin_bottom_right;
	}
	
	public void setQuantity_A(int value) {
		quantity_A = value;
	}

	public void setQuantity_B(int value) {
		quantity_B = value;
	}

	public int getQuantity_A() {
		return quantity_A;
	}
	
	public int getQuantity_B() {
		return quantity_B;
	}

	public abstract void change_opinion();

	public abstract void polling_neighbors();

	public abstract void count_neighbors();
	
	public void entr() {
		double a = 0;
		double b = 0;
		double s = 0;
		for (String o : this.getHistory())
		{
		    if (o.equals("A")) {
		    	a++;		    	
		    }
		    if (o.equals("B")) {
		    	b++;		    	
		    }
		}
		s = -(a/(a+b)*Math.log(a/(a+b))+b/(a+b)*Math.log(b/(a+b)));
		this.setEntropia(s);
	}
	
	
}
