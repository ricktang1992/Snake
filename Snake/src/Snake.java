import java.util.LinkedList;

public class Snake {
	private  LinkedList <Dot> body;
	private String direction="left";
	private boolean isLiving= true;
	private Dot apple=new Dot();
	public Dot getApple() {
		return apple;
	}
	public void setApple(Dot apple) {
		this.apple = apple;
	}
	public Snake() {
		body =new LinkedList <>();
		body.add(new Dot(10,10));
		body.add(new Dot(10,11));
		body.add(new Dot(10,12));
		body.add(new Dot(10,13));
		body.add(new Dot(10,14));
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public LinkedList<Dot> getBody() {
		return body;
	}
	public void setBody(LinkedList<Dot> body) {
		this.body = body;
	}
	public void eat() {
		Dot head=body.getFirst();
		if(head.getxValue()==apple.getxValue()&&head.getyValue()==apple.getyValue()) {
			body.addLast(apple);
			apple.random();
			
		}
	}
	public void move() {
		if(isLiving) {
			Dot head=body.getFirst();
			switch(direction) {
			  case "up":
			    body.addFirst(new Dot(head.getxValue(),head.getyValue()-1));
			    break;
			  case "right":
				body.addFirst(new Dot(head.getxValue()+1,head.getyValue()));
				break;
			  case "down":
				body.addFirst(new Dot(head.getxValue(),head.getyValue()+1));
			    break;
			  case "left":
					body.addFirst(new Dot(head.getxValue()-1,head.getyValue()));
				    break;
			}
			int x1=body.getFirst().getxValue();
			int y1=body.getFirst().getyValue();
			for(int index=1;index<body.size();index++) {
				int x2=body.get(index).getxValue();
				int y2=body.get(index).getyValue();
				if(x1==x2&&y1==y2) {
					isLiving=false;
				}
			}
			if(x1<0||x1>29||y1<0||y1>29) {
				isLiving=false;
			}
			if(isLiving)
			body.removeLast();
		}
		
	}

}
