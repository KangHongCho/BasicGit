import java.util.*;

public class Zombie extends Unit {
	Random r = new Random();
	
	public Zombie(String name, int pos) {
		super(name, pos);
	}
	public void move() {
		int dir = r.nextInt(3);
		if(dir==0) {
			pos = pos - 1;
			if(pos < 0) pos = 0;
		}
		else if(dir==1) {
			pos = pos + 1;
			if(pos > 20) pos = 20;
		}
		else pos = pos+0;	//제자리에 있
		System.out.println(name+" 현재 위치는 " + pos + "입니다.");
	}
}
