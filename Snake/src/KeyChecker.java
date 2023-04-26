import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyChecker extends KeyAdapter {
		private Snake snake=new Snake();
		public KeyChecker(Snake snake) {
			this.snake=snake;
		}
	    @Override
	    public void keyPressed(KeyEvent event) {
	    	String deriction=snake.getDirection();
	        int code = event.getKeyCode();
	        switch(code) {
			  case 38:
				if(deriction!="down")
				snake.setDirection("up");
			    break;
			  case 39:
				if(deriction!="left")
				snake.setDirection("right");
				break;
			  case 40:
				if(deriction!="up")
				snake.setDirection("down");
			    break;
			  case 37:
				if(deriction!="right")
				snake.setDirection("left");
				break;
			}
	        
	        System.out.println(code);//test
	    } 
}
