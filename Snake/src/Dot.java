import java.util.Random;

public class Dot {
	private int xValue;
	private int yValue;
	public int getxValue() {
		return xValue;
	}
	public Dot() {
		random();
	}
	public Dot(int xValue, int yValue) {
		this.xValue = xValue;
		this.yValue = yValue;
	}
	public void setxValue(int xValue) {
		this.xValue = xValue;
	}
	public int getyValue() {
		return yValue;
	}
	public void setyValue(int yValue) {
		this.yValue = yValue;
	}
	public void random() {
		Random r=new Random();
		xValue=r.nextInt(30);
		yValue=r.nextInt(30);
	}
}
