import java.awt.Graphics;
import java.awt.Image;

public class GraphicsHero {
	
	final int MOVE_STEP = 10;		// 캐릭터가 움직이는 간격
	final int MAX_X = 400;				// 맵 크기 x(픽셀)
	final int MAX_Y = 300;				// 맵 크기 y(픽셀)
	
	int x;										// 캐릭터 x 좌표값(픽셀)
	int y;										// 캐릭터 y 좌표값(픽셀)
	int dir;										// 캐릭터 방향
	Image img[];							// 캐릭터 이미지를 담기 위한 배열
	int imgWidth = 21;						// 캐릭터 이미지 크기
	int imgHeight = 26;					// 캐릭터 이미지 크기
	boolean jump;
	int jumpCount = 1;

	int count;
	
	public GraphicsHero(int x, int y, Image img[]) {
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
	
	public boolean crush(GraphicsZombie zombie) {
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
	
	public boolean heroUpdate() {
		count++;
		
		if(jump==true) {
			if(jumpCount <= 5) y = y - 10;
			else if (jumpCount <= 10) y = y + 10;
			if(jumpCount==10) {
				jump = false;
				jumpCount = 1;
			}
			else jumpCount++;
		}
		// 목적지 도착 (화면 끝 체크) 
		if(x >= 400-imgWidth) return true;
		else return false;
	}
	// 화면에 그리기
	public void paint(Graphics g) {
		// 캐릭터의 상태에 따라 다른 이미지를 그려줌
		if(dir == 1) {
			if(jump == true)
				g.drawImage(img[2], x, y, null);
			else 
				g.drawImage(img[count%2], x, y, null);
		}
		else if(dir == 2) {
			if(jump == true)
				g.drawImage(img[5], x, y, null);
			else
				g.drawImage(img[count%2+3], x, y, null);
		}
		
		
	}
}
