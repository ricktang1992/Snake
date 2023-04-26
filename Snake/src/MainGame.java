
import java.util.Timer;
import java.util.TimerTask;

public class MainGame {

	public static void main(String[] args) {
		Snake snake=new Snake();
		MainFrame mainFrame=new MainFrame(600,600,snake);
		Timer timer=new Timer();
		KeyChecker keyChecker=new KeyChecker(snake);
		TimerTask timerTask=new TimerTask(){
			public void run() {
				snake.move();
				snake.eat();
				mainFrame.repaint();
				mainFrame.setBackGround();
				mainFrame.drawSnake(snake);
				mainFrame.drawApple(snake);
			}
		};
		timer.scheduleAtFixedRate(timerTask, 50, 300);
		mainFrame.addKeyListener(keyChecker);
		
	}
	
}
