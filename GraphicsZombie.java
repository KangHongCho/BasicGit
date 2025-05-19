import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class GraphicsZombie {
	
	final int MOVE_STEP = 5;		// 캐릭터가 움직이는 간격
	final int MAX_X = 400;				// 맵 크기 x(픽셀)
	final int MAX_Y = 300;				// 맵 크기 y(픽셀)
	
	int x;										// 캐릭터 x 좌표값(픽셀)
	int y;										// 캐릭터 y 좌표값(픽셀)
	int dir;										// 캐릭터 방향
	Image img[];							// 캐릭터 이미지를 담기 위한 배열
	int imgWidth = 20;						// 캐릭터 이미지 크기
	int imgHeight = 20;					// 캐릭터 이미지 크기
	int count;
	boolean toggle;
	Random r = new Random();
	
	public GraphicsZombie(int x, int y, Image img[]) {
		this.x = x;
		this.y = y;
		this.img = img;
	}
	
	public void moveLeft() {
		x = x - MOVE_STEP;
		if(x < 0) x = 0;
	}
	
	public void moveRight() {
		x = x + MOVE_STEP;
		if(x > MAX_X - imgWidth) x = MAX_X - imgWidth;
	}
	
	public void moveUp() {
		y = y - MOVE_STEP;
		if(y < 0) y = 0; 
	}
	
	public void moveDown() {
		y = y + MOVE_STEP;
		if(y > MAX_Y - imgHeight) y = MAX_X - imgHeight;
	}
	
	// 자동으로 움직이기 위한 메소드
	public void randomMove() {
		
		dir = r.nextInt(3);		
		
		if(dir==0);
		else if(dir==1) moveLeft();
		else if(dir==2) moveRight();

		toggle = !toggle;
	}
	
	public boolean crush(GraphicsHero zombie) {
		if(((zombie.x < x) && (x < zombie.x+zombie.imgWidth))&&
		((zombie.y < y) && (y < zombie.y+zombie.imgHeight)))
			return true;
		if(((zombie.x < x+imgWidth) && (x+imgWidth < zombie.x+zombie.imgWidth))&&
				((zombie.y < y) && (y < zombie.y+zombie.imgHeight)))
					return true;
		if(((zombie.x < x) && (x < zombie.x+zombie.imgWidth))&&
				((zombie.y < y+imgHeight) && (y+imgHeight < zombie.y+zombie.imgHeight)))
					return true;
		if(((zombie.x < x+imgWidth) && (x+imgWidth < zombie.x+zombie.imgWidth))&&
				((zombie.y < y+imgHeight) && (y+imgHeight < zombie.y+zombie.imgHeight)))
					return true;
		return false;
	}
	// 화면에 그리기
	public void paint(Graphics g) {
		// 캐릭터의 상태에 따라 다른 이미지를 그려줌
		if(toggle)
			g.drawImage(img[0], x, y, null);
		else
			g.drawImage(img[1], x, y, null);
		
	}
}
