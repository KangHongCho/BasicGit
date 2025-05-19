
public abstract class Unit {
	protected int pos;
	String name;
	
	public Unit(String name, int pos) {
		this.name = name;
		this.pos = pos;
	}
	
	public void left(){
		pos = pos - 1;
		if(pos < 0) pos = 0;
	}
	
	public void right() {
		pos = pos + 1;
		if(pos > 20) pos = 20;
	}
	
	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	// 추상메소드 
	public abstract void move();
}
